package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.activity.fragments.SavedRecipesSavedFragment;
import com.hcdd340.yumble.activity.fragments.SavedRecipesSearchFragment;
import com.hcdd340.yumble.activity.fragments.SavedRecipesUploadFragment;
import com.hcdd340.yumble.nav.SwipeListener;

public class SavedRecipesActivity extends AppCompatActivity implements View.OnClickListener {
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

        ShapeableImageView savedButton = findViewById(R.id.recipe_button_saved);
        ShapeableImageView searchButton = findViewById(R.id.recipe_button_search);
        ShapeableImageView uploadsButton = findViewById(R.id.recipe_button_uploads);
        savedButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        uploadsButton.setOnClickListener(this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View view) {
        int resView = view.getId();

        if (resView == R.id.recipe_button_saved) {
            SavedRecipesSavedFragment savedRecipesSavedFragment = new SavedRecipesSavedFragment();
            replaceSavedRecipeFragment(savedRecipesSavedFragment);

        } else if (resView == R.id.recipe_button_search) {
            SavedRecipesSearchFragment savedRecipesSearchFragment = new SavedRecipesSearchFragment();
            replaceSavedRecipeFragment(savedRecipesSearchFragment);

        } else if (resView == R.id.recipe_button_uploads) {
            SavedRecipesUploadFragment savedRecipesUploadFragment = new SavedRecipesUploadFragment();
            replaceSavedRecipeFragment(savedRecipesUploadFragment);

        }

    }

    private void replaceSavedRecipeFragment(Fragment savedRecipeFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.saved_recipes_fragment_view, savedRecipeFragment);
        fragmentTransaction.commit();
    }
}
