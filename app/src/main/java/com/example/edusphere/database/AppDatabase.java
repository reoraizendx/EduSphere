package com.example.edusphere.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import com.example.edusphere.model.Course;
import com.example.edusphere.model.User;

import java.util.concurrent.Executor;

@Database(entities = {Course.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static Executor databaseWriteExecutor;

    public abstract CourseDao courseDao();
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "edusphere_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
