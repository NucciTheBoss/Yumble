package com.hcdd340.yumble.activity.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hcdd340.yumble.R;
import com.hcdd340.yumble.actions.UploadManager;

public class StartUploadFragment extends Fragment implements View.OnClickListener {
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_start_upload, container, false);
        ShapeableImageView uploadButton = view.findViewById(R.id.upload_button);
        uploadButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int resView = view.getId();

        if (resView == R.id.upload_button) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_pref_yumble), Context.MODE_PRIVATE);
            UploadManager.getInstance().setSharedPreferences(sharedPreferences);

            UploadPageOneFragment uploadPageOneFragment = new UploadPageOneFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.upload_fragment_container, uploadPageOneFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
