package com.khomeapps.chatwheel.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.khomeapps.chatwheel.R
import com.khomeapps.chatwheel.databinding.ActivityMainBinding


/**
 * Created by kubilaay on 2019-05-18.
 */
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private val _TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        drawerLayout = binding.drawerLayout

        // Set up navigation menu
        binding.navigationView.setupWithNavController(navController)

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}