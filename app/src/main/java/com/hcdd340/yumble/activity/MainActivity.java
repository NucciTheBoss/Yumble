package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
            }

            @Override
            public void onSwipeRight() { Log.d(DEBUG_TAG, "Swipe right detected"); }

            @Override
            public void onSwipeBottom() { Log.d(DEBUG_TAG, "Swipe down detected"); }

            @Override
            public void onSwipeTop() { Log.d(DEBUG_TAG, "Swipe up detected"); }
        });
    }
}