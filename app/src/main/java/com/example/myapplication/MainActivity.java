package com.example.myapplication;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Initialize the views
        usernameEditText = findViewById(R.id.et_username);
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        confirmPasswordEditText = findViewById(R.id.et_confirm_password);
        signUpButton = findViewById(R.id.btn_signup);

        // Set onClickListener for the sign-up button
        signUpButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            if (validateInput(username, email, password, confirmPassword)) {
                // Display a Toast message when sign-up is successful
                Toast.makeText(signup.this, "Sign-up successful!", Toast.LENGTH_SHORT).show();

                // Proceed with other sign-up logic (e.g., navigate to another screen)
            } else {
                // Show an error Toast if validation fails
                Toast.makeText(signup.this, "Please check your input and try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to validate user input
    private boolean validateInput(String username, String email, String password, String confirmPassword) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
public class signin extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        // Initialize the views
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        signInButton = findViewById(R.id.btn_signin);

        // Set onClickListener for the sign-in button
        signInButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Validate the inputs and show corresponding Toast
            if (validateInput(email, password)) {
                // Display a Toast for successful sign-in
                Toast.makeText(signin.this, "Sign-in successful!", Toast.LENGTH_SHORT).show();

                // Here you would handle further sign-in logic, like navigating to another screen
            } else {
                // Show a generic Toast for input errors
                Toast.makeText(signin.this, "Please check your credentials.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to validate user input
    private boolean validateInput(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            // Show Toast if the email field is empty
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            // Show Toast if the password field is empty
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Additional validation can be added (e.g., email format, password length)
        return true;
    }
}
