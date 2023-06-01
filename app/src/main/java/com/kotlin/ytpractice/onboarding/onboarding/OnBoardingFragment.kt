package com.kotlin.ytpractice.onboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kotlin.ytpractice.base.AfterCareFragment
import com.kotlin.ytpractice.R
import com.kotlin.ytpractice.base.AfterCareActivity
import com.kotlin.ytpractice.base.AfterCareFragmentManager
import com.kotlin.ytpractice.base.AfterCareFragmentTag
import com.kotlin.ytpractice.databinding.OnboardingFragmentBinding

/**
 * Created by Charles Raj I on 17/05/23.
 * @author Charles Raj I
 */
class OnBoardingFragment: AfterCareFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginActivityBinding = DataBindingUtil
            .inflate<OnboardingFragmentBinding>(LayoutInflater.from(context),R.layout.onboarding_fragment,container,false)
        changeStatusBarColor(activity,R.color.baseLight)

        loginActivityBinding.joinNowBtn.setOnClickListener{
            AfterCareFragmentManager.instance().updateFragment(AfterCareFragmentTag.SIGNUP,
                activity as AfterCareActivity
            )
        }
        loginActivityBinding.alreadyHaveAnAccount.setOnClickListener{

        }

        return loginActivityBinding.root
    }
}