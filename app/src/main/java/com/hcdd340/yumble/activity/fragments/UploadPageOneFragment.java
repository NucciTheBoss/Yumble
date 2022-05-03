package com.hcdd340.yumble.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hcdd340.yumble.R;
import com.hcdd340.yumble.actions.UploadManager;

public class UploadPageOneFragment extends Fragment implements View.OnClickListener {
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upload_page_one, container, false);
        Button nextButton = view.findViewById(R.id.upload_next_button_p1);
        Button cancelButton = view.findViewById(R.id.upload_cancel_button_p1);
        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View vw) {
        int resView = vw.getId();

        if (resView == R.id.upload_next_button_p1) {
            EditText title = view.findViewById(R.id.upload_recipe_title_input);
            EditText cookTime = view.findViewById(R.id.upload_recipe_cook_time_input);
            EditText servings = view.findViewById(R.id.upload_recipe_servings_input);

            UploadManager.getInstance().saveTitle(title.getText().toString());
            UploadManager.getInstance().saveCookTime(cookTime.getText().toString());
            UploadManager.getInstance().saveServings(servings.getText().toString());

            UploadPageTwoFragment uploadPageTwoFragment = new UploadPageTwoFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.upload_fragment_container, uploadPageTwoFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (resView == R.id.upload_cancel_button_p1) {
            StartUploadFragment startUploadFragment = new StartUploadFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
                    .replace(R.id.upload_fragment_container, startUploadFragment)
                    .commit();
        }
    }
}
