// ProgressDao.java
package com.example.edusphere.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.Progress;

import java.util.List;

@Dao
public interface ProgressDao {
    @Insert
    void insert(Progress progress);

    @Query("SELECT * FROM progress WHERE studentId = :studentId AND courseId = :courseId")
    LiveData<Progress> getProgressByStudentAndCourse(int studentId, int courseId);

    @Query("SELECT * FROM progress WHERE studentId = :studentId")
    LiveData<List<Progress>> getAllProgressForStudent(int studentId);
}
