// AssignmentViewModel.java
package com.example.edusphere.modelview;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.edusphere.database.AppDatabase;
import com.example.edusphere.model.Assignment;

import java.util.List;

public class AssignmentViewModel extends AndroidViewModel {

    private final AppDatabase appDatabase;

    // Constructor to initialize the database instance
    public AssignmentViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(application);
    }

    // Retrieve assignments by courseId
    public LiveData<List<Assignment>> getAssignmentsByCourseId(int courseId) {
        return appDatabase.assignmentDao().getAssignmentsByCourseId(courseId);
    }

    // Insert a new assignment into the database
    public void insert(Assignment assignment) {
        AppDatabase.databaseWriteExecutor.execute(() -> appDatabase.assignmentDao().insert(assignment));
    }
}
