package com.example.carsmobile.retrofit;

import com.example.carsmobile.model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarService {

    @GET("/cars/all")
    Call<List<Car>> getCars();
}
