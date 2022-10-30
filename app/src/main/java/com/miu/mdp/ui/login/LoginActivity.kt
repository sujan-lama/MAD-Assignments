package com.miu.mdp.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.miu.mdp.databinding.ActivityLoginBinding
import com.miu.mdp.ui.home.HomeActivity
import com.miu.mdp.ui.login.state.LoginUiState
import com.miu.mdp.ui.login.viewmodel.LoginViewModel
import com.miu.mdp.ui.register.RegisterActivity
import com.miu.mdp.utils.hideKeyboard
import com.miu.mdp.utils.validateEmail
import com.miu.mdp.utils.validatePassword
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LoginActivity"

        fun newInstance(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

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
            hideKeyboard()
        }

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
                    val user = data?.getStringExtra("username")
                    binding.emailEditText.setText(user)
                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()
                }
            }

        binding.createAccountButton.setOnClickListener {
            resultLauncher.launch(RegisterActivity.newInstance(this))
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                when (it) {
                    is LoginUiState.Success -> {
                        binding.signInButton.visibility = View.VISIBLE
                        binding.progressBar.isVisible = false
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT)
                            .show()
                        val intent = HomeActivity.newInstance(this@LoginActivity)
                        startActivity(intent)
                        finish()
                    }
                    is LoginUiState.Error -> {
                        binding.signInButton.visibility = View.VISIBLE
                        binding.progressBar.isVisible = false
                        val snackbar =
                            Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT)
                        snackbar.view.setBackgroundColor(
                            ResourcesCompat.getColor(
                                resources,
                                android.R.color.holo_red_dark,
                                null
                            )
                        )
                        snackbar.show()
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}