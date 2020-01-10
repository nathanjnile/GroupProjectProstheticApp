package com.example.natha.bluetoothservice2;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.UUID;

public class PrinterService extends Service {
    private static final String TAG = "BluetoothConnectionServ";
    private BluetoothAdapter mBluetoothAdapter;
    public static final String BT_DEVICE = "raspberrypi";
    public static final String SPP_UUID = "94f39d29-7d6d-437d-973b-fba39e49d4ee";
    public static final int STATE_NONE = 0; // we're doing nothing
    public static final int STATE_LISTEN = 1; // now listening for incoming connections (unused since no discovery)
    public static final int STATE_CONNECTING = 2; // now initiating an outgoing connection
    public static final int STATE_CONNECTED = 3; // now connected to a remote device
    private ConnectThread mConnectThread;
    private static ConnectedThread mConnectedThread;
    private static Handler mHandler = null;
    public static int mState = STATE_NONE;
    public static Context mContext;

    @Override
    public void onCreate() {
        Log.d("PrinterService", "Service started, OnCreate Started");
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver2, new IntentFilter("incomingMessage"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver3, new IntentFilter("bluetoothFailed"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver4, new IntentFilter("bluetoothConnected"));
        super.onCreate();
        Log.d("PrinterService", "OnCreate Ended");
        checkIfBluetoothIsOn();
    }

    private boolean checkIfBluetoothIsOn() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            //PrinterService.this.stop();
            return false;
            // Device does not support Bluetooth
        } else if (!mBluetoothAdapter.isEnabled()) {
            //PrinterService.this.stop();
            Log.d("PrinterService", "Bluetooth is Off");
            return false;
            // Bluetooth is not enabled :)
        } else {
            Log.d("PrinterService", "Bluetooth is On");
            // Bluetooth is enabled
            return true;
        }
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    };

    BroadcastReceiver mReceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    };

    BroadcastReceiver mReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    };

    BroadcastReceiver mReceiver4 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        mHandler = ((MyApplication) getApplication()).getHandler();
        return mBinder;
    }

    public class LocalBinder extends Binder {
        PrinterService getService() {
            return PrinterService.this;
        }
    }

    private final IBinder mBinder = new LocalBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("PrinterService", "Onstart Command Started");
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (checkIfBluetoothIsOn()) {
            connectToDevice("B8:27:EB:FD:52:0B");
        } else {
            PrinterService.this.stop();
        }
        return START_STICKY;
    }

    private synchronized void connectToDevice(String macAddress) {
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(macAddress);
        if (mState == STATE_CONNECTING) {
            if (mConnectThread != null) {
                mConnectThread.cancel();
                mConnectThread = null;
            }
        }

        // Cancel any thread currently running a connection
        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }
        mConnectThread = new ConnectThread(device);
        mConnectThread.start();
        setState(STATE_CONNECTING);
        Log.i(TAG, "Trying to connect in connectToDevice");
    }

    private void setState(int state) {
        PrinterService.mState = state;
        if (mHandler != null) {
            mHandler.obtainMessage(AbstractActivity.MESSAGE_STATE_CHANGE, state, -1).sendToTarget();
        }
    }

    public synchronized void stop() {
        setState(STATE_NONE);
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }

        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }
        if (mBluetoothAdapter != null) {
            mBluetoothAdapter.cancelDiscovery();
        }
        stopSelf();
    }

    @Override
    public boolean stopService(Intent name) {
        setState(STATE_NONE);
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }

        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }
        mBluetoothAdapter.cancelDiscovery();
        return super.stopService(name);
    }

    private void connectionFailed() {
        PrinterService.this.stop();
        Log.d(TAG, "Connection failed");
        sendFailed();
    }

    private void connectionLost() {
        PrinterService.this.stop();
        sendFailed();
    }

    private static Object obj = new Object();

    public static void write(byte[] out) {
        // Create temporary object
        ConnectedThread r;
        // Synchronize a copy of the ConnectedThread
        synchronized (obj) {
            if (mState != STATE_CONNECTED)
                return;
            r = mConnectedThread;
        }
        // Perform the write unsynchronized
        r.write(out);
    }

    private synchronized void connected(BluetoothSocket mmSocket, BluetoothDevice mmDevice) {
        // Cancel the thread that completed the connection
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
            Log.d(TAG, "Connected method: Cancelling the connection, ready to connect");
        }

        // Cancel any thread currently running a connection
        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
            Log.d(TAG, "cancel connection");
        }

        mConnectedThread = new ConnectedThread(mmSocket);
        mConnectedThread.start();
        Log.d(TAG, "connected through connected method");
        sendConnected();
        setState(STATE_CONNECTED);
    }

    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        public ConnectThread(BluetoothDevice device) {
            this.mmDevice = device;
            BluetoothSocket tmp = null;
            try {
                tmp = device.createRfcommSocketToServiceRecord(UUID.fromString(SPP_UUID));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mmSocket = tmp;
        }

        @Override
        public void run() {
            setName("ConnectThread");
            mBluetoothAdapter.cancelDiscovery();
            try {
                mmSocket.connect();
            } catch (IOException e) {
                try {
                    mmSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                connectionFailed();
                return;

            }
            synchronized (PrinterService.this) {
                mConnectThread = null;
            }
            connected(mmSocket, mmDevice);
        }

        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e("PrinterService", "close() of connect socket failed", e);
            }
        }
    }

    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                Log.e("Printer Service", "temp sockets not created", e);
            }
            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run(){
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes; // bytes returned from read()
            while (true) {
                // Read from the InputStream
                try {
                    bytes = mmInStream.read(buffer);
                    String incomingMessage = new String(buffer, 0, bytes);
                    Log.d(TAG, "InputStream: " + incomingMessage);

                    Intent incomingMessageIntent = new Intent("incomingMessage");
                    incomingMessageIntent.putExtra("theMessage" , incomingMessage);
                    LocalBroadcastManager.getInstance(mContext).sendBroadcast(incomingMessageIntent);

                } catch (IOException e) {
                    Log.e(TAG, "write: Error reading Input Stream. " + e.getMessage() );
                    connectionLost();
                    break;
                }
            }
        }

        public void write(byte[] bytes) {
            String text = new String(bytes, Charset.defaultCharset());
            Log.d(TAG, "write: Writing to outputstream: " + text);
            try {
                mmOutStream.write(bytes);
                Log.d(TAG, "After it should be written " + text);
            } catch (IOException e) {
                Log.e("PrinterService", "Exception during write", e);
            }
        }

        public void cancel() {
            try {
                mmSocket.close();

            } catch (IOException e) {
                Log.e("PrinterService", "close() of connect socket failed", e);
            }
            sendFailed();
        }

    }

    @Override
    public void onDestroy() {
        stop();
        Log.d("Printer Service", "Destroyed");
        super.onDestroy();
    }

    public void sendFailed(){
        String bluetoothFailed = "Not Connected";
        Intent incomingMessageIntent = new Intent("bluetoothFailed");
        incomingMessageIntent.putExtra("theMessage2" , bluetoothFailed);
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(incomingMessageIntent);
    }

    public void sendConnected(){
        String bluetoothConnected = "Connected";
        Intent incomingMessageIntent = new Intent("bluetoothConnected");
        incomingMessageIntent.putExtra("theMessage3" , bluetoothConnected);
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(incomingMessageIntent);
    }
}