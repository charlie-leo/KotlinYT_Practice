package com.kotlin.ytpractice.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.kotlin.ytpractice.R
import com.kotlin.ytpractice.onboarding.onboarding.OnBoardingFragment
import com.kotlin.ytpractice.onboarding.signup.SignUpFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Charles Raj I on 24/05/23.
 * @author Charles Raj I
 */
class AfterCareFragmentManager {

    companion object {
        fun instance(): AfterCareFragmentManager {
            return AfterCareFragmentManager()
        }
    }

    private fun getFragment(afterCareFragmentTag: AfterCareFragmentTag): AfterCareFragment{
        val fragment: AfterCareFragment;
        when(afterCareFragmentTag){
            AfterCareFragmentTag.ON_BOARDING -> fragment = OnBoardingFragment()
            AfterCareFragmentTag.SIGNUP -> fragment = SignUpFragment()
            else -> {
                fragment = OnBoardingFragment()
            }
        }

        return fragment
    }

    private fun getFragmentManager(activity: AfterCareActivity): FragmentManager {
        return activity.supportFragmentManager
    }

    private fun setUpFragmentManager(fragmentManager: FragmentManager):FragmentTransaction {
        return fragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right)
    }

    fun updateFragment(afterCareFragmentTag: AfterCareFragmentTag, afterCareActivity: AfterCareActivity){
        updateFragmentWithBundle(afterCareFragmentTag,afterCareActivity,false,null,null,null)
    }

    fun updateFragmentWithBundle(
        afterCareFragmentTag: AfterCareFragmentTag,
        afterCareActivity: AfterCareActivity,
        needBackStack: Boolean,
        container: View?,
        bundle: Bundle?,
        title: String?
    ){
        val afterCareFragment = getFragment(afterCareFragmentTag)
        afterCareFragment.let { fragment: AfterCareFragment ->
            container.let { view ->
                afterCareFragment.arguments = bundle
                replaceFragment(fragment, afterCareActivity,afterCareFragmentTag, needBackStack,
                    view, bundle, title
                )
            }

        }
    }

    private fun replaceFragment(
        afterCareFragment: AfterCareFragment,
        afterCareActivity: AfterCareActivity,
        afterCareFragmentTag: AfterCareFragmentTag,
        needBackStack: Boolean,
        container: View?,
        bundle: Bundle?,
        title: String?
    ){
        CoroutineScope(Dispatchers.Main).launch {
            val fragmentManager = getFragmentManager(activity = afterCareActivity)
            val fragmentTransaction = setUpFragmentManager(fragmentManager)
            container?.let {its->
                fragmentTransaction.replace(its.id,afterCareFragment,afterCareFragmentTag.toString())
            }.run {
                fragmentTransaction.replace(R.id.mainFrameLayout,afterCareFragment,afterCareFragmentTag.toString())
            }
            if (needBackStack){
                fragmentTransaction.addToBackStack(afterCareFragmentTag.toString())
            }
            fragmentManagerExecution(fragmentTransaction,fragmentManager)
        }
    }

    private fun fragmentManagerExecution(fragmentTransaction: FragmentTransaction, fragmentManager: FragmentManager){
        try{
            fragmentTransaction.commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }catch (e:Exception){
            Log.d("TAG", e.toString())
        }
    }

}