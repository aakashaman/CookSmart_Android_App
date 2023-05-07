package cooksmart.example.cooksmart

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dutyleavemanagmentsystem.R


class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        usernameEditText = findViewById(R.id.et_email)
        passwordEditText = findViewById(R.id.et_password)
        loginButton = findViewById(R.id.btn_login)

        // Set click listener for login button
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if username and password are correct
            if (username == "admin" && password == "password") {
                // If correct, start MainActivity
                val intent = Intent(this, NavigationDrawer::class.java)
                startActivity(intent)
                finish() // Finish LoginActivity to prevent user from going back to it
            } else {
                // If incorrect, show error message
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}