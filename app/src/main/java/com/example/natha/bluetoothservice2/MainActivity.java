package com.example.natha.bluetoothservice2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;
    private static final String TAG = "OutputStream";
    ImageView legImage;
    int pic = R.drawable.legimage11; //set initial image as left facing prosthetic
    // Gesture object to change activity when swiping
    //private GestureDetectorCompat gestureObject;
    Float stepsValue;
    Float inclineValue;
    Float speedValueFloat;
    TextView incomingMessages;
    TextView inclineTextView;
    TextView bluetoothText;
    ImageButton controlButton;
    ImageButton bluetoothButton;
    ImageButton contactsButton;
    ImageButton graphButton;
    ImageButton btnClickLeft;
    ImageButton btnClickRight;
    TextView speedTextStatus;
    TextView controlTextStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //serviceIntent=new Intent(getApplicationContext(),PrinterService.class);
        //startService(serviceIntent); // starts the service
        //gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver2, new IntentFilter("incomingMessage"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver3, new IntentFilter("bluetoothFailed"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver4, new IntentFilter("bluetoothConnected"));
        incomingMessages = (TextView) findViewById(R.id.stepCounterStatus);
        inclineTextView = (TextView) findViewById(R.id.angleTextStatus);
        bluetoothText = (TextView) findViewById(R.id.bluetoothTextStatus);
        controlButton = (ImageButton) findViewById(R.id.controlButton);
        bluetoothButton = (ImageButton) findViewById(R.id.bluetoothButton);
        contactsButton = (ImageButton) findViewById(R.id.contactsButton);
        graphButton = (ImageButton) findViewById(R.id.graphButton);
        btnClickLeft = (ImageButton) findViewById(R.id.btnClickLeft);
        btnClickRight = (ImageButton) findViewById(R.id.btnClickRight);
        speedTextStatus = (TextView) findViewById(R.id.speedTextStatus);
        controlTextStatus = (TextView) findViewById(R.id.controlTextStatus);
    }

    public void graph1() {
        graphButton.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                graphButton.setColorFilter(Color.WHITE);
            }
        }.start();
        Intent myintent5 = new Intent(this, GraphActivity.class); // new intent of analytics activity
        startActivity(myintent5); // start activity , switch to graph1
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goGraphActivity(View view) {
        graph1();
    }

    public void goToControl() {
        controlButton.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                controlButton.setColorFilter(Color.WHITE);
            }
        }.start();
        Intent myintent6 = new Intent(this, ControlActivity.class); // new intent of analytics activity
        startActivity(myintent6); // start activity , switch to control activity
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goControlActivity(View view) {
        goToControl();
    }

    public void contacts1() {
        contactsButton.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                contactsButton.setColorFilter(Color.WHITE);
            }
        }.start();
        Intent myintent7 = new Intent(this, ContactsActivity.class); // new intent of analytics activity
        startActivity(myintent7); // start activity , switch to graph1
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); // insert animations
    }

    public void goContactsActivity(View view) {
        contacts1();
    }

    public void service1() {
        bluetoothButton.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                bluetoothButton.setColorFilter(Color.WHITE);
            }
        }.start();
        serviceIntent=new Intent(getApplicationContext(),PrinterService.class);
        startService(serviceIntent); // starts the service
    }

    public void startService(View view) {
        service1();
    }

    //Methods for right button. Checks what direction the prosthetic is facing, changes the image by a 90 degree rotation and sets it as the new image
    public void ImageChangeButtonRight(View view) {
        legImage = findViewById(R.id.legImage);
        if (pic == R.drawable.leftfacing) { //if prosthetic is facing left
            legImage.setImageResource(R.drawable.frontfacing);
            pic = R.drawable.frontfacing;
        } else if (pic == R.drawable.frontfacing) {
            legImage.setImageResource(R.drawable.rightfacing);
            pic = R.drawable.rightfacing;
        } else if (pic == R.drawable.rightfacing) {
            legImage.setImageResource(R.drawable.backfacing);
            pic = R.drawable.backfacing;
        } else if (pic == R.drawable.backfacing) {
            legImage.setImageResource(R.drawable.leftfacing);
            pic = R.drawable.leftfacing;
        }
    }

    public void ImageButtonRight(View view) {
        btnClickRight.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                btnClickRight.setColorFilter(Color.WHITE);
            }
        }.start();
        legImage = findViewById(R.id.legImage);
        if (pic == R.drawable.legimage1) { //if prosthetic is facing left
            legImage.setImageResource(R.drawable.legimage2);
            pic = R.drawable.legimage2;
        } else if (pic == R.drawable.legimage2) {
            legImage.setImageResource(R.drawable.legimage3);
            pic = R.drawable.legimage3;
        } else if (pic == R.drawable.legimage3) {
            legImage.setImageResource(R.drawable.legimage4);
            pic = R.drawable.legimage4;
        } else if (pic == R.drawable.legimage4) {
            legImage.setImageResource(R.drawable.legimage5);
            pic = R.drawable.legimage5;
        } else if (pic == R.drawable.legimage5) {
            legImage.setImageResource(R.drawable.legimage6);
            pic = R.drawable.legimage6;
        } else if (pic == R.drawable.legimage6) {
            legImage.setImageResource(R.drawable.legimage7);
            pic = R.drawable.legimage7;
        } else if (pic == R.drawable.legimage7) {
            legImage.setImageResource(R.drawable.legimage8);
            pic = R.drawable.legimage8;
        } else if (pic == R.drawable.legimage8) {
            legImage.setImageResource(R.drawable.legimage9);
            pic = R.drawable.legimage9;
        } else if (pic == R.drawable.legimage9) {
            legImage.setImageResource(R.drawable.legimage10);
            pic = R.drawable.legimage10;
        } else if (pic == R.drawable.legimage10) {
            legImage.setImageResource(R.drawable.legimage11);
            pic = R.drawable.legimage11;
        } else if (pic == R.drawable.legimage11) {
            legImage.setImageResource(R.drawable.legimage12);
            pic = R.drawable.legimage12;
        } else if (pic == R.drawable.legimage12) {
            legImage.setImageResource(R.drawable.legimage1);
            pic = R.drawable.legimage1;
        }
    }

    public void ImageButtonLeft(View view) {
        btnClickLeft.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                btnClickLeft.setColorFilter(Color.WHITE);
            }
        }.start();
        legImage = findViewById(R.id.legImage);
        if (pic == R.drawable.legimage1) { //if prosthetic is facing left
            legImage.setImageResource(R.drawable.legimage12);
            pic = R.drawable.legimage12;
        } else if (pic == R.drawable.legimage2) {
            legImage.setImageResource(R.drawable.legimage1);
            pic = R.drawable.legimage1;
        } else if (pic == R.drawable.legimage3) {
            legImage.setImageResource(R.drawable.legimage2);
            pic = R.drawable.legimage2;
        } else if (pic == R.drawable.legimage4) {
            legImage.setImageResource(R.drawable.legimage3);
            pic = R.drawable.legimage3;
        } else if (pic == R.drawable.legimage5) {
            legImage.setImageResource(R.drawable.legimage4);
            pic = R.drawable.legimage4;
        } else if (pic == R.drawable.legimage6) {
            legImage.setImageResource(R.drawable.legimage5);
            pic = R.drawable.legimage5;
        } else if (pic == R.drawable.legimage7) {
            legImage.setImageResource(R.drawable.legimage6);
            pic = R.drawable.legimage6;
        } else if (pic == R.drawable.legimage8) {
            legImage.setImageResource(R.drawable.legimage7);
            pic = R.drawable.legimage7;
        } else if (pic == R.drawable.legimage9) {
            legImage.setImageResource(R.drawable.legimage8);
            pic = R.drawable.legimage8;
        } else if (pic == R.drawable.legimage10) {
            legImage.setImageResource(R.drawable.legimage9);
            pic = R.drawable.legimage9;
        } else if (pic == R.drawable.legimage11) {
            legImage.setImageResource(R.drawable.legimage10);
            pic = R.drawable.legimage10;
        } else if (pic == R.drawable.legimage12) {
            legImage.setImageResource(R.drawable.legimage11);
            pic = R.drawable.legimage11;
        }
    }
    //Methods for left button. Checks what direction the prosthetic is facing, changes the image by a 90 degree rotation and sets it as the new image
    public void ImageChangeButtonLeft(View view) {
        legImage = findViewById(R.id.legImage);
        if (pic == R.drawable.leftfacing) {
            legImage.setImageResource(R.drawable.backfacing);
            pic = R.drawable.backfacing;
        } else if (pic == R.drawable.backfacing) {
            legImage.setImageResource(R.drawable.rightfacing);
            pic = R.drawable.rightfacing;
        } else if (pic == R.drawable.rightfacing) {
            legImage.setImageResource(R.drawable.frontfacing);
            pic = R.drawable.frontfacing;
        } else if (pic == R.drawable.frontfacing) {
            legImage.setImageResource(R.drawable.leftfacing);
            pic = R.drawable.leftfacing;
        }
    }

   /* // Method to capture motion events for swiping between activities
    @Override
    public boolean onTouchEvent (MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // Class to learn swipe gesture
    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        // SimpleOnGestureListener listens for what we want to do and how

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY){
            if (event2.getX() > event1.getX()){ // action when swiping left
                graph1();
            }
            else if(event2.getX() < event1.getX()){ // action when swiping right
                Contact();
            }
            return true;
        }
    }*/

    BroadcastReceiver mReceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text2 = intent.getStringExtra("theMessage");
            //Log.i("text2: ", text2);
            String[] values2 = text2.split(",");
            Log.i("values2", values2[6]);
            String text3 = values2[6];
            try {
                stepsValue = Float.parseFloat(text3);
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
            }

            incomingMessages.setText(text3);
            Log.i("onReceive: ", "" +stepsValue);

            String inclineStatus = values2[5];

            try {
                inclineValue = Float.parseFloat(inclineStatus);
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
            }

            if (inclineValue == 0) {
                inclineTextView.setText("Flat Ground");
            }   else {
                inclineTextView.setText("Incline Ground");
            }

            String speedValueString = values2[7];

            try {
                speedValueFloat = Float.parseFloat(speedValueString);
            }
            catch (NumberFormatException e)
            {
                //h
            }

            if (speedValueFloat == 0) {
                speedTextStatus.setText("Low Speed");
            }   else {
                    speedTextStatus.setText("High Speed");
            }
        }
    };

    BroadcastReceiver mReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text3 = intent.getStringExtra("theMessage2");
            bluetoothText.setText(text3);
        }
    };

    BroadcastReceiver mReceiver4 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text4 = intent.getStringExtra("theMessage3");
            bluetoothText.setText(text4);
        }
    };
}
