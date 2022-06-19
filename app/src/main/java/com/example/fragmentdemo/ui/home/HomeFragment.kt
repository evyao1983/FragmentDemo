package com.example.fragmentdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fragmentdemo.R
import com.example.fragmentdemo.status.LoginStatus
import com.example.fragmentdemo.ui.BaseFragment


class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!LoginStatus.instance.getLoginStatue()) {
            view.findViewById<Button>(R.id.bt_login).visibility = View.VISIBLE
            view.findViewById<Button>(R.id.bt_login).setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}