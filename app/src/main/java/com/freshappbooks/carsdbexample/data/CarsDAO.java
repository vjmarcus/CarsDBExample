package com.freshappbooks.carsdbexample.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.freshappbooks.carsdbexample.model.Car;

import java.util.List;

@Dao
public interface CarsDAO {

    @Insert
    public long addCar(Car car);

    @Update
    public void updateCar(Car car);

    @Delete
    public void deleteCar(Car car);

    @Query("select * from cars")
    public List<Car> getAllCars();

    @Query("select * from cars where id ==:carId ")
    public Car getCar(long carId);
}
