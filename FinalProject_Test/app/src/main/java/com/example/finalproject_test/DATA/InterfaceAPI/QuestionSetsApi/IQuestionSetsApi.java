package com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi;

import com.example.finalproject_test.DATA.Models.QuestionSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IQuestionSetsApi {
    @GET("QuestionSets")
    Call<List<QuestionSet>> getSets();

    @GET("QuestionSets/{id}")
    Call<QuestionSet> getSetById(@Path("id") int id);

    @POST("QuestionSets")
    Call<QuestionSet> postSet(@Body QuestionSet questionSet);

    @PUT("QuestionSets/{id}")
    Call<QuestionSet> putSet(@Path("id") int id, @Body QuestionSet questionSet);

    @DELETE("QuestionSets/{id}")
    Call<Void> deleteSet(@Path("id") int id);
}
