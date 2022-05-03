package com.hcdd340.yumble.actions;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.data.Recipe;

import org.javatuples.Pair;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.Set;

enum UploadKeys {
    TITLE,
    COOK_TIME,
    SERVINGS,
    INGREDIENTS,
    INSTRUCTIONS,
    NOTES,
    PHOTO
}

public class UploadManager {
    private final static String DEBUG_TAG = "UPLOAD_MANAGER";

    // Begin Singleton declaration
    private static UploadManager uploadManager = null;

    private UploadManager() {}

    public static UploadManager getInstance() {
        if (uploadManager == null) {
            uploadManager = new UploadManager();
        }

        return uploadManager;
    }
    // End Singleton declaration

    private SharedPreferences sharedPreferences;

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public EditText generateNewEditText(Context context) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 80);
        EditText editText = new EditText(context);
        editText.setLayoutParams(params);
        Typeface typeface = context.getResources().getFont(R.font.montserrat_regular);
        editText.setTypeface(typeface);
        editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        return editText;
    }

    public void saveTitle(String recipeTitle) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UploadKeys.TITLE.name(), recipeTitle);
        editor.apply();
    }

    public void saveCookTime(String cookTime) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UploadKeys.COOK_TIME.name(), cookTime);
        editor.apply();
    }

    public void saveServings(String servings) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UploadKeys.SERVINGS.name(), servings);
        editor.apply();
    }

    public void saveIngredients(LinearLayout ingredientsList) {
        Gson gson = new Gson();
        LinkedList<String> ingredients = new LinkedList<>();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        int childCount = ingredientsList.getChildCount();
        for (int i = 0; i < childCount; i++) {
            EditText ingredient = (EditText) ingredientsList.getChildAt(i);
            ingredients.add(ingredient.getText().toString());
        }
        editor.putString(UploadKeys.INGREDIENTS.name(), gson.toJson(ingredients));
        editor.apply();
    }

    public void saveInstructions(LinearLayout instructionsList) {
        Gson gson = new Gson();
        LinkedList<String> instructions = new LinkedList<>();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        int childCount = instructionsList.getChildCount();
        for (int i = 0; i < childCount; i++) {
            EditText instruction = (EditText) instructionsList.getChildAt(i);
            instructions.add(instruction.getText().toString());
        }
        editor.putString(UploadKeys.INSTRUCTIONS.name(), gson.toJson(instructions));
        editor.apply();
    }

    public void saveNotes(LinearLayout notesList) {
        Gson gson = new Gson();
        LinkedList<String> notes = new LinkedList<>();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        int childCount = notesList.getChildCount();
        for (int i = 0; i < childCount; i++) {
            EditText note = (EditText) notesList.getChildAt(i);
            notes.add(note.getText().toString());
        }
        editor.putString(UploadKeys.NOTES.name(), gson.toJson(notes));
        editor.apply();
    }

    public void saveImage(Bitmap image) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String encodedImage = Base64.getEncoder().encodeToString(b);
        editor.putString(UploadKeys.PHOTO.name(), encodedImage);
        editor.apply();
    }

    public Recipe buildRecipe() {
        Gson gson = new Gson();
        Type linkedListType = new TypeToken<LinkedList<String>>() {}.getType();

        // Title
        String title = sharedPreferences.getString(UploadKeys.TITLE.name(), "");

        // Cook Time
        String cookTime = sharedPreferences.getString(UploadKeys.COOK_TIME.name(), "");

        // Servings
        String servings = sharedPreferences.getString(UploadKeys.SERVINGS.name(), "");

        // Ingredients
        String ingredients = sharedPreferences.getString(UploadKeys.INGREDIENTS.name(), "");
        LinkedList<String> ingredientsList = gson.fromJson(ingredients, linkedListType);

        // Instructions
        String instructions = sharedPreferences.getString(UploadKeys.INSTRUCTIONS.name(), "");
        LinkedList<String> instructionsList = gson.fromJson(instructions, linkedListType);

        // Notes
        String notes = sharedPreferences.getString(UploadKeys.NOTES.name(), "");
        LinkedList<String> notesList = gson.fromJson(notes, linkedListType);

        // Image
        String image = sharedPreferences.getString(UploadKeys.PHOTO.name(), "");
        byte[] imageAsBytes = Base64.getDecoder().decode(image);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);

        // Create recipe
        ArrayList<String> tags = new ArrayList<>();
        tags.add("vegetarian");

        return new Recipe(
                "NucciTheBoss",
                title,
                tags,
                bitmap,
                "Photograph of recipe",
                new Pair<>(cookTime, servings),
                "My recipe",
                ingredientsList,
                instructionsList,
                notesList,
                null
        );
    }
}
