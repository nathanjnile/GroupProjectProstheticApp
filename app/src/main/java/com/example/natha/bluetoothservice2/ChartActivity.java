package com.example.natha.bluetoothservice2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    BarChart barChart;
    List<BarEntry> barEntries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        barChart = (BarChart) findViewById(R.id.bar_chart);

        barEntries.add(new BarEntry(0f, 30f));
        barEntries.add(new BarEntry(1f, 80f));
        barEntries.add(new BarEntry(2f, 60f));
        barEntries.add(new BarEntry(3f, 50f));
        // gap of 2f
        barEntries.add(new BarEntry(5f, 70f));
        barEntries.add(new BarEntry(6f, 60f));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");
        barDataSet.setColor(Color.RED);

        List<String> theDates = new ArrayList<>();
        theDates.add("April");
        theDates.add("May");
        theDates.add("June");
        theDates.add("July");

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);
        barChart.setFitBars(true);
        barChart.setData(data);
        barChart.invalidate();
    }
}
