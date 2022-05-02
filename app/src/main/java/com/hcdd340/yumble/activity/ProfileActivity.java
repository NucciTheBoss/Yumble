package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.data.ProfileManager;
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

        TextView recipeUploadedCount = findViewById(R.id.profile_upload_count_placeholder);
        TextView recipeSavedByOthersCount = findViewById(R.id.profile_others_count_placeholder);
        TextView totalRecipesSavedCount = findViewById(R.id.profile_saved_count_placeholder);
        TextView totalRecipesDislikedCount = findViewById(R.id.profile_reject_count_placeholder);
        recipeSavedByOthersCount.setText(String.valueOf(ProfileManager.getInstance().getFavoritesByOtherSize()));
        recipeUploadedCount.setText(String.valueOf(ProfileManager.getInstance().getUploadSize()));
        totalRecipesSavedCount.setText(String.valueOf(ProfileManager.getInstance().getFavoriteSize()));
        totalRecipesDislikedCount.setText(String.valueOf(ProfileManager.getInstance().getDislikeSize()));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
