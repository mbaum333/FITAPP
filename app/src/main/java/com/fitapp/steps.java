package com.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class steps extends AppCompatActivity {
    ArrayList dailyStepsBarArray;
    ArrayList weeklyStepsBarArray;
    ArrayList monthlyStepsBarArray;
    String[] weekly = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    String[] monthly = {"Week Ending 1/7", "Week Ending 1/14", "Week Ending 1/21", "Week Ending 1/28"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        BarChart dailyStepsBarChart = findViewById(R.id.dailyStepsBarChart);
        getDailyData();
        BarDataSet dailyStepsBarDataSet = new BarDataSet(dailyStepsBarArray, "Steps per Hour");
        BarData dailyStepsBarData = new BarData(dailyStepsBarDataSet);
        dailyStepsBarChart.setData(dailyStepsBarData);
        dailyStepsBarChart.getDescription().setEnabled(false);
        dailyStepsBarDataSet.setColor(Color.RED);
        XAxis xaxis = dailyStepsBarChart.getXAxis();
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setGranularity(1f);
        dailyStepsBarChart.getAxisLeft().setDrawGridLines(false);
        dailyStepsBarChart.getXAxis().setDrawGridLines(false);
        dailyStepsBarChart.setDrawValueAboveBar(false);
        dailyStepsBarChart.getAxisRight().setDrawLabels(false);
        dailyStepsBarDataSet.setValueTextSize(0f);


        BarChart weeklyStepsBarChart = findViewById(R.id.weeklyStepsBarChart);
        getWeeklyData();
        BarDataSet weeklyStepsBarDataSet = new BarDataSet(weeklyStepsBarArray, "Steps per Day");
        BarData weeklyStepsBarData = new BarData(weeklyStepsBarDataSet);
        weeklyStepsBarChart.setData(weeklyStepsBarData);
        weeklyStepsBarChart.getDescription().setEnabled(false);
        weeklyStepsBarDataSet.setColor(Color.RED);
        XAxis xaxis2 = weeklyStepsBarChart.getXAxis();
        xaxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis2.setValueFormatter(new IndexAxisValueFormatter(weekly));
        YAxis yAxis = weeklyStepsBarChart.getAxis(YAxis.AxisDependency.LEFT);
        yAxis.setStartAtZero(true);
        weeklyStepsBarChart.getAxisLeft().setDrawGridLines(false);
        weeklyStepsBarChart.getXAxis().setDrawGridLines(false);
        weeklyStepsBarChart.setDrawValueAboveBar(false);
        weeklyStepsBarChart.getAxisLeft().setDrawLabels(false);
        weeklyStepsBarChart.getAxisRight().setDrawLabels(false);
        weeklyStepsBarDataSet.setValueTextSize(10f);

        HorizontalBarChart monthlyStepsBarChart = findViewById(R.id.monthlyStepsBarChart);
        getMonthlyData();
        BarDataSet monthlyStepsBarDataSet = new BarDataSet(monthlyStepsBarArray, "Steps per Week");
        BarData monthlyStepsBarData = new BarData(monthlyStepsBarDataSet);
        monthlyStepsBarChart.setData(monthlyStepsBarData);
        monthlyStepsBarChart.getDescription().setEnabled(false);
        monthlyStepsBarDataSet.setColor(Color.RED);
        XAxis xaxis3 = monthlyStepsBarChart.getXAxis();
        xaxis3.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis3.setValueFormatter(new IndexAxisValueFormatter(monthly));
        YAxis yAxis2 = monthlyStepsBarChart.getAxis(YAxis.AxisDependency.LEFT);
        yAxis2.setStartAtZero(true);
        monthlyStepsBarChart.getAxisLeft().setDrawGridLines(false);
        monthlyStepsBarChart.getXAxis().setDrawGridLines(false);
        monthlyStepsBarChart.setDrawValueAboveBar(false);
        monthlyStepsBarChart.getAxisLeft().setDrawLabels(false);
        monthlyStepsBarChart.getAxisRight().setDrawLabels(false);
        monthlyStepsBarDataSet.setValueTextSize(10f);

    }
   private void getDailyData() {
       dailyStepsBarArray = new ArrayList();
       dailyStepsBarArray.add(new BarEntry(0,0));
       dailyStepsBarArray.add(new BarEntry(1, 0));
       dailyStepsBarArray.add(new BarEntry(2, 0));
       dailyStepsBarArray.add(new BarEntry(3, 42));
       dailyStepsBarArray.add(new BarEntry(4, 0));
       dailyStepsBarArray.add(new BarEntry(5, 0));
       dailyStepsBarArray.add(new BarEntry(6, 280));
       dailyStepsBarArray.add(new BarEntry(7, 4322));
       dailyStepsBarArray.add(new BarEntry(8, 419));
       dailyStepsBarArray.add(new BarEntry(9, 32));
       dailyStepsBarArray.add(new BarEntry(10, 80));
       dailyStepsBarArray.add(new BarEntry(11, 24));
       dailyStepsBarArray.add(new BarEntry(12, 120));
       dailyStepsBarArray.add(new BarEntry(13, 20));
       dailyStepsBarArray.add(new BarEntry(14, 22));
       dailyStepsBarArray.add(new BarEntry(15, 77));
       dailyStepsBarArray.add(new BarEntry(16, 15));
       dailyStepsBarArray.add(new BarEntry(17, 300));
       dailyStepsBarArray.add(new BarEntry(18, 150));
       dailyStepsBarArray.add(new BarEntry(19, 100));
       dailyStepsBarArray.add(new BarEntry(20, 120));
       dailyStepsBarArray.add(new BarEntry(21, 73));
       dailyStepsBarArray.add(new BarEntry(22, 85));
       dailyStepsBarArray.add(new BarEntry(23, 42));
    }
    private void getWeeklyData() {
        weeklyStepsBarArray = new ArrayList();
        weeklyStepsBarArray.add(new BarEntry(0, 6070, "Mon"));
        weeklyStepsBarArray.add(new BarEntry(1, 6230, "Tue"));
        weeklyStepsBarArray.add(new BarEntry(2, 5980, "Wed"));
        weeklyStepsBarArray.add(new BarEntry(3, 6340, "Thu"));
        weeklyStepsBarArray.add(new BarEntry(4, 7170, "Fri"));
        weeklyStepsBarArray.add(new BarEntry(5, 7440, "Sat"));
        weeklyStepsBarArray.add(new BarEntry(6, 6340, "Sun"));

    }
    private void getMonthlyData() {
        monthlyStepsBarArray = new ArrayList();
        monthlyStepsBarArray.add(new BarEntry(0, 6156));
        monthlyStepsBarArray.add(new BarEntry(1, 7242));
        monthlyStepsBarArray.add(new BarEntry(2, 6542));
        monthlyStepsBarArray.add(new BarEntry(3, 0));
    }
}