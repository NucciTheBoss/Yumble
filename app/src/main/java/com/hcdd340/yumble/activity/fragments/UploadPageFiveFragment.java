package com.hcdd340.yumble.activity.fragments;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.imageview.ShapeableImageView;
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
        ShapeableImageView cameraButton = view.findViewById(R.id.upload_recipe_camera_button);
        ShapeableImageView filesButton = view.findViewById(R.id.upload_recipe_folder_button);
        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
        filesButton.setOnClickListener(this);

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

        } else if (resView == R.id.upload_recipe_camera_button) {
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            mCaptureImage.launch(takePicture);

        } else if (resView == R.id.upload_recipe_folder_button) {
            Intent getFile = new Intent(Intent.ACTION_GET_CONTENT);
            getFile.setType("gagt/sdf");
            mGetFile.launch(getFile);

        }
    }

    ActivityResultLauncher<Intent> mCaptureImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int resultCode = result.getResultCode();
                    if (resultCode == RESULT_OK) {
                        assert result.getData() != null;
                        Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                    } else if (resultCode == RESULT_CANCELED) {
                        Log.d(DEBUG_TAG, "Canceled without taking an image");
                    } else {
                        Log.d(DEBUG_TAG, String.format("Unknown return code from the Camera App: %s", resultCode));
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> mGetFile = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            }
    );

}
