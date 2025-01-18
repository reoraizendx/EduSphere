// QuizDao.java
package com.example.edusphere.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.Quiz;

import java.util.List;

@Dao
public interface QuizDao {
    @Insert
    void insert(Quiz quiz);

    @Query("SELECT * FROM quizzes WHERE courseId = :courseId")
    LiveData<List<Quiz>> getQuizzesByCourseId(int courseId);
}
