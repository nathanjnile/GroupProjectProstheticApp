package com.example.natha.bluetoothservice2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StepActivity extends AppCompatActivity {

    TextView incomingMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver2, new IntentFilter("incomingMessage"));
        incomingMessages = (TextView) findViewById(R.id.incomingMessage);
    }

    public void graph1() {
        Intent myintent5 = new Intent(this, GraphActivity.class); // new intent of analytics activity
        startActivity(myintent5); // start activity , switch to graph1
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goGraphActivity(View view) {
        graph1();
    }

    BroadcastReceiver mReceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text2 = intent.getStringExtra("theMessage");
            //Log.i("text2: ", text2);
            String[] values2 = text2.split(",");
            Log.i("values2", values2[2]);
            String text3 = values2[2];
            incomingMessages.setText(text3);
        }
    };
}
