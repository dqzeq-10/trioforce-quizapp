package com.example.finalproject_test.DATA.InterfaceAPI.AnswersApi;

import com.example.finalproject_test.DATA.Models.Answer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IAnswersApi {
    @GET("Answers")
    Call<List<Answer>> getAnswers();

    @GET("Answers/{id}")
    Call<Answer> getAnswerById(@Path("id") int id);

    @POST("Answers")
    Call<Answer> postAnswer(@Body Answer answer);

    @PUT("Answers/{id}")
    Call<Answer> putAnswer(@Path("id") int id, @Body Answer answer);

    @DELETE("Answers/{id}")
    Call<Void> deleteAnswer(@Path("id") int id);
}