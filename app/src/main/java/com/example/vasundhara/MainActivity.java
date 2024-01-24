package com.example.vasundhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vasundhara.adapters.gamesAdapter;
import com.example.vasundhara.interfaces.ApiService;
import com.example.vasundhara.models.gamesModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<gamesModel.DataItem> dataList = new ArrayList<>();
    Button task2;
    private gamesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        task2 = findViewById(R.id.tasktwo);
        fetchData();



        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,blinkmain.class);
                startActivity(intent);
            }
        });
        MySharedPreferences mySharedPreferences = new MySharedPreferences(getApplicationContext());

        mySharedPreferences.saveArrayList(dataList);
// Retrieving ArrayList from SharedPreferences
        List<gamesModel> retrievedList = mySharedPreferences.getArrayList();
      /*  gamesModel game1 = new gamesModel("Game 1", "1", "https://play-lh.googleusercontent.com/V5e8nwFZhJlC7hjl98i2bZji5MUaoEn6vpLtu3hZqT4wl_D-ija-8BACSWrM3pJbPg=s360");
        gamesModel game2 = new gamesModel("Game 2", "1", "https://play-lh.googleusercontent.com/V5e8nwFZhJlC7hjl98i2bZji5MUaoEn6vpLtu3hZqT4wl_D-ija-8BACSWrM3pJbPg=s360");
        gamesModel game3 = new gamesModel("Game 3", "1", "https://play-lh.googleusercontent.com/V5e8nwFZhJlC7hjl98i2bZji5MUaoEn6vpLtu3hZqT4wl_D-ija-8BACSWrM3pJbPg=s360");

        // Add the instances to the dataList
        dataList.add(game1);
        dataList.add(game2);
        dataList.add(game3);*/

        Log.d("datalist", "datalist: " + dataList);

    }

    public void fetchData() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

// Make the API call
        Call<gamesModel> call = apiService.getData();
        call.enqueue(new Callback<gamesModel>() {
            @Override
            public void onResponse(@NonNull Call<gamesModel> call, @NonNull Response<gamesModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    gamesModel responseData = response.body();

                    // Access the data
                    List<gamesModel.DataItem> dataList = responseData.getData();
                    for (gamesModel.DataItem dataItem : dataList) {
                        String name = dataItem.getName();
                        String thumbImage = dataItem.getThumbImage();
                        String appLink = dataItem.getAppLink();

                        // Use the retrieved data as needed
                    }
                    adapter = new gamesAdapter(dataList,getApplicationContext()); // Your RecyclerView Adapter

                    // Set a layout manager to your RecyclerView
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);

                    recyclerView.setAdapter(adapter);

                } else {
                    // Handle unsuccessful response
                    Log.d("failed","failed");
                }
            }
            @Override
            public void onFailure(@NonNull Call<gamesModel> call, @NonNull Throwable t) {
                // Handle failure
                Log.d("failed","failed"+t);
            }
        });
    }
}