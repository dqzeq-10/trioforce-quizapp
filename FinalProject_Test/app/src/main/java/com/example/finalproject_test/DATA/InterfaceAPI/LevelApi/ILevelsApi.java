package com.example.finalproject_test.DATA.InterfaceAPI.LevelApi;

import com.example.finalproject_test.DATA.Models.Level;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ILevelsApi {
    @GET("Levels")
    Call<List<Level>> getLevels();

    @GET("Levels/{id}")
    Call<Level> getLevelById(@Path("id") int id);
}
