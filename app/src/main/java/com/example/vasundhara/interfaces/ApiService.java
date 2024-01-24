package com.example.vasundhara.interfaces;

import com.example.vasundhara.models.gamesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("17/com.hd.camera. apps.high.quality")
    Call<gamesModel> getData();
}
