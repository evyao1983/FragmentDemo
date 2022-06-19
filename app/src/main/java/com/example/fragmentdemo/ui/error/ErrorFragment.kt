package com.example.fragmentdemo.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentdemo.R
import com.example.fragmentdemo.ui.BaseFragment

class ErrorFragment : BaseFragment() {

    companion object {
        fun newInstance() = ErrorFragment()
    }

    private lateinit var viewModel: ErrorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ErrorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}