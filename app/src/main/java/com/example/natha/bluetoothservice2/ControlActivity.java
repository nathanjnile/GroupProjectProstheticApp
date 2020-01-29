package com.example.natha.bluetoothservice2;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ControlActivity extends AppCompatActivity {

    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton lockButton;
    private ImageButton maxButton;
    private ImageButton minButton;
    private ImageButton homeButtonControl;
    private ImageButton resetButton;
    private ImageButton recalibrateButton;
    private ImageButton unlockButton;
    private TextView previousActionText;
    BluetoothService mBluetoothService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        upButton = findViewById(R.id.moveupbutton);
        downButton = findViewById(R.id.movedownbutton);
        lockButton = findViewById(R.id.lockbutton);
        maxButton = findViewById(R.id.maxbutton);
        minButton = findViewById(R.id.minbutton);
        homeButtonControl = findViewById(R.id.homebuttoncontrol);
        resetButton = findViewById(R.id.resetbutton);
        recalibrateButton = findViewById(R.id.recalibratebutton);
        unlockButton = findViewById(R.id.unlockbutton);
        previousActionText = findViewById(R.id.previousactiontext);

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "dorsiflex".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Move Up");
                upButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        upButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "plantarflex".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Move Down");
                downButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        downButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        lockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "lock".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Lock Angle");
                lockButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        lockButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        maxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "maxdorsiflex".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Maximum Angle");
                maxButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        maxButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "maxplantarflex".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Minimum Angle");
                minButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        minButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "resetposition".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Reset Position");
                resetButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        resetButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        recalibrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "recalibrate".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Re-Calibrate");
                recalibrateButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        recalibrateButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] bytes = "unlock".getBytes();
                mBluetoothService.write(bytes);
                previousActionText.setText("Unlock Angle");
                unlockButton.setColorFilter(Color.BLACK);
                new CountDownTimer(100, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        unlockButton.setColorFilter(Color.WHITE);
                    }
                }.start();
            }
        });

    }

    public void main1() {
        homeButtonControl.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
            }

            @Override
            public void onFinish() {
                homeButtonControl.setColorFilter(Color.WHITE);
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
