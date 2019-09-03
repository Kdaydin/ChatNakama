package com.khomeapps.chatwheel.splash

import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseUser
import com.khomeapps.chatwheel.DataManager
import com.khomeapps.chatwheel.R
import com.khomeapps.chatwheel.base.BaseFragment
import com.khomeapps.chatwheel.base.MainActivity
import com.khomeapps.chatwheel.databinding.FragmentSplashBinding
import com.khomeapps.chatwheel.handlers.NakamaSessionManager

/**
 * Created by kubilaay on 2019-05-18.
 */
class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_splash

    override fun getFragmentViewModel(): SplashViewModel = SplashViewModel()

    override fun onResume() {
        super.onResume()
        val loginObserver = Observer<FirebaseUser> { user ->
            if (user == null) {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            } else {
                NakamaSessionManager.start("Emulator", activity as MainActivity)
                DataManager.user = user
                (activity as MainActivity).navController.navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }

        viewModel?.mCurrUser?.observe(this, loginObserver)

        viewModel?.logUserIn()
    }
}