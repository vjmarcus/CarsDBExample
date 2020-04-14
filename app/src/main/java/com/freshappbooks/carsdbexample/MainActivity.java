package com.freshappbooks.carsdbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.freshappbooks.carsdbexample.data.DatabaseHandler;
import com.freshappbooks.carsdbexample.model.Car;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.addCar(new Car("BMW", "30 000 $"));
        databaseHandler.addCar(new Car("Opel", "10 000 $"));
        databaseHandler.addCar(new Car("Mercedes", "40 000 $"));

        List<Car> carList = databaseHandler.getAllCars();

        for (Car car: carList) {
            Log.d(TAG, "ID " + car.getId() + ", CAR NAME: " + car.getName() + ", CAR PRICE: " + car.getPrice());
        }
    }
}
