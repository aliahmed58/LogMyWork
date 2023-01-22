package com.main.logmywork.screens;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.main.logmywork.Fragments.HomeFragment;
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
        navbar.setOnItemReselectedListener(navbarListener);

        // set home fragment when the app opens as the first screen
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .setReorderingAllowed(true)
                .commit();

    }

    // instance variable that implements the navbar onItemReselectedListener to change fragments when bottom navbar is clicked.
    // lambda expressions used.
    private final NavigationBarView.OnItemReselectedListener navbarListener = item -> {
        // create a null object that references the selected fragment
        Fragment selectedFragment = null;

        // create a switch on the item's id that is clicked in the bottom nav bar
        switch (item.getItemId()) {
            // if home button is clicked create a new home fragment
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                break;
        }

        // make sure the selected fragment is not null
        assert selectedFragment != null;
        // replace the current container with the selected fragment created.
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment)
                .setReorderingAllowed(true)
                .commit();
    };

}