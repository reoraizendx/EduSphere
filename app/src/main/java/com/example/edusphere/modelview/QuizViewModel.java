// QuizViewModel.java
package com.example.edusphere.modelview;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.edusphere.database.AppDatabase;
import com.example.edusphere.model.Quiz;

import java.util.List;

public class QuizViewModel extends AndroidViewModel {

    private final AppDatabase appDatabase;

    public QuizViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(application);
    }

    public LiveData<List<Quiz>> getQuizzesByCourseId(int courseId) {
        return appDatabase.quizDao().getQuizzesByCourseId(courseId);
    }

    public void insert(Quiz quiz) {
        AppDatabase.databaseWriteExecutor.execute(() -> appDatabase.quizDao().insert(quiz));
    }
}
