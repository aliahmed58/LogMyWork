package com.main.logmywork.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.main.logmywork.R;
import com.main.logmywork.screens.AddJobScreen;

public class HomeFragment extends Fragment {

    // UI Elements
    private Button createJobBtn;

    // required empty constructor
    public HomeFragment() {}

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        /* init UI elements */
        createJobBtn = view.findViewById(R.id.createJobBtn);

        /* set on click listener for buttons */
        createJobListener();

        // returns a view on create method
        return view;
    }

    /* method that adds on click listener to create job button */
    private void createJobListener() {
        createJobBtn.setOnClickListener(view -> {
            /* Open the form activity to add job */
            Intent activityIntent = new Intent(view.getContext(), AddJobScreen.class);
            startActivity(activityIntent);
        });
    }
}
