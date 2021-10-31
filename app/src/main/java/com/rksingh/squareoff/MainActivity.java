package com.rksingh.squareoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.rksingh.squareoff.Adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    List<Model> dataList;
    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        dataList = new ArrayList<>();


        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        Call<JsonResponse> call = apiInterface.getJsonData();

      call.enqueue(new Callback<JsonResponse>() {
          @Override
          public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
              JsonResponse jsonResponse = response.body();

              dataList = new ArrayList<>(Arrays.asList(jsonResponse.getDataArray()));
              customAdapter = new CustomAdapter(dataList,MainActivity.this);
              recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
              recyclerView.setAdapter(customAdapter);

          }

          @Override
          public void onFailure(Call<JsonResponse> call, Throwable t) {

              Toast.makeText(MainActivity.this, "Something want wrong....", Toast.LENGTH_SHORT).show();
          }
      });


    }
}