package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.nav.SwipeListener;

public class UploadActivity extends AppCompatActivity {
    private final static String DEBUG_TAG = "UPLOAD_ACTIVITY";

    ConstraintLayout constraintLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        constraintLayout = findViewById(R.id.upload_constraint_layout);
        constraintLayout.setOnTouchListener(new SwipeListener(UploadActivity.this) {
            @Override
            public void onSwipeBottom() {
                Log.d(DEBUG_TAG, "Swipe down detected");
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
    }
}