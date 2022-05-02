package com.hcdd340.yumble.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.data.ProfileManager;
import com.hcdd340.yumble.data.RecipeManager;
import com.hcdd340.yumble.data.Recipe;
import com.hcdd340.yumble.nav.SwipeListener;

import java.util.LinkedList;

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

        RecipeManager.getInstance().loadRecipes();
        RecipeManager.getInstance().randomize();
        setRecipe(RecipeManager.getInstance().getCurrentRecipe());
    }

    @Override
    public void onClick(View view) {
        Log.d(DEBUG_TAG, "Click event detected");
        int resView = view.getId();

        if (resView == R.id.dislike_button) {
            Recipe recipe = RecipeManager.getInstance().getCurrentRecipe();
            ProfileManager.getInstance().addDislike(recipe);
            setRecipe(RecipeManager.getInstance().moveToNextRecipe());

        } else if (resView == R.id.refresh_button) {
            RecipeManager.getInstance().randomize();
            setRecipe(RecipeManager.getInstance().getCurrentRecipe());

        } else if (resView == R.id.favorite_button) {
            Recipe recipe = RecipeManager.getInstance().getCurrentRecipe();
            ProfileManager.getInstance().addFavorite(recipe);
            setRecipe(RecipeManager.getInstance().moveToNextRecipe());
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

    private void setRecipe(Recipe recipe) {
        TextView recipeTitle = findViewById(R.id.recipe_title);
        ShapeableImageView foodImage = findViewById(R.id.food_image);
        TextView cookTime = findViewById(R.id.cook_time);
        TextView servings = findViewById(R.id.servings);
        LinearLayout ingredientsLL = findViewById(R.id.ingredients_layout);
        LinearLayout instructionsLL = findViewById(R.id.instructions_layout);

        recipeTitle.setText(recipe.getTitle());
        foodImage.setImageResource(recipe.getImage());
        foodImage.setContentDescription(recipe.getImageDesc());
        cookTime.setText(recipe.getStatistics().getValue0());
        servings.setText(recipe.getStatistics().getValue1());
        populateLinearLayout(recipe.getIngredients(), ingredientsLL);
        populateLinearLayout(recipe.getInstructions(), instructionsLL);
    }

    private void populateLinearLayout(LinkedList<String> list, LinearLayout ll) {
        ll.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(80, 0, 80, 30);
        Typeface typeface = getResources().getFont(R.font.montserrat_regular);
        for (String item : list) {
            TextView textView = new TextView(this);
            textView.setText(item);
            textView.setLayoutParams(params);
            textView.setTextColor(getColor(R.color.black));
            textView.setTypeface(typeface);
            ll.addView(textView);
        }
    }
}
