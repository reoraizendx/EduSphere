package com.example.edusphere.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.edusphere.R;
import com.example.edusphere.modelview.ProgressViewModel;

public class ProgressFragment extends Fragment {

    private ProgressViewModel progressViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_progress, container, false);

        // Initialize TextView
        TextView progressTextView = view.findViewById(R.id.progress_text_view);

        // Initialize ViewModel
        progressViewModel = new ViewModelProvider(this).get(ProgressViewModel.class);

        // Example Student ID and Course ID
        int studentId = 1;
        int courseId = 1;

        // Observe LiveData from ViewModel
        progressViewModel.getProgress(studentId, courseId).observe(getViewLifecycleOwner(), progress -> {
            if (progress != null) {
                // Display progress
                String progressText = "Completed Modules: " + progress.getCompletedModules() +
                        " / " + progress.getTotalModules();
                progressTextView.setText(progressText);
            } else {
                // Handle no progress case
                progressTextView.setText(R.string.no_progress_available);
            }
        });

        return view;
    }
}
