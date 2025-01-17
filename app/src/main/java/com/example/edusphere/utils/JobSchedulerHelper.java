package com.example.edusphere.utils;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

import com.example.edusphere.services.DataSyncService;

public class JobSchedulerHelper {
    public static void scheduleDataSync(Context context) {
        ComponentName componentName = new ComponentName(context, DataSyncService.class);
        JobInfo jobInfo = new JobInfo.Builder(1, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPeriodic(15 * 60 * 1000) // 15 minutes
                .build();

        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfo);
    }
}
