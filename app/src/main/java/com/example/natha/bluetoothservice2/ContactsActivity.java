package com.example.natha.bluetoothservice2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContactsActivity extends AppCompatActivity {

    private ImageButton callButton;
    private ImageButton contactsHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        callButton = findViewById(R.id.callbutton);
        contactsHomeButton = findViewById(R.id.contactshomebutton);

        // add button listener
        callButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0753424107"));
                startActivity(callIntent);

                callButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        callButton.setColorFilter(Color.WHITE);
                    }
                }.start();

            }

        });

    }

    public void main1() {
        contactsHomeButton.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                contactsHomeButton.setColorFilter(Color.WHITE);
            }
        }.start();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }

    public void goMainActivity(View view) {
        main1();
    }
}
