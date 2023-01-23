package com.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button heartRatebutton;
    private Button stepsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heartRatebutton = (Button) findViewById(R.id.heartrate);
        heartRatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openheartrate();
            }
        });
        stepsButton = (Button) findViewById(R.id.steps);
        stepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSteps();
            }
        });
    }
    public void openheartrate() {
        Intent intent = new Intent(this, heartrate.class);
        startActivity(intent);
    }
    public void openSteps() {
        Intent intent = new Intent(this, steps.class);
        startActivity(intent);
    }
}