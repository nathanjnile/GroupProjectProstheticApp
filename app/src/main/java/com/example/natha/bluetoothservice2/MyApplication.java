package com.example.natha.bluetoothservice2;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Handler;

public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
        }

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



