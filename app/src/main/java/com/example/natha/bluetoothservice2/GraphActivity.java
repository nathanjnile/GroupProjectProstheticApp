package com.example.natha.bluetoothservice2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GraphActivity extends AppCompatActivity {

    LineChart mpLineChart;
    List<Entry> entries = new LinkedList<>();

    float time;
    float emgSignal;

    ImageButton homebuttongraph;

    //private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        addValues();
        //graphCreate();

        //incomingMessages = (TextView) findViewById(R.id.incomingMessage2);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));
        //gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        homebuttongraph= (ImageButton) findViewById(R.id.homebuttongraph);

    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text = intent.getStringExtra("theMessage");
            Log.i("Data Values: ", text);
            String[] values = text.split(",");
            Log.i("EMG", values[0]);
            Log.i("time", values[1]);

            try {
                time = Float.parseFloat(values[0]);
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
            }
            try {
                emgSignal = Float.parseFloat((values[1]));
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
                emgSignal = emgSignal + (float) 0.01;
            }

            addValues();

        }

    };

    public void graphCreate() {
        mpLineChart = findViewById(R.id.line_chart);
        LineDataSet lineDataSet1 = new LineDataSet(entries,"");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();
        lineDataSet1.setCubicIntensity(0.2f);
        lineDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet1.setColor(Color.rgb(220,110,0));
        lineDataSet1.setDrawCircles(false);
        //lineDataSet1.setCircleColor(Color.rgb(8,120,196));
        lineDataSet1.setLineWidth(2f);
        lineDataSet1.setFillAlpha(65);
        lineDataSet1.setFillColor(ColorTemplate.getHoloBlue());
        //lineDataSet1.setCircleHoleColor(Color.rgb(8,120,196));
        lineDataSet1.setHighLightColor(Color.rgb(244,117,177));
        lineDataSet1.setValueTextColor(Color.WHITE);
        //lineDataSet1.setCircleRadius(1f);
        lineDataSet1.setValueTextSize(5f);
        lineDataSet1.setDrawValues(false);
        lineDataSet1.setLabel("");
        mpLineChart.setNoDataText("No data for the moment");
        mpLineChart.setTouchEnabled(true);
        mpLineChart.setDragEnabled(true);
        mpLineChart.setScaleEnabled(true);
        mpLineChart.setDrawGridBackground(false);
        mpLineChart.setPinchZoom(true);
        mpLineChart.setBackgroundColor(Color.rgb(29,29,29));
        mpLineChart.setVisibleXRangeMaximum(3f);
        mpLineChart.moveViewToX(data.getEntryCount());
        //Legend l = mpLineChart.getLegend();
        //l.setForm(Legend.LegendForm.LINE);
        //l.setTextColor(Color.WHITE);
        //l.setXOffset(70f);
        XAxis x1 = mpLineChart.getXAxis();
        x1.setTextColor(Color.WHITE);
        x1.setDrawGridLines(true);
        x1.setAvoidFirstLastClipping(true);
        x1.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis y1 = mpLineChart.getAxisLeft();
        y1.setTextColor(Color.WHITE);
        y1.setDrawGridLines(true);
        YAxis y12 = mpLineChart.getAxisRight();
        y12.setEnabled(true);
        y12.setTextColor(Color.WHITE);
    }

    public void addValues(){
        //Log.i("time: ", "" + time);
        //Log.i("emgSignal: ", "" + emgSignal);

        if (emgSignal != 0) {
            entries.add(new Entry(emgSignal, time));
            graphCreate();
        }

        if (entries.size()> 60) {
            entries.remove(0);
        }

        Log.i("entriesarray", "" +entries);
        Log.i("entries size", "" +entries.size());
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

            }
            else if(event2.getX() < event1.getX()){ // action when swiping right
                finish();
            }
            return true;
        }
    }*/

    public void main1() {
        homebuttongraph.setColorFilter(Color.BLACK);
        new CountDownTimer(100, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                homebuttongraph.setColorFilter(Color.WHITE);
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
