package com.kotlin.ytpractice.onboarding

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kotlin.ytpractice.base.AfterCareActivity
import com.kotlin.ytpractice.R
import com.kotlin.ytpractice.base.AfterCareFragmentManager
import com.kotlin.ytpractice.base.AfterCareFragmentTag
import com.kotlin.ytpractice.databinding.BoardingActivityBinding
import kotlinx.coroutines.*

class BoardingActivity : AfterCareActivity() {

    private val job =  SupervisorJob()
    private val ioScope by lazy { CoroutineScope(job + Dispatchers.IO) }
    private lateinit var activityMainBinding: BoardingActivityBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.boarding_activity);

        AfterCareFragmentManager.instance().updateFragment(AfterCareFragmentTag.ON_BOARDING, this)

    }

}