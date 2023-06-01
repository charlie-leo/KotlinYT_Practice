package com.kotlin.ytpractice.base

import android.app.Activity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.kotlin.ytpractice.R

/**
 * Created by Charles Raj I on 19/05/23.
 * @author Charles Raj I
 */
open class AfterCareFragment: Fragment() {


    fun getFragmentActivity(): AfterCareActivity? {
        return this.activity as AfterCareActivity?
    }


    /**
     * All Global static class will be in the below companion object.
     */

    companion object {
        fun changeStatusBarColor(activity: Activity?, color: Int) {
            activity?.window?.statusBarColor =
                activity?.let { ContextCompat.getColor(it, color) }!!
        }
    }

}