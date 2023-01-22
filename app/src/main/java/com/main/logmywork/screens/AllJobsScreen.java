package com.main.logmywork.screens;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.main.logmywork.Fragments.HomeFragment;
import com.main.logmywork.Fragments.LogFragment;
import com.main.logmywork.R;

public class AllJobsScreen extends AppCompatActivity {
    // UI elements
    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_jobs_screen);

        // init UI elements
        navbar = findViewById(R.id.navbar);

        // set on item select listener
        navbar.setOnItemSelectedListener(navbarListener);

        // set home fragment when the app opens as the first screen
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .setReorderingAllowed(true)
                .commit();

    }

    // instance variable that implements the navbar onItemReselectedListener to change fragments when bottom navbar is clicked.
    // lambda expressions used.
    private final NavigationBarView.OnItemSelectedListener navbarListener = item -> {
        // create a null object that references the selected fragment
        Fragment selectedFragment = null;

        // check using if statements if the item ID selected matches any of the navbar items
        // if yes, create a new fragment object of that layout and assign it to selectedFragment
        if (item.getItemId() == R.id.nav_home)
            selectedFragment = new HomeFragment();
        else if (item.getItemId() == R.id.nav_log)
            selectedFragment = new LogFragment();
        // if none is selected return the function to avoid a NullPointerException in next instruction.
        else
            return false;

        // replace the current container with the selected fragment created.
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment)
                .setReorderingAllowed(true)
                .commit();

        return true;
    };

}