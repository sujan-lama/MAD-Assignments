package com.miu.mdp.ui.login

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.miu.mdp.databinding.ActivityLoginBinding
import com.miu.mdp.ui.login.state.LoginUiState
import com.miu.mdp.ui.login.viewmodel.LoginViewModel
import com.miu.mdp.utils.validateEmail
import com.miu.mdp.utils.validatePassword
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener {
            val username = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()


            val validateEmail = binding.emailTextInputLayout.validateEmail()
            if (!validateEmail) {
                return@setOnClickListener
            }

            val validatePassword = binding.passwordTextInputLayout.validatePassword()
            if (!validatePassword) {
                return@setOnClickListener
            }

            viewModel.login(username, password)
        }
        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                when (it) {
                    is LoginUiState.Success -> {
                        binding.signInButton.visibility = View.INVISIBLE
                        binding.progressBar.isVisible = false
                        Snackbar.make(binding.root, "Login success", Snackbar.LENGTH_SHORT).show()
                    }
                    is LoginUiState.Error -> {
                        binding.signInButton.visibility = View.VISIBLE
                        binding.progressBar.isVisible = false
                        Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()
                    }
                    is LoginUiState.Loading -> {
                        binding.signInButton.visibility = View.INVISIBLE
                        binding.progressBar.isVisible = true
                    }
                    else -> Unit
                }
            }
        }
    }
}