package com.ams.sampleapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    Button newButton;

    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        newButton = (Button) findViewById(R.id.newButton);
        mLayout = (LinearLayout) findViewById(R.id.info);

        newButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String status = "Delayed message";
                boolean handler = new Handler(Looper.getMainLooper()).postDelayed(
                        new Runnable() {
                            public void run() {
                                Log.i("tag", "This'll run 10 seconds later");

                                mLayout.addView(createNewButton("Test"));
                                Toast.makeText(NewActivity.this,status,Toast.LENGTH_SHORT).show();
                            }
                        },
                        2000);

                Log.i("tag", "Delayed by"+handler);
            }
        });
    }

    private Button createNewButton(String text) {

        Button button = new Button(this);
        button.setText(String.valueOf(text));
        button.setClickable(true);
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return button;
    }
}