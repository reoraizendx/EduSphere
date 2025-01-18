// ModuleDao.java
package com.example.edusphere.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.Module;

import java.util.List;

@Dao
public interface ModuleDao {
    @Insert
    void insert(Module module);

    @Query("SELECT * FROM modules WHERE courseId = :courseId")
    LiveData<List<Module>> getModulesByCourseId(int courseId);
}
