package com.kotlin.ytpractice.onboarding.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kotlin.ytpractice.R
import com.kotlin.ytpractice.base.AfterCareFragment
import com.kotlin.ytpractice.databinding.SignupFragmentBinding

/**
 * Created by Charles Raj I on 28/05/23.
 * @author Charles Raj I
 */
class SignUpFragment: AfterCareFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var signupFragmentBinding: SignupFragmentBinding;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        signupFragmentBinding = DataBindingUtil.inflate<SignupFragmentBinding>(LayoutInflater.from(context),
            R.layout.signup_fragment,container,false
        )




        return signupFragmentBinding.root
    }
}