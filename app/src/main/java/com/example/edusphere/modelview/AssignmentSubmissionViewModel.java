// AssignmentSubmissionViewModel.java
package com.example.edusphere.modelview;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.edusphere.model.AssignmentSubmission;
import com.example.edusphere.repository.AssignmentSubmissionRepository;
import java.util.List;

public class AssignmentSubmissionViewModel extends AndroidViewModel {

    private final AssignmentSubmissionRepository repository;

    public AssignmentSubmissionViewModel(Application application) {
        super(application);
        repository = new AssignmentSubmissionRepository(application);
    }

    public void insert(AssignmentSubmission submission) {
        repository.insert(submission);
    }

    public LiveData<List<AssignmentSubmission>> getSubmissionsByStudentId(int studentId) {
        return repository.getSubmissionsByStudentId(studentId);
    }
}
