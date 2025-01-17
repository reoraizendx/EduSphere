package com.example.edusphere.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.edusphere.model.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM user WHERE id = :id")
    User getUserById(int id);
}
