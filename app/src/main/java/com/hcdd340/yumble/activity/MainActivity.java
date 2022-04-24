package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.nav.SwipeListener;

public class MainActivity extends AppCompatActivity {
    private final static String DEBUG_TAG = "MAIN_ACTIVITY";

    ConstraintLayout constraintLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraint_layout);
        constraintLayout.setOnTouchListener(new SwipeListener(MainActivity.this) {
            @Override
            public void onSwipeLeft() {
                Log.d(DEBUG_TAG, "Swipe left detected");
                showSavedRecipesActivity();
            }

            @Override
            public void onSwipeRight() {
                Log.d(DEBUG_TAG, "Swipe right detected");
                showProfileActivity();
            }

            @Override
            public void onSwipeBottom() {
                Log.d(DEBUG_TAG, "Swipe down detected");
                showSearchFilterActivity();
            }

            @Override
            public void onSwipeTop() {
                Log.d(DEBUG_TAG, "Swipe up detected");
                showUploadActivity();
            }
        });
    }

    private void showProfileActivity() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void showSavedRecipesActivity() {
        Intent intent = new Intent(this, SavedRecipesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void showUploadActivity() {
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up);
    }

    private void showSearchFilterActivity() {
        Intent intent = new Intent(this, SearchFilterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
    }
}
