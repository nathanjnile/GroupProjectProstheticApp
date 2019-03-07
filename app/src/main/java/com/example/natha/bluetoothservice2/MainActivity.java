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
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;
    ImageView legImage;
    int pic = R.drawable.leftfacing; //set initial image as left facing prosthetic
   // TextView incomingMessages;
    //StringBuilder messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent=new Intent(getApplicationContext(),PrinterService.class);
        startService(serviceIntent); // starts the service
    }

    public void graph1() {
        Intent myintent5 = new Intent(this, GraphActivity.class); // new intent of analytics activity
        startActivity(myintent5); // start activity , switch to graph1
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goGraphActivity(View view) {
        graph1();
    }

    //Methods for right button. Checks what direction the prosthetic is facing, changes the image by a 90 degree rotation and sets it as the new image
    public void ImageChangeButtonRight(View view) {
        if (pic == R.drawable.leftfacing) { //if prosthetic is facing left
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.frontfacing));
            pic = R.drawable.frontfacing;
        } else if (pic == R.drawable.frontfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.rightfacing));
            pic = R.drawable.rightfacing;
        } else if (pic == R.drawable.rightfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.backfacing));
            pic = R.drawable.backfacing;
        } else if (pic == R.drawable.backfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.leftfacing));
            pic = R.drawable.leftfacing;
        }
        //legImage=(ImageView) findViewById(R.id.legImage);
        //legImage.setImageDrawable(getDrawable(R.drawable.frontfacing));
    }
    //Methods for left button. Checks what direction the prosthetic is facing, changes the image by a 90 degree rotation and sets it as the new image
    public void ImageChangeButtonLeft(View view) {
        if (pic == R.drawable.leftfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.backfacing));
            pic = R.drawable.backfacing;
        } else if (pic == R.drawable.backfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.rightfacing));
            pic = R.drawable.rightfacing;
        } else if (pic == R.drawable.rightfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.frontfacing));
            pic = R.drawable.frontfacing;
        } else if (pic == R.drawable.frontfacing) {
            legImage = (ImageView) findViewById(R.id.legImage);
            legImage.setImageDrawable(getDrawable(R.drawable.leftfacing));
            pic = R.drawable.leftfacing;
        }
    }
}
