package com.example.edusphere.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

import com.example.edusphere.model.Assignment;
import com.example.edusphere.model.AssignmentSubmission;
import com.example.edusphere.model.Course;
import com.example.edusphere.model.Module;
import com.example.edusphere.model.Progress;
import com.example.edusphere.model.Quiz;
import com.example.edusphere.model.QuizQuestion;
import com.example.edusphere.model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {
                Course.class,
                User.class,
                Module.class,
                Quiz.class,
                QuizQuestion.class,
                Progress.class,
                Assignment.class,
                AssignmentSubmission.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    // Singleton instance
    private static volatile AppDatabase INSTANCE;

    // Executor service to handle database operations
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // DAOs
    public abstract CourseDao courseDao();
    public abstract UserDao userDao();
    public abstract ModuleDao moduleDao();
    public abstract QuizDao quizDao();
    public abstract QuizQuestionDao quizQuestionDao();
    public abstract ProgressDao progressDao();
    public abstract AssignmentDao assignmentDao();
    public abstract AssignmentSubmissionDao assignmentSubmissionDao();

    // Get database instance (Singleton)
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "edusphere_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
