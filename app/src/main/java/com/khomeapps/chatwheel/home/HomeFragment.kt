package com.khomeapps.chatwheel.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.khomeapps.chatwheel.R
import com.khomeapps.chatwheel.base.BaseFragment
import com.khomeapps.chatwheel.databinding.FragmentHomeBinding
import com.khomeapps.chatwheel.handlers.NakamaSessionManager

/**
 * Created by kubilaay on 2019-05-18.
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    val homeViewModel = HomeViewModel()

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun getFragmentViewModel(): HomeViewModel = homeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = homeViewModel

    }

    override fun onResume() {
        super.onResume()
        val testObserver = Observer<String> { test ->
            val acc = NakamaSessionManager.client.getAccount(NakamaSessionManager.session?: NakamaSessionManager.client.authenticateCustom("Emulator").get())
            Log.d("ACC",acc::class.java.simpleName)
        }

        viewModel?.mTest?.observe(this, testObserver)
    }
}