package com.hcdd340.yumble.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.imageview.ShapeableImageView;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.actions.UploadManager;

public class UploadPageThreeFragment extends Fragment implements View.OnClickListener {
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
        view = inflater.inflate(R.layout.fragment_upload_page_three, container, false);
        Button nextButton = view.findViewById(R.id.upload_next_button_p3);
        Button cancelButton = view.findViewById(R.id.upload_cancel_button_p3);
        ShapeableImageView addButton = view.findViewById(R.id.add_instructions_button);
        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        addButton.setOnClickListener(this);

        ll = view.findViewById(R.id.upload_instructions_input);

        return view;
    }

    @Override
    public void onClick(View view) {
        int resView = view.getId();

        if (resView == R.id.upload_next_button_p3) {
            UploadPageFourFragment uploadPageFourFragment = new UploadPageFourFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.upload_fragment_container, uploadPageFourFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (resView == R.id.upload_cancel_button_p3) {
            UploadPageTwoFragment uploadPageTwoFragment = new UploadPageTwoFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
                    .replace(R.id.upload_fragment_container, uploadPageTwoFragment)
                    .commit();

        } else if (resView == R.id.add_instructions_button) {
            ll.addView(UploadManager.getInstance().generateNewEditText(view.getContext()));
        }
    }
}
