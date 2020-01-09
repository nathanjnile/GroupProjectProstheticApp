package com.example.natha.bluetoothservice2;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ControlActivity extends AppCompatActivity {

    private ImageButton upbutton;
    private ImageButton downbutton;
    private ImageButton lockbutton;
    private ImageButton maxbutton;
    private ImageButton minbutton;
    private ImageButton homebuttoncontrol;
    private ImageButton resetbutton;
    private ImageButton recalibratebutton;
    private ImageButton unlockbutton;
    private TextView previousactiontext;
    PrinterService mPrinterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        upbutton = findViewById(R.id.moveupbutton);
        downbutton = findViewById(R.id.movedownbutton);
        lockbutton = findViewById(R.id.lockbutton);
        maxbutton = findViewById(R.id.maxbutton);
        minbutton = findViewById(R.id.minbutton);
        homebuttoncontrol = findViewById(R.id.homebuttoncontrol);
        resetbutton = findViewById(R.id.resetbutton);
        recalibratebutton = findViewById(R.id.recalibratebutton);
        unlockbutton = findViewById(R.id.unlockbutton);
        previousactiontext = findViewById(R.id.previousactiontext);

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "dorsiflex".getBytes();
                mPrinterService.write(bytes);
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
                previousactiontext.setText("Lock Angle");
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
