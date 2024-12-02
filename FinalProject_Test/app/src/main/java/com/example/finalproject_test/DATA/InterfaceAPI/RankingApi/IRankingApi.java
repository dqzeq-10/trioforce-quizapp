package com.example.finalproject_test.DATA.InterfaceAPI.RankingApi;

import com.example.finalproject_test.DATA.Models.Ranking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IRankingApi {
    @GET("Rankings")
    Call<List<Ranking>> getRanks();

    @GET("Rankings/{id}")
    Call<Ranking> getRankById(@Path("id") String id);

    @POST("Rankings")
    Call<Ranking> postRank(@Body Ranking ranking);

    @PUT("Rankings/{id}")
    Call<Ranking> putRank(@Path("id") String id, @Body Ranking ranking);

    @DELETE("Rankings/{id}")
    Call<Void> deleteRank(@Path("id") String id);
}
