package com.example.fragmentdemo.ui.login

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fragmentdemo.R
import com.example.fragmentdemo.status.LoginStatus
import com.example.fragmentdemo.ui.BaseFragment

class LoginFragment : BaseFragment() {
    private lateinit var viewModel: LoginViewModel

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var username = view.findViewById(R.id.et_username) as EditText
        var password = view.findViewById(R.id.et_password) as EditText
        view.findViewById<Button>(R.id.Login).setOnClickListener{
            checkLogin(username.text, password.text)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun checkLogin(key: Editable, value: Editable) {
        if (LoginStatus.instance.checkLogin(key.toString(), value.toString())) {
            val bundle = bundleOf("username" to key.toString())
            findNavController().navigate(R.id.action_loginFragment_to_profileFragment, bundle)
        } else {
            Toast.makeText(context, R.string.login_fail, Toast.LENGTH_LONG).show()
        }
    }
}