package com.example.finalproject_test.DATA.InterfaceAPI.QuestionApi;

import com.example.finalproject_test.DATA.Models.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IQuestionsApi {
    @GET("Questions")
    Call<List<Question>> getQuestions();

    @GET("Questions/{id}")
    Call<Question> getQuestionById(@Path("id") int id);

    @POST("Questions")
    Call<Question> postQuestion(@Body Question question);

    @PUT("Questions/{id}")
    Call<Question> putQuestion(@Path("id") int id, @Body Question question);

    @DELETE("Questions/{id}")
    Call<Void> deleteQuestion(@Path("id") int id);
}
