package com.kotlin.ytpractice.onboarding

import androidx.databinding.BaseObservable

/**
 * Created by Charles Raj I on 11/03/23.
 * @author Charles Raj I
 */
data class BindingData(
    var name: String = "",
    var email: String = "",
    var mobileNumber: String = "",
    var password: String = ""
    ): BaseObservable()  {
}
