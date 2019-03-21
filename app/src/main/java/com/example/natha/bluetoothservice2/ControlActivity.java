package com.example.natha.bluetoothservice2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ControlActivity extends AppCompatActivity {

    ImageView controlfoot;
    ImageButton upbutton;
    ImageButton downbutton;
    ImageButton lockbutton;
    ImageButton unlockbutton;
    ImageButton maxbutton;
    ImageButton minbutton;
    int angle;
    PrinterService mPrinterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        controlfoot = (ImageView) findViewById(R.id.controlfootimage);
        upbutton = (ImageButton) findViewById(R.id.moveupbutton);
        downbutton = (ImageButton) findViewById(R.id.movedownbutton);
        lockbutton = (ImageButton) findViewById(R.id.lockbutton);
        maxbutton = (ImageButton) findViewById(R.id.maxbutton);
        minbutton = (ImageButton) findViewById(R.id.minbutton);

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle - 10;
                byte[] bytes = "dorsiflex".getBytes();
                mPrinterService.write(bytes);
                controlfoot.setRotation(angle);
            }
        });

        downbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle + 10;
                byte[] bytes = "plantarflex".getBytes();
                mPrinterService.write(bytes);
                controlfoot.setRotation(angle);
            }
        });

        lockbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "lock".getBytes();
                mPrinterService.write(bytes);
            }
        });

        maxbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "maxdorsiflex".getBytes();
                mPrinterService.write(bytes);
            }
        });

        minbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "maxplantarflex".getBytes();
                mPrinterService.write(bytes);
            }
        });

    }
}
