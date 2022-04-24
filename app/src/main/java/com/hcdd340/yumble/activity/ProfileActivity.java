package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.nav.SwipeListener;

public class ProfileActivity extends AppCompatActivity {
    private final static String DEBUG_TAG = "PROFILE_ACTIVITY";

    ConstraintLayout constraintLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        constraintLayout = findViewById(R.id.profile_constraint_layout);
        constraintLayout.setOnTouchListener(new SwipeListener(ProfileActivity.this) {
            @Override
            public void onSwipeLeft() {
                Log.d(DEBUG_TAG, "Swipe left detected");
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }
}
