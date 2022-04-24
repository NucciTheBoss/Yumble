package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.nav.SwipeListener;

public class SearchFilterActivity extends AppCompatActivity {
    private final static String DEBUG_TAG = "SEARCH_FILTER_ACTIVITY";

    ConstraintLayout constraintLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);

        constraintLayout = findViewById(R.id.search_filter_constraint_layout);
        constraintLayout.setOnTouchListener(new SwipeListener(SearchFilterActivity.this) {
            @Override
            public void onSwipeTop() {
                Log.d(DEBUG_TAG, "Swipe up detected");
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_down);
    }
}