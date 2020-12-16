package com.example.carsmobile.retrofit;

public class Api {
    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static CarService getCarService(){
        return RetrofitClient.getClient(BASE_URL).create(CarService.class);
    }
}
