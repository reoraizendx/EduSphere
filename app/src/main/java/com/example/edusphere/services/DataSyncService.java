package com.example.edusphere.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class DataSyncService extends JobService {

    private static final String TAG = "DataSyncService";

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Data sync job started");

        // Simulate data sync in a separate thread
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Simulate a network operation
                Log.d(TAG, "Data sync complete");
                jobFinished(params, false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return true; // Indicates there's work being done on a background thread
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "Data sync job stopped");
        return true; // Reschedule job if it was interrupted
    }
}
