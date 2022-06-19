package com.example.fragmentdemo.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.fragmentdemo.R
import com.example.fragmentdemo.status.LoginStatus
import com.example.fragmentdemo.ui.BaseFragment

class ProfileFragment : BaseFragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var username = arguments?.getString("username")
        view.findViewById<TextView>(R.id.tv_profile).text = username
        view.findViewById<Button>(R.id.search).setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_searchFragment)
        }
        view.findViewById<Button>(R.id.bt_logoff).setOnClickListener{
            LoginStatus.instance.setLoginStatus(false)
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }
}