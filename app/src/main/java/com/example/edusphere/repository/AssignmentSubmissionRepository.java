// AssignmentSubmissionRepository.java
package com.example.edusphere.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.edusphere.database.AppDatabase;
import com.example.edusphere.database.AssignmentSubmissionDao;
import com.example.edusphere.model.AssignmentSubmission;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AssignmentSubmissionRepository {

    private final AssignmentSubmissionDao dao;
    private final ExecutorService executor;

    // Constructor: Initialize the DAO and Executor
    public AssignmentSubmissionRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application); // Correct method to get database instance
        dao = database.assignmentSubmissionDao(); // Fetch DAO from database
        executor = Executors.newSingleThreadExecutor();
    }

    // Insert assignment submission into the database
    public void insert(AssignmentSubmission submission) {
        executor.execute(() -> dao.insert(submission));
    }

    // Retrieve submissions by student ID
    public LiveData<List<AssignmentSubmission>> getSubmissionsByStudentId(int studentId) {
        return dao.getSubmissionsByStudentId(studentId);
    }
}
