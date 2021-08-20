package com.example.store;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.*;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // Define Parameters
    private EditText Email;
    private EditText Username;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get The Icon Beside The Title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //Insert the Parameters into the Variables
        Email = findViewById(R.id.emailText);
        Username = findViewById(R.id.userText);
        Password = findViewById(R.id.passText);

        Button loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View v)
           {
               confirmInput(v);
               // Transfer from the
               Intent i = new Intent(MainActivity.this, ShoppingActivity.class);
               startActivity(i);
           }
        });

        // Add a Link to the Sign In Page
        TextView signIn = findViewById(R.id.signIn);
        String text = "Already have an account: Sign in";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan1, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signIn.setText(ss);
        signIn.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // Validate The Username
    private boolean isValidUser() {
        String usernameInput = Username.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            Username.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            Username.setError("Username too long");
            return false;
        } else {
            Username.setError(null);
            return true;
        }
    }

    // Validate The Email Address
    private boolean isValidEmail() {
        String emailInput = Email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            Email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Email.setError("Please enter a valid email address");
            return false;
        } else {
            Email.setError(null);
            return true;
        }
    }

    // Regular Expression for the Password form
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    // Validate The Password
    private boolean isValidPassword() {
        String passwordInput = Password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            Password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            Password.setError("Password too weak");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }

    //Confirm the Data Entered By The User
    public void confirmInput(View v) {
        if (!isValidUser() | !isValidEmail() | !isValidPassword()) {
            return;
        }
        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
    }
}