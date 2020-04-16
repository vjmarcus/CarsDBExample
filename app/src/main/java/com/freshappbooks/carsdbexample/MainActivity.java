package com.freshappbooks.carsdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.freshappbooks.adapter.CarsAdapter;
import com.freshappbooks.carsdbexample.data.CarsDatabase;
import com.freshappbooks.carsdbexample.data.DatabaseHandler;
import com.freshappbooks.carsdbexample.model.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";
    private RecyclerView recyclerViewCars;
    private List<Car> listOfCars = new ArrayList<>();
    private CarsDatabase database;
    private CarsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DatabaseHandler databaseHandler = new DatabaseHandler(this);
//        listOfCars = databaseHandler.getAllCars();
        database = Room.databaseBuilder(getApplicationContext(), CarsDatabase.class, "carsDB")
                .allowMainThreadQueries()
                .build();
        adapter = new CarsAdapter(listOfCars);
        new GetAllCarsAsyncTask().execute();
        listOfCars = database.getCarDAO().getAllCars();
        Log.d(TAG, "onCreate: " + listOfCars.size());
        recyclerViewCars = findViewById(R.id.recyclerView_cars);
        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars.setAdapter(adapter);
    }

    private class GetAllCarsAsyncTask extends AsyncTask <Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            listOfCars.addAll(database.getCarDAO().getAllCars());
            Log.d(TAG, "doInBackground: ");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
            Log.d(TAG, "onPostExecute: ");
        }
    }
    private class CreateCarAsyncTask extends AsyncTask<Car,Void, Void> {
        @Override
        protected Void doInBackground(Car... cars) {
            return null;
        }
    }

}
