package com.mobileapps.lesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var fullNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var termsCheckBox: CheckBox
    private lateinit var nextButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        setListeners()
    }

    private fun initViews() {
        fullNameEditText = findViewById(R.id.fullNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        termsCheckBox = findViewById(R.id.termsCheckBox)
        nextButton = findViewById(R.id.nextButton)
        loginTextView = findViewById(R.id.loginTextView)
    }

    private fun setListeners() {
        nextButton.setOnClickListener {
            validateInput()
        }

        loginTextView.setOnClickListener {
            navigateToAccountActivity()
        }
    }

    private fun validateInput() {
        val fullName = fullNameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val phoneNumber = phoneNumberEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val confirmPassword = confirmPasswordEditText.text.toString().trim()

        when {
            fullName.isEmpty() -> showToast("Please enter your full name")
            email.isEmpty() -> showToast("Please enter your email")
            phoneNumber.isEmpty() -> showToast("Please enter your phone number")
            password.isEmpty() -> showToast("Please enter a password")
            confirmPassword.isEmpty() -> showToast("Please confirm your password")
            password != confirmPassword -> showToast("Passwords do not match")
            !termsCheckBox.isChecked -> showToast("Please agree to the terms and conditions")
            else -> {
                showToast("Registration successful!")
                // Add code for next steps after successful registration
            }
        }
    }

    private fun navigateToAccountActivity() {
        Log.d("SignUpActivity", "Navigating to Account Activity")
        val intent = Intent(this, AccountActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
