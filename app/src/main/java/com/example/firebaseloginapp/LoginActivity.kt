package com.example.firebaseloginapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    public fun loginUser(view: View) {
        var email: String = findViewById<EditText>(R.id.login_email_edit_text).text.toString()
        var password: String =
            findViewById<EditText>(R.id.login_password_edit_text).text.toString()
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, AppCompatActivity::class.java))
                } else {
                    Toast.makeText(
                        this, "Unable to login. Check your input or try again later",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}