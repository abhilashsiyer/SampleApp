package com.ams.sampleapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton simpleToggleButton2 ;
    ToggleButton simpleToggleButton1 ;

    Button submit;

    Button addTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleToggleButton2 = (ToggleButton) findViewById(R.id.simpleToggleButton2);
        simpleToggleButton1 = (ToggleButton) findViewById(R.id.simpleToggleButton1);


        submit = (Button) findViewById(R.id.submitButton);

        addTrip = (Button) findViewById(R.id.addTrip);

        addTrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
    }
}