package com.hcdd340.yumble.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.imageview.ShapeableImageView;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.actions.UploadManager;

public class UploadPageTwoFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout ll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upload_page_two, container, false);
        Button nextButton = view.findViewById(R.id.upload_next_button_p2);
        Button cancelButton = view.findViewById(R.id.upload_cancel_button_p2);
        ShapeableImageView uploadButton = view.findViewById(R.id.add_ingredient_button);
        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        uploadButton.setOnClickListener(this);

        ll = view.findViewById(R.id.upload_ingredient_input);

        return view;
    }

    @Override
    public void onClick(View view) {
        int resView = view.getId();

        if (resView == R.id.upload_next_button_p2) {
            UploadManager.getInstance().saveIngredients(ll);

            UploadPageThreeFragment uploadPageThreeFragment = new UploadPageThreeFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.upload_fragment_container, uploadPageThreeFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (resView == R.id.upload_cancel_button_p2) {
            UploadPageOneFragment uploadPageOneFragment = new UploadPageOneFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
                    .replace(R.id.upload_fragment_container, uploadPageOneFragment)
                    .commit();

        } else if (resView == R.id.add_ingredient_button) {
            ll.addView(UploadManager.getInstance().generateNewEditText(view.getContext()));
        }
    }
}
