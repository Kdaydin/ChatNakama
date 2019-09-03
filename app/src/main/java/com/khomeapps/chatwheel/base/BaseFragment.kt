package com.khomeapps.chatwheel.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Created by kubilaay on 2019-05-20.
 */
abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment() {
    var viewModel: VM? = null
    var binding: DB? = null

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getFragmentViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getFragmentViewModel()::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutRes(), container, false)
        return binding!!.root
    }
}