package com.freshappbooks.carsdbexample.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.freshappbooks.carsdbexample.model.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class CarsDatabase extends RoomDatabase {
    public abstract CarsDAO getCarDAO();
}
