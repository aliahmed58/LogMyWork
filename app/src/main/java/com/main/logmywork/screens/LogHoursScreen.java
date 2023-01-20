package com.main.logmywork.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.main.logmywork.R;
import com.main.logmywork.objects.Time;

import java.util.Timer;
import java.util.TimerTask;

public class LogHoursScreen extends AppCompatActivity {

    // define widgets as member variables needed for this activity
    TextView hoursTextView;
    TextView minutesTextView;
    TextView secondsTextView;
    Button startTimerBtn;
    Button pauseTimeBtn;

    // Timer utilities built in java to run countdown in background
    private Timer timer;
    private TimerTask timerTask;

    // create Time object to store time
    Time time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_hours_screen);

        // initialize widget variables used in this activity
        hoursTextView = findViewById(R.id.hoursText);
        minutesTextView = findViewById(R.id.minutesText);
        secondsTextView = findViewById(R.id.secondsText);
        startTimerBtn = findViewById(R.id.startTimer);
        pauseTimeBtn = findViewById(R.id.pauseTimer);

        // create a time object on start of activity
        // TODO: get back time object if activity stopped or destroyed
        time = new Time();

        // set on click listeners for buttons
        // listener for when START button is clicked
        onStartClick();
        // listener for when PAUSE button is clicked
        onPauseClick();
    }

    // method pauses the stopwatch time and
    // destroys the existing timer so it no longer runs every 1 second
    private void onPauseClick() {
        pauseTimeBtn.setOnClickListener(view -> {
            // cancel the timer task and purge the timer.
            timerTask.cancel();
            timer.purge();
        });

    }

    // method sets the on click listener for START button
    // a new timer task is created and ran for every 1000 ms OR 1 seconds
    // the text view updates on UI thread using the post handler method
    private void onStartClick() {
        // create a new timer object for timer task
        timer = new Timer();

        this.startTimerBtn.setOnClickListener(view -> {
            timerTask = new TimerTask() {
                public void run() {
                    // add 1 second to time
                    time.addTime(1);

                    // set each hour, minutes and seconds text view individually for UI to look
                    // proper and to avoid the time text from moving
                    final String timeText = time.getTimeString();

                    // set hours
                    hoursTextView.post(() -> {
                        hoursTextView.setText(timeText.substring(0, 3));
                    });

                    // set minutes
                    minutesTextView.post(() -> {
                        minutesTextView.setText(timeText.substring(3, 6));
                    });

                    // set seconds
                    secondsTextView.post(() -> {
                        secondsTextView.setText(timeText.substring(6,8));
                    });
                }
            };
            // schedule the timer to run for every 1 second
            timer.schedule(timerTask, 1, 1000L);
        });

    }
}