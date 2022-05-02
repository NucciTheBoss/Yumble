package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.data.DataManager;
import com.hcdd340.yumble.data.Recipe;
import com.hcdd340.yumble.nav.SwipeListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String DEBUG_TAG = "MAIN_ACTIVITY";

    ConstraintLayout constraintLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.main_constraint_layout);
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

        ShapeableImageView dislikeButton = findViewById(R.id.dislike_button);
        ShapeableImageView refreshButton = findViewById(R.id.refresh_button);
        ShapeableImageView favoriteButton = findViewById(R.id.favorite_button);
        dislikeButton.setOnClickListener(this);
        refreshButton.setOnClickListener(this);
        favoriteButton.setOnClickListener(this);

        DataManager.getInstance().loadRecipes();
        DataManager.getInstance().randomize();
        setRecipe(DataManager.getInstance().getCurrentRecipe());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int resView = view.getId();

        switch (resView) {
            case R.id.dislike_button:
                setRecipe(DataManager.getInstance().moveToNextRecipe());
                break;

            case R.id.refresh_button:
                DataManager.getInstance().randomize();
                setRecipe(DataManager.getInstance().getCurrentRecipe());
                break;

            case R.id.favorite_button:
                setRecipe(DataManager.getInstance().moveToNextRecipe());
                break;

            default:
                Log.e(DEBUG_TAG, "Feature not implemented yet.");
                break;
        }
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

    private void setRecipe(Recipe recipe) {
        TextView recipeTitle = findViewById(R.id.recipe_title);
        ShapeableImageView foodImage = findViewById(R.id.food_image);
        TextView cookTime = findViewById(R.id.cook_time);
        TextView servings = findViewById(R.id.servings);

        recipeTitle.setText(recipe.getTitle());
        foodImage.setImageResource(recipe.getImage());
        foodImage.setContentDescription(recipe.getImageDesc());
        cookTime.setText(recipe.getStatistics().getValue0());
        servings.setText(recipe.getStatistics().getValue1());
    }
}
