// SubmitAssignmentFragment.java
package com.example.edusphere.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.edusphere.R;
import com.example.edusphere.model.AssignmentSubmission;
import com.example.edusphere.modelview.AssignmentSubmissionViewModel;

public class SubmitAssignmentFragment extends Fragment {

    private static final int PICK_FILE_REQUEST = 1;
    private TextView assignmentTitleTextView, assignmentDescriptionTextView, uploadedFileNameTextView;
    private Button uploadButton, submitButton;
    private Uri fileUri;
    private AssignmentSubmissionViewModel submissionViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit_assignment, container, false);

        assignmentTitleTextView = view.findViewById(R.id.assignment_title);
        assignmentDescriptionTextView = view.findViewById(R.id.assignment_description);
        uploadedFileNameTextView = view.findViewById(R.id.uploaded_file_name);
        uploadButton = view.findViewById(R.id.upload_button);
        submitButton = view.findViewById(R.id.submit_button);

        submissionViewModel = new ViewModelProvider(this).get(AssignmentSubmissionViewModel.class);

        // Example assignment details
        int assignmentId = 1; // Replace with actual assignment ID
        assignmentTitleTextView.setText("Example Assignment Title");
        assignmentDescriptionTextView.setText("Example Assignment Description");

        uploadButton.setOnClickListener(v -> openFilePicker());
        submitButton.setOnClickListener(v -> {
            if (fileUri == null) {
                Toast.makeText(getContext(), "Please upload a file first", Toast.LENGTH_SHORT).show();
                return;
            }
            submitAssignment(assignmentId);
        });

        return view;
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            fileUri = data.getData();
            uploadedFileNameTextView.setText(fileUri.getLastPathSegment());
        }
    }

    private void submitAssignment(int assignmentId) {
        AssignmentSubmission submission = new AssignmentSubmission();
        submission.setAssignmentId(assignmentId);
        submission.setStudentId(1); // Replace with the logged-in student's ID
        submission.setFilePath(fileUri.toString());

        submissionViewModel.insert(submission);
        Toast.makeText(getContext(), "Assignment submitted successfully!", Toast.LENGTH_SHORT).show();

        // Clear UI
        fileUri = null;
        uploadedFileNameTextView.setText("");
    }
}
