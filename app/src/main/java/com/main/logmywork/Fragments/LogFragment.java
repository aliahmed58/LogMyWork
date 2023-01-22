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
import com.main.logmywork.screens.LogHoursScreen;

public class LogFragment extends Fragment {

    Button logBtn;

    // empty constructor
    public LogFragment() {}

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.log_fragment_layout, container, false);

        logBtn = view.findViewById(R.id.logTimeBtn);

        logBtn.setOnClickListener(v -> {
            Intent i = new Intent(view.getContext(), LogHoursScreen.class);
            startActivity(i);
        });
        
        return view;
    }
}
