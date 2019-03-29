package com.example.natha.bluetoothservice2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.Manifest.permission.CALL_PHONE;

public class ContactsActivity extends AppCompatActivity {

    private Button button;
    ImageButton contactshomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        button = (Button) findViewById(R.id.buttonCall);
        contactshomebutton = (ImageButton) findViewById(R.id.contactshomebutton);

        // add button listener
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:07534824108"));
                startActivity(callIntent);

            }

        });

    }

    public void main1() {
        contactshomebutton.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                contactshomebutton.setColorFilter(Color.WHITE);
            }
        }.start();
        /*Intent myintent7 = new Intent(this, MainActivity.class); // new intent of analytics activity
        startActivity(myintent7); // start activity , switch to graph1*/
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goMainActivity(View view) {
        main1();
    }
}
