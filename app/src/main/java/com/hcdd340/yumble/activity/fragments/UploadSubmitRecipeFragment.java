package com.hcdd340.yumble.activity.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.actions.UploadManager;
import com.hcdd340.yumble.data.ProfileManager;
import com.hcdd340.yumble.data.Recipe;

import java.util.LinkedList;

public class UploadSubmitRecipeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Recipe recipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upload_submit_recipe, container, false);
        Button cancelButton = view.findViewById(R.id.upload_cancel_button_p6);
        Button submitButton = view.findViewById(R.id.upload_submit_button);
        cancelButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        recipe = UploadManager.getInstance().buildRecipe();
        ImageView image = view.findViewById(R.id.upload_image_preview);
        TextView title = view.findViewById(R.id.upload_title_preview);
        TextView cookTime = view.findViewById(R.id.upload_cook_time_preview);
        TextView servings = view.findViewById(R.id.upload_servings_count_preview);
        LinearLayout ingredientsList = view.findViewById(R.id.upload_ingredients_preview_layout);
        LinearLayout instructionsList = view.findViewById(R.id.upload_instructions_preview_layout);
        LinearLayout notesList = view.findViewById(R.id.upload_notes_preview_layout);
        image.setImageBitmap(recipe.getImageBitmap());
        title.setText(recipe.getTitle());
        cookTime.setText(recipe.getStatistics().getValue0());
        servings.setText(recipe.getStatistics().getValue1());
        populateLinearLayout(recipe.getIngredients(), ingredientsList, view.getContext());
        populateLinearLayout(recipe.getInstructions(), instructionsList, view.getContext());
        populateLinearLayout(recipe.getNotes(), notesList, view.getContext());

        return view;
    }

    @Override
    public void onClick(View view) {
        int resView = view.getId();

        if (resView == R.id.upload_cancel_button_p6) {
            UploadPageFiveFragment uploadPageFiveFragment = new UploadPageFiveFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
                    .replace(R.id.upload_fragment_container, uploadPageFiveFragment)
                    .commit();

        } else if (resView == R.id.upload_submit_button) {
            ProfileManager.getInstance().addUpload(recipe);
            getActivity().finish();

        }
    }

    private void populateLinearLayout(LinkedList<String> list, LinearLayout ll, Context context) {
        ll.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(80, 0, 80, 30);
        Typeface typeface = getResources().getFont(R.font.montserrat_regular);
        for (String item : list) {
            TextView textView = new TextView(context);
            textView.setText(item);
            textView.setLayoutParams(params);
            textView.setTextColor(context.getColor(R.color.black));
            textView.setTypeface(typeface);
            ll.addView(textView);
        }
    }
}
