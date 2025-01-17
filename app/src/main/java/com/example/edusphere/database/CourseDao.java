package com.example.edusphere.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.Course;
import java.util.List;

@Dao
public interface CourseDao {
    @Insert
    void insert(Course course);

    @Query("SELECT * FROM course")
    LiveData<List<Course>> getAllCourses();
}
