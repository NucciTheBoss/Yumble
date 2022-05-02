package com.hcdd340.yumble.actions;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hcdd340.yumble.R;

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
}
