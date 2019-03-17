package com.example.natha.bluetoothservice2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ControlActivity extends AppCompatActivity {

    ImageView controlfoot;
    Button upbutton;
    Button downbutton;
    int angle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        controlfoot = (ImageView) findViewById(R.id.controlfootimage);
        upbutton = (Button) findViewById(R.id.upbutton);
        downbutton = (Button) findViewById(R.id.downbutton);

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle - 10;

                controlfoot.setRotation(angle);
            }
        });

        downbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle + 10;

                controlfoot.setRotation(angle);
            }
        });


    }
}
