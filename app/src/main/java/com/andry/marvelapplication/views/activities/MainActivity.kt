package com.andry.marvelapplication.views.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.andry.marvelapplication.R
import com.andry.marvelapplication.viewmodels.MainViewModel
import com.andry.marvelapplication.views.fragments.ComicsListFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val TAG = this.javaClass.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureSplashScreen()
        setContentView(R.layout.activity_main)
        configureComicsListFragment()
    }

    private fun configureSplashScreen() {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
    }

    private fun configureComicsListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ComicsListFragment())
            .commit()
    }
}