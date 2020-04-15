package com.freshappbooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshappbooks.carsdbexample.R;
import com.freshappbooks.carsdbexample.model.Car;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private List<Car> listOfCars;

    public CarsAdapter(List<Car> listOfCars) {
        this.listOfCars = listOfCars;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        Car car = listOfCars.get(position);
        holder.textViewName.setText(car.getName());
        holder.textViewPrice.setText(car.getPrice());
    }

    @Override
    public int getItemCount() {
        return listOfCars.size();
    }

    class CarsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewPrice;
        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewPrice = itemView.findViewById(R.id.textView_price);
        }
    }
}
