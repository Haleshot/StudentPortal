package com.example.studentportal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studentportal.R;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        Button logoutButton = findViewById(R.id.logoutButton);

        // Get the user's name from the Intent
        String userName = getIntent().getStringExtra("userName");

        // Display welcome message
        welcomeMessage.setText("Welcome " + userName);

        // Set OnClickListener for logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to login activity
                finish(); // Finish the current activity
            }
        });
    }
}
