// QuizQuestionDao.java
package com.example.edusphere.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.QuizQuestion;

import java.util.List;

@Dao
public interface QuizQuestionDao {
    @Insert
    void insert(QuizQuestion quizQuestion);

    @Query("SELECT * FROM quiz_questions WHERE quizId = :quizId")
    List<QuizQuestion> getQuestionsByQuizId(int quizId);
}
