package com.freshappbooks.carsdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.freshappbooks.adapter.CarsAdapter;
import com.freshappbooks.carsdbexample.data.DatabaseHandler;
import com.freshappbooks.carsdbexample.model.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";
    RecyclerView recyclerViewCars;
    private List<Car> listOfCars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        recyclerViewCars = findViewById(R.id.recyclerView_cars);
        listOfCars = databaseHandler.getAllCars();
        CarsAdapter adapter = new CarsAdapter(listOfCars);
        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars.setAdapter(adapter);
    }
}
