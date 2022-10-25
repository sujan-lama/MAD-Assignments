package com.miu.mdp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.model.User
import com.miu.mdp.shopping.ShoppingCategoryActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val usersList = mutableListOf(
        User("Sujan", "Lama", "sujan@gmail.com", "123456"),
        User("Jane", "Doe", "janedoe@gmail.com", "123456"),
        User("John", "Smith", "johnsmith@gmail.com", "123456"),
        User("Jane", "Smith", "janesmith@gmail.com", "123456"),
        User("John", "Doe", "johndoe@gmail.com", "123456")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forgotPasswordTextView.setOnClickListener {
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
        }

        signInButton.setOnClickListener {
            if (emailEditText.text.toString().isEmpty()) {
                emailEditText.error = "Email is required"
                return@setOnClickListener
            }

            if (passwordEditText.text.toString().isEmpty()) {
                passwordEditText.error = "Password is required"
                return@setOnClickListener
            }

            val user = usersList.find {
                it.username == emailEditText.text.toString() && it.password == passwordEditText.text.toString()
            }
            if (user != null) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(ShoppingCategoryActivity.newInstance(this, user.username))
                return@setOnClickListener
            }
            Toast.makeText(
                this,
                "Login Failed. Please check your email and password",
                Toast.LENGTH_SHORT
            ).show()
        }

        createAccountButton.setOnClickListener {
            Toast.makeText(this, "Create Account Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}