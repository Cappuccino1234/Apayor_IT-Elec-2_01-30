package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        Log.v(TAG, "This is verbose log.");
        Log.d(TAG, "This is debug log.");
        Log.i(TAG, "This is info log.");
        Log.w(TAG, "This is warn log.");
        Log.e(TAG, "This is error log.");

        Button button = (Button) findViewById(R.id.Button2);
        button.setOnClickListener(v -> {
            Log.i(TAG, "Button Clicked");
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
