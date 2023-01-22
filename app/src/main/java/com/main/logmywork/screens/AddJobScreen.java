package com.main.logmywork.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.main.logmywork.R;

public class AddJobScreen extends AppCompatActivity {

    // UI elements
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job_screen);

        /* init UI elements */
        cancelBtn = findViewById(R.id.cancelAddJobBtn);

        /* add Button listeners */
        addCancelListener();
    }

    /* listener method for cancelling the form
    * destroys the activity and goes back to home page */
    private void addCancelListener() {
        cancelBtn.setOnClickListener(view -> {
            finish();
        });
    }
}