package com.example.edusphere.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.example.edusphere.model.Assignment;
import com.example.edusphere.modelview.AssignmentViewModel;

public class AddAssignmentFragment extends Fragment {

    private AssignmentViewModel assignmentViewModel;
    private EditText titleEditText, descriptionEditText, dueDateEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_assignment, container, false);

        titleEditText = view.findViewById(R.id.assignment_title_input);
        descriptionEditText = view.findViewById(R.id.assignment_description_input);
        dueDateEditText = view.findViewById(R.id.assignment_due_date_input);
        Button submitButton = view.findViewById(R.id.submit_assignment_button);

        assignmentViewModel = new ViewModelProvider(this).get(AssignmentViewModel.class);

        submitButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String description = descriptionEditText.getText().toString();
            String dueDate = dueDateEditText.getText().toString();

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description) || TextUtils.isEmpty(dueDate)) {
                Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            Assignment assignment = new Assignment();
            assignment.setTitle(title);
            assignment.setDescription(description);
            assignment.setDueDate(dueDate);
            assignment.setCourseId(1);

            assignmentViewModel.insert(assignment);
            Toast.makeText(getContext(), "Assignment added successfully", Toast.LENGTH_SHORT).show();

            // Clear fields
            titleEditText.setText("");
            descriptionEditText.setText("");
            dueDateEditText.setText("");
        });

        return view;
    }
}
