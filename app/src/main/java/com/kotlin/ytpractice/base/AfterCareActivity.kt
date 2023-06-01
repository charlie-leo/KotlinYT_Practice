package com.kotlin.ytpractice.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by Charles Raj I on 19/05/23.
 * @author Charles Raj I
 */
open class AfterCareActivity: AppCompatActivity() {


    open fun updateFragment(
        supportFragmentManager: FragmentManager,
        rootLayout: Int,
        fragmentTag: Fragment
    ) {
        supportFragmentManager
            .beginTransaction()
            .replace(rootLayout, fragmentTag)
            .commitAllowingStateLoss()
    }

}