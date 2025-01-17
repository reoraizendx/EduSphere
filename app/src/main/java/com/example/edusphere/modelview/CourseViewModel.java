package com.example.edusphere.modelview;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.edusphere.database.AppDatabase;
import com.example.edusphere.database.CourseDao;
import com.example.edusphere.model.Course;
import java.util.List;

public class CourseViewModel extends AndroidViewModel {
    private final CourseDao courseDao;
    private final LiveData<List<Course>> allCourses;

    public CourseViewModel(Application application) {
        super(application);
        AppDatabase db = AppDatabase.getDatabase(application);
        courseDao = db.courseDao();
        allCourses = courseDao.getAllCourses();
    }

    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public void insert(Course course) {
        AppDatabase.databaseWriteExecutor.execute(() -> courseDao.insert(course));
    }
}
