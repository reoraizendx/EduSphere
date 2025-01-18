// ModuleViewModel.java
package com.example.edusphere.modelview;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.edusphere.database.AppDatabase;
import com.example.edusphere.model.Module;
import java.util.List;

public class ModuleViewModel extends AndroidViewModel {

    private final AppDatabase appDatabase;

    public ModuleViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(application);
    }

    public LiveData<List<Module>> getModulesByCourseId(int courseId) {
        return appDatabase.moduleDao().getModulesByCourseId(courseId);
    }

    public void insert(Module module) {
        AppDatabase.databaseWriteExecutor.execute(() -> appDatabase.moduleDao().insert(module));
    }
}
