package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.nav.SwipeListener;

public class SavedRecipesActivity extends AppCompatActivity {
    private final static String DEBUG_TAG = "SAVED_RECIPES_ACTIVITY";

    ConstraintLayout constraintLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipes);

        constraintLayout = findViewById(R.id.saved_recipes_constraint_layout);
        constraintLayout.setOnTouchListener(new SwipeListener(SavedRecipesActivity.this) {
            @Override
            public void onSwipeRight() {
                Log.d(DEBUG_TAG, "Swipe right detected");
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
