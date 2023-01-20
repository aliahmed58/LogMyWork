package com.main.logmywork.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.main.logmywork.R;
import com.main.logmywork.objects.Time;

public class LogHoursScreen extends AppCompatActivity {

    // define widgets as member variables needed for this activity
    TextView timeTextView;
    Button startTimerBtn;

    // create Time object to store time
    Time time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_hours_screen);

        // initialize widget variables used in this activity
        timeTextView = findViewById(R.id.timeTextView);
        startTimerBtn = findViewById(R.id.startTimer);

        // create a time object on start of activity
        // TODO: get back time object if activity stopped or destroyed
        time = new Time();

        // set on click listeners for buttons
        // listener for when START button is clicked
        onStartClick();

    }

    // updates time shown by the time text view
    private void updateTime() {
        // add a second to local time and update timeTextView string with the new time string
        this.time.addTime(1);
        this.timeTextView.setText(this.time.getTimeString());
    }

    private void onStartClick() {


        this.startTimerBtn.setOnClickListener(view -> {

            // updating time on a different thread so UI never freezes
            new Thread(new Runnable() {
                public void run() {
                    // update time

                    // get updated time string
                    final String timeText = time.getTimeString();
                    // change text view based on that
                    timeTextView.postDelayed(new Runnable() {
                        public void run() {
                            updateTime();
                            timeTextView.setText(timeText);
                        }
                    }, 1000);
                }
            }).start();
        });
    }
}