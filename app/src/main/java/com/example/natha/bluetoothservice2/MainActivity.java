package com.example.natha.bluetoothservice2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Printer;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;
   // TextView incomingMessages;
    //StringBuilder messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // incomingMessages = (TextView) findViewById(R.id.incomingMessage);
        //messages = new StringBuilder();
       // LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));

        serviceIntent=new Intent(getApplicationContext(),PrinterService.class);
        startService(serviceIntent); // starts the service
    }

    public void graph1() {
        Intent myintent5 = new Intent(this, GraphActivity.class); // new intent of analytics activity
        startActivity(myintent5); // start activity , switch to graph1
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goGraphActivity(View view) {
        graph1();
    }

    /*BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //String text = intent.getStringExtra("theMessage");

            //messages.append(text + "\n");

            //incomingMessages.setText(text);
        }
    };*/
}
