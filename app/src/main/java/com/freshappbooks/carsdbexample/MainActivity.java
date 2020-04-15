package com.freshappbooks.carsdbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.freshappbooks.carsdbexample.data.DatabaseHandler;
import com.freshappbooks.carsdbexample.model.Car;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        int count = databaseHandler.getCarsCount();
        Log.d(TAG, "onCreate: " + count);
    }
}
