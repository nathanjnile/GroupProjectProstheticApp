package com.example.natha.bluetoothservice2;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Handler;

public class MyApplication extends Application {
        // Called when the application is starting, before any other application objects have been created.
        // Overriding this method is totally optional!
        @Override
        public void onCreate() {
            super.onCreate();
            // Required initialization logic here!
        }

        // Called by the system when the device configuration changes while your component is running.
        // Overriding this method is totally optional!
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
        }

        // This is called when the overall system is running low on memory,
        // and would like actively running processes to tighten their belts.
        // Overriding this method is totally optional!
        @Override
        public void onLowMemory() {
            super.onLowMemory();
        }

    Handler.Callback realCallback = null;
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (realCallback != null) {
                realCallback.handleMessage(msg);
            }
        };
    };
    public Handler getHandler() {
        return handler;
    }
    public void setCallBack(Handler.Callback callback) {
        this.realCallback = callback;
    }
    }



