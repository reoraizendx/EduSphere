package com.example.edusphere.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.example.edusphere.ACTION_NOTIFY".equals(action)) {
            Log.d("NotificationReceiver", "Notification action received");
            Toast.makeText(context, "Notification received!", Toast.LENGTH_SHORT).show();
        }
    }
}
