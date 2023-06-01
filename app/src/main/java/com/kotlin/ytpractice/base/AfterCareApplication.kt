package com.kotlin.ytpractice.base
import android.app.Application


/**
 * Created by Charles Raj I on 19/05/23.
 * @author Charles Raj I
 */
class AfterCareApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun registerActivityLifecycleCallbacks(callback: ActivityLifecycleCallbacks?) {
        super.registerActivityLifecycleCallbacks(callback)

    }

    override fun unregisterActivityLifecycleCallbacks(callback: ActivityLifecycleCallbacks?) {
        super.unregisterActivityLifecycleCallbacks(callback)
    }
}