package com.hcdd340.yumble.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hcdd340.yumble.R;

public class UploadSubmitRecipeFragment extends Fragment implements View.OnClickListener {
    private View view;

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
        cancelButton.setOnClickListener(this);
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
        }
    }
}
