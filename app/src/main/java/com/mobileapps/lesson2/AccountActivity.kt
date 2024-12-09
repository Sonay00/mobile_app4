package com.mobileapps.lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var registerNowTextView: TextView

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        initViews()
        setListeners()
    }

    private fun initViews() {
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        nextButton = findViewById(R.id.nextButton)
        registerNowTextView = findViewById(R.id.registerNowTextView)
    }

    private fun setListeners() {
        nextButton.setOnClickListener {
            validateCredentialsAndProceed()
        }

        registerNowTextView.setOnClickListener {
            navigateToSignUpActivity()
        }
    }

    private fun validateCredentialsAndProceed() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (!credentialsManager.isEmailValid(email)) {
            emailEditText.error = "Invalid email address"
            return
        }

        if (!credentialsManager.isPasswordValid(password)) {
            passwordEditText.error = "Password cannot be empty"
            return
        }

        showToast("Login Successful")
        navigateToSignUpActivity()
    }

    private fun navigateToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
