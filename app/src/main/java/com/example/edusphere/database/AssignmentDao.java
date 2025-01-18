// AssignmentDao.java
package com.example.edusphere.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.Assignment;

import java.util.List;

@Dao
public interface AssignmentDao {
    @Insert
    void insert(Assignment assignment);

    @Query("SELECT * FROM assignments WHERE courseId = :courseId")
    LiveData<List<Assignment>> getAssignmentsByCourseId(int courseId);
}
