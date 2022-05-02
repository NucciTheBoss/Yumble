package com.hcdd340.yumble.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hcdd340.yumble.R;

public class UploadPageFiveFragment extends Fragment implements View.OnClickListener {
    private static final String DEBUG_TAG = "UPLOAD_FRAG_5";
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upload_page_five, container, false);
        Button nextButton = view.findViewById(R.id.upload_next_button_p5);
        Button cancelButton = view.findViewById(R.id.upload_cancel_button_p5);
        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int resView = view.getId();

        if (resView == R.id.upload_next_button_p5) {
            UploadSubmitRecipeFragment uploadSubmitRecipeFragment = new UploadSubmitRecipeFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.upload_fragment_container, uploadSubmitRecipeFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (resView == R.id.upload_cancel_button_p5) {
            UploadPageFourFragment uploadPageFourFragment = new UploadPageFourFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
                    .replace(R.id.upload_fragment_container, uploadPageFourFragment)
                    .commit();
        }
    }
}
