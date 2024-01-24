package com.example.vasundhara;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.vasundhara.models.gamesModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MySharedPreferences {
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "App_Details";
    private static final String KEY_ARRAY_LIST = "List_of_AppDetails";

    public MySharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveArrayList(List<gamesModel.DataItem> list) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(KEY_ARRAY_LIST, json);
        editor.apply();
    }

    public List<gamesModel> getArrayList() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_ARRAY_LIST, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
