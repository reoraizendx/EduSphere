package com.example.edusphere.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.example.edusphere.model.AssignmentSubmission;

import java.util.List;
@Dao
public interface AssignmentSubmissionDao {
    public default void insert(AssignmentSubmission submission) {
    }

    public default LiveData<List<AssignmentSubmission>> getSubmissionsByStudentId(int studentId) {
        return null;
    }
}
