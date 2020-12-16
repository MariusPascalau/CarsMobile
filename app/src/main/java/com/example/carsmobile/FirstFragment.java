package com.example.carsmobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.carsmobile.model.Car;
import com.example.carsmobile.retrofit.Api;
import com.example.carsmobile.retrofit.CarService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {
    CarService carService;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String[] textFromDB = {"some text"};
        carService = Api.getCarService();
        final TextView myAwesomeTextView = view.findViewById(R.id.textview_first);
        myAwesomeTextView.setText(textFromDB[0]);

        Call<List<Car>> carsCall = carService.getCars();
        carsCall.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                myAwesomeTextView.setText(response.body().get(0).toString());
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                System.out.println("on failure");
            }
        });
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}