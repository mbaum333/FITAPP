package com.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class heartrate extends AppCompatActivity {
    ArrayList barArrayList;
    ArrayList lineArrayList;
    String[] intensity = {"Relaxed", "Light", "Intense", "Aerobic", "Anaerobic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartrate);

        BarChart barChart = findViewById(R.id.heartRateBarChart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList, "Minutes In Each Heart Rate Zone");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        XAxis xaxis = barChart.getXAxis();
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setGranularity(1f);
        xaxis.setValueFormatter(new IndexAxisValueFormatter(intensity));
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getAxisLeft().setDrawLabels(false);
        barChart.getXAxis().setDrawGridLines(false);

        LineChart lineChart = findViewById(R.id.heartRateLineChart);
        getData2();
        LineDataSet lineDataSet = new LineDataSet(lineArrayList, "BPM Over 24hr");
        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.getDescription().setEnabled(false);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.RED);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawLabels(false);
        lineChart.getXAxis().setDrawGridLines(false);

        final List<Integer> dailyBPM = Arrays.asList(55, 58, 60 ,61, 52, 63, 69, 172, 100, 85, 80, 72, 70, 75, 76, 77, 78, 74, 72, 70, 73, 73, 73);
        Double average = dailyBPM.stream().mapToInt(val -> val).average().orElse(0);
        int averageInt = (int) Math.round(average);

        EditText editMax = (EditText) findViewById(R.id.dailyMax);
        editMax.setText("Max: " + Collections.max(dailyBPM) + " BPM");

        EditText editMin = (EditText) findViewById(R.id.dailyMin);
        editMin.setText("Min: " + Collections.min(dailyBPM) + " BPM");

        EditText editAvg = (EditText) findViewById(R.id.dailyAvg);
        editAvg.setText("Avg: " + averageInt + " BPM");

    }
    public void getData() {
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(0, 471, "Relaxed"));
        barArrayList.add(new BarEntry(1, 16, "Light"));
        barArrayList.add(new BarEntry(2, 5, "Intense"));
        barArrayList.add(new BarEntry(3, 7, "Aerobic"));
        barArrayList.add(new BarEntry(4, 25,"Anaerobic"));
    }
    public void getData2() {
        lineArrayList = new ArrayList();
        lineArrayList.add(new Entry(0, 55));
        lineArrayList.add(new Entry(1, 58));
        lineArrayList.add(new Entry(2, 60));
        lineArrayList.add(new Entry(3, 61));
        lineArrayList.add(new Entry(4, 52));
        lineArrayList.add(new Entry(5, 63));
        lineArrayList.add(new Entry(6, 69));
        lineArrayList.add(new Entry(7, 172));
        lineArrayList.add(new Entry(8, 100));
        lineArrayList.add(new Entry(9, 85));
        lineArrayList.add(new Entry(10, 80));
        lineArrayList.add(new Entry(11, 72));
        lineArrayList.add(new Entry(12, 70));
        lineArrayList.add(new Entry(13, 75));
        lineArrayList.add(new Entry(14, 76));
        lineArrayList.add(new Entry(15, 77));
        lineArrayList.add(new Entry(16, 78));
        lineArrayList.add(new Entry(17, 74));
        lineArrayList.add(new Entry(18, 72));
        lineArrayList.add(new Entry(19, 70));
        lineArrayList.add(new Entry(20, 73));
        lineArrayList.add(new Entry(21, 73));
        lineArrayList.add(new Entry(22, 73));
        lineArrayList.add(new Entry(23, 73));
    }
}