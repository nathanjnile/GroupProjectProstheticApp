package com.example.natha.bluetoothservice2;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ControlActivity extends AppCompatActivity {

    //ImageView controlfoot;
    ImageButton upbutton;
    ImageButton downbutton;
    ImageButton lockbutton;
    ImageButton maxbutton;
    ImageButton minbutton;
    ImageButton homebuttoncontrol;
    ImageButton resetbutton;
    ImageButton recalibratebutton;
    ImageButton unlockbutton;
    TextView previousactiontext;
    //int angle;
    PrinterService mPrinterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        //controlfoot = (ImageView) findViewById(R.id.controlfootimage);
        upbutton = (ImageButton) findViewById(R.id.moveupbutton);
        downbutton = (ImageButton) findViewById(R.id.movedownbutton);
        lockbutton = (ImageButton) findViewById(R.id.lockbutton);
        maxbutton = (ImageButton) findViewById(R.id.maxbutton);
        minbutton = (ImageButton) findViewById(R.id.minbutton);
        homebuttoncontrol = (ImageButton) findViewById(R.id.homebuttoncontrol);
        resetbutton = (ImageButton) findViewById(R.id.resetbutton);
        recalibratebutton = (ImageButton) findViewById(R.id.recalibratebutton);
        unlockbutton = (ImageButton) findViewById(R.id.unlockbutton);
        previousactiontext = (TextView) findViewById(R.id.previousactiontext);

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //angle = angle - 2;
                byte[] bytes = "dorsiflex".getBytes();
                mPrinterService.write(bytes);
                //controlfoot.setRotation(angle);
                previousactiontext.setText("Move Up");
                upbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        upbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        downbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //angle = angle + 2;
                byte[] bytes = "plantarflex".getBytes();
                mPrinterService.write(bytes);
                //controlfoot.setRotation(angle);
                previousactiontext.setText("Move Down");
                downbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        downbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        lockbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "lock".getBytes();
                mPrinterService.write(bytes);
                previousactiontext.setText("Lock");
                lockbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        lockbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        maxbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "maxdorsiflex".getBytes();
                mPrinterService.write(bytes);
                previousactiontext.setText("Maximum Angle");
                maxbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        maxbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        minbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "maxplantarflex".getBytes();
                mPrinterService.write(bytes);
                previousactiontext.setText("Minimum Angle");
                minbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        minbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "resetposition".getBytes();
                mPrinterService.write(bytes);
                previousactiontext.setText("Reset Position");
                resetbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        resetbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        recalibratebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "recalibrate".getBytes();
                mPrinterService.write(bytes);
                previousactiontext.setText("Re-Calibrate");
                recalibratebutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        recalibratebutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        unlockbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "unlock".getBytes();
                mPrinterService.write(bytes);
                previousactiontext.setText("Unlock Angle");
                unlockbutton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onFinish() {
                        unlockbutton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

    }

    public void main1() {
        homebuttoncontrol.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                homebuttoncontrol.setColorFilter(Color.WHITE);
            }
        }.start();
        /*Intent myintent7 = new Intent(this, MainActivity.class); // new intent of analytics activity
        startActivity(myintent7); // start activity , switch to graph1*/
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); // insert animations
    }

    public void goMainActivity(View view) {
        main1();
    }
}
