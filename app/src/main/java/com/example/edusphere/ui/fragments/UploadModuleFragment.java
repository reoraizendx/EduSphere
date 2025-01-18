// UploadModuleFragment.java
package com.example.edusphere.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.edusphere.R;
import com.example.edusphere.model.Module;
import com.example.edusphere.modelview.ModuleViewModel;

public class UploadModuleFragment extends Fragment {

    private static final int PICK_FILE_REQUEST = 1;
    private Uri fileUri;
    private ModuleViewModel moduleViewModel;
    private EditText titleInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload_module, container, false);

        moduleViewModel = new ViewModelProvider(this).get(ModuleViewModel.class);

        titleInput = view.findViewById(R.id.title_input);
        Button chooseFileButton = view.findViewById(R.id.choose_file_button);
        Button uploadButton = view.findViewById(R.id.upload_button);

        chooseFileButton.setOnClickListener(v -> openFileChooser());
        uploadButton.setOnClickListener(v -> uploadModule());

        return view;
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        startActivityForResult(intent, PICK_FILE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            fileUri = data.getData();
            Toast.makeText(getContext(), "File selected: " + fileUri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadModule() {
        String title = titleInput.getText().toString().trim();

        if (title.isEmpty() || fileUri == null) {
            Toast.makeText(getContext(), "Please provide a title and select a file.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate upload (replace with Firebase upload if needed)
        Module module = new Module();
        module.setCourseId(1); // Example course ID
        module.setTitle(title);
        module.setFileUrl(fileUri.toString());

        moduleViewModel.insert(module);
        Toast.makeText(getContext(), "Module uploaded successfully!", Toast.LENGTH_SHORT).show();
    }
}
