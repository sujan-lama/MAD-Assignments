package com.miu.mdp.ui.start

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.miu.mdp.databinding.ActivityStartBinding
import com.miu.mdp.ui.home.HomeActivity
import com.miu.mdp.ui.login.LoginActivity
import com.miu.mdp.ui.start.state.StartUiState
import com.miu.mdp.ui.start.viewmodel.StartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    private var _binding: ActivityStartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        _binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.checkLogin()
        lifecycleScope.launchWhenStarted {
            viewModel.startUiState.collect { uiState ->
                when (uiState) {
                    is StartUiState.LoggedIn -> {
                        val intent = HomeActivity.newInstance(this@StartActivity)
                        intent.putExtra("email", uiState.email)
                        startActivity(intent)
                        finish()
                    }
                    is StartUiState.LoggedOut -> {
                        startActivity(LoginActivity.newInstance(this@StartActivity))
                        finish()
                    }
                    else -> Unit
                }
            }
        }
    }
}