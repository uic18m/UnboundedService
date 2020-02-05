package com.example.unboundedservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    public MyService() {
    }
    Handler handler;

    @Override
    public void onCreate() {
        Log.d(TAG, "service create ");
        super.onCreate();
        handler = new Handler();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();


        handler.post(new Runnable() {
            @Override
            public void run() {


                try { Thread.sleep(4000); }
                catch (InterruptedException e) { e.printStackTrace(); }
                Log.d(TAG, "run:working 1");
            }
        });
        handler.post(new Runnable() {
            @Override
            public void run() {

                try { Thread.sleep(4000); }
                catch (InterruptedException e) { e.printStackTrace(); }

                Log.d(TAG, "run:working 2");
            }
        });

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
