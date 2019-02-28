package com.example.natha.bluetoothservice2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

//import java.util.ArrayList;
//import java.util.List;

public class GraphActivity extends AppCompatActivity {

    //List<String> list = new ArrayList<>();
    TextView incomingMessages;
    StringBuilder messages;

    private RelativeLayout relativeLayout;
    private LineChart mChart;
    float foo;
    float foo1;
    float foo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        addEmptyGraph();

        incomingMessages = (TextView) findViewById(R.id.incomingMessage2);
        messages = new StringBuilder();
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));
    }

    public void GoToSecond() {
        Intent myintent6 = new Intent(this, SecondActivity.class); // new intent of analytics activity
        startActivity(myintent6); // start activity , switch to graph1
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // insert animations
    }


    public void goSecondActivity(View view) {
        GoToSecond();
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text = intent.getStringExtra("theMessage");
            Log.i("Data Values: ", text);
            String[] values = text.split(",");
            Log.i("EMG: ", values[0]);
            Log.i("time", values[1]);
            //list.add(text);
            //Log.i("List", ""+list);
            //int foo;
            try {
                foo = Float.parseFloat(text);
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
            }

            try {
                foo1 = Float.parseFloat(values[0]);
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
            }

            try {
                foo2 = Float.parseFloat((values[1]));
            }
            catch (NumberFormatException e)
            {
                //foo = 0;
            }

            Log.i("onReceive: ","" + foo1);
            Log.i("onReceive: ","" + foo2);

            addEntry();

            //Log.i("Float is", ""+ foo);
            //messages.append(text + "\n");

            //incomingMessages.setText(foo);
        }

    };

    public void addEmptyGraph() {

        relativeLayout = findViewById(R.id.relativeLayout);


        // create line chart
        mChart =  new LineChart(this);
        //add to  layout
        relativeLayout.addView(mChart);
        //customize line chart
        mChart.setNoDataTextDescription("");
        mChart.setNoDataText("No data for the moment");

        //enable value highlighting
        mChart.setHighlightEnabled(true);
        //enable touch
        mChart.setTouchEnabled(true);
        //we want also scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);

        //enable pinch zoom to avoid scaling x and y axis separately

        mChart.setPinchZoom(true);

        //alternative backgroundColor
        mChart.setBackgroundColor(Color.BLACK);

        //now , we work on data
        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);

        //  add data to line chart
        mChart.setData(data);

        // get legend object
        Legend l = mChart.getLegend();

        //customize legend
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.WHITE);

        XAxis x1 = mChart.getXAxis();
        x1.setTextColor(Color.WHITE);
        x1.setDrawGridLines(false);
        x1.setAvoidFirstLastClipping(true);

        YAxis y1 = mChart.getAxisLeft();
        y1.setTextColor(Color.WHITE);
        y1.setAxisMaxValue(5f);
        y1.setDrawGridLines(false);

        YAxis y12 = mChart.getAxisRight();
        y12.setEnabled(false);
    }

    private void addEntry(){
        LineData data = mChart.getData();

        if (data != null) {
            LineDataSet set = data.getDataSetByIndex(0);

            if (set == null) {
                //creation if null
                set = createSet();
                data.addDataSet(set);
            }
            // add a new random value
            data.addXValue("");
            data.addEntry(new Entry(foo, set.getEntryCount()),0);

            //notify chart data have changed
            mChart.notifyDataSetChanged();
            // limit number if visible entreies
            mChart.setVisibleXRange(30);
            //scroll to the last entry
            mChart.moveViewToX(data.getXValCount()-7);
        }
    }

    private LineDataSet createSet() {
        LineDataSet set = new LineDataSet(null,"EMG Signal");
        set.setDrawCubic(true);
        set.setCubicIntensity(0.2f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setCircleColor(ColorTemplate.getHoloBlue());
        set.setLineWidth(2f);
        set.setCircleSize(4f);
        set.setFillAlpha(65);
        set.setFillColor(ColorTemplate.getHoloBlue());
        set.setHighLightColor(Color.rgb(244,117,177));
        set.setValueTextColor(Color.WHITE);
        set.setValueTextSize(4f);

        return set;

    }

}
