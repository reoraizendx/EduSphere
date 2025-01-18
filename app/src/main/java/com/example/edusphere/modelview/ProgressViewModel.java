package com.example.edusphere.modelview;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.edusphere.database.AppDatabase;
import com.example.edusphere.model.Progress;

public class ProgressViewModel extends AndroidViewModel {

    private final AppDatabase appDatabase;

    public ProgressViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(application);
    }

    public LiveData<Progress> getProgress(int studentId, int courseId) {
        return appDatabase.progressDao().getProgressByStudentAndCourse(studentId, courseId);
    }
}
