package com.miu.mdp.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.miu.mdp.databinding.ActivityRegisterBinding
import com.miu.mdp.ui.login.LoginActivity
import com.miu.mdp.ui.register.state.RegisterUiState
import com.miu.mdp.ui.register.viewmodel.RegisterViewModel
import com.miu.mdp.utils.hideKeyboard
import com.miu.mdp.utils.validateEmail
import com.miu.mdp.utils.validateEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    companion object {
        const val TAG = "RegisterActivity"

        fun newInstance(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val intent = LoginActivity.newInstance(this)
            startActivity(intent)
            finish()
        }
        
        binding.back.setOnClickListener {
            onBackPressed()
        }

        binding.createAccountButton.setOnClickListener {

            val validateFirstName = binding.firstNameInputLayout.validateEmpty()
            val validateLastName = binding.lastNameInputLayout.validateEmpty()
            val validateUsername = binding.emailTextInputLayout.validateEmail()
            val validatePassword = binding.passwordTextInputLayout.validateEmpty()

            if (!validateFirstName || !validateLastName || !validateUsername || !validatePassword) {
                return@setOnClickListener
            }

            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val username = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.register(firstName, lastName, username, password)
            hideKeyboard()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.registerUiState.collect { state ->
                when (state) {
                    is RegisterUiState.Success -> {
                        binding.progressBar.isVisible = false
                        binding.createAccountButton.visibility = View.VISIBLE
                        Toast.makeText(
                            this@RegisterActivity,
                            "Register Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        val data = Intent()
                        data.putExtra("username", binding.emailEditText.text.toString())
                        setResult(RESULT_OK, data)
                        finish()
                    }
                    is RegisterUiState.Error -> {
                        binding.progressBar.isVisible = false
                        binding.createAccountButton.visibility = View.VISIBLE
                        val snackbar =
                            Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT)
                        snackbar.view.setBackgroundColor(
                            ResourcesCompat.getColor(
                                resources,
                                android.R.color.holo_red_dark,
                                null
                            )
                        )
                        snackbar.show()
                    }
                    is RegisterUiState.Loading -> {
                        binding.createAccountButton.visibility = View.INVISIBLE
                        binding.progressBar.isVisible = true
                    }
                    is RegisterUiState.Empty -> {
                        binding.createAccountButton.visibility = View.VISIBLE
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED)
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}