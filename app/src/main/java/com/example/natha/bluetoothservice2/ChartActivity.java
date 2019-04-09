package com.example.natha.bluetoothservice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        barChart = (BarChart) findViewById(R.id.bar_chart);

        barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(80f,1));
        barEntries.add(new BarEntry(30f,2));
        barEntries.add(new BarEntry(10f,3));

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("April");
        theDates.add("May");
        theDates.add("June");
        theDates.add("July");
    }
}
