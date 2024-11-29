package com.example.finalproject_test.DATA.InterfaceAPI.LevelApi;

import com.example.finalproject_test.DATA.Models.Level;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ILevelsApi {
    @GET("Levels")
    Call<List<Level>> getLevels();

    @GET("Levels/{id}")
    Call<Level> getLevelById(@Path("id") int id);

    @POST("Levels")
    Call<Level> postLevel(@Body Level level);

    @PUT("Levels/{id}")
    Call<Level> putLevel(@Path("id") int id, @Body Level level);

    @DELETE("Levels/{id}")
    Call<Void> deleteLevel(@Path("id") int id);
}
