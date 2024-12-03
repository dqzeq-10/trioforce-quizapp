package com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi;
import com.example.finalproject_test.DATA.Models.ProgressQuestion;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface IProgressQuestionsAPi {
    @GET("ProgressQuestions")
    Call<List<ProgressQuestion>> getProgress();

    @GET("ProgressQuestions/{id}")
    Call<ProgressQuestion> getProgressById(@Path("id") int id);

    @POST("ProgressQuestions")
    Call<ProgressQuestion> postProgress(@Body ProgressQuestion progressQuestion);

    @PUT("ProgressQuestions/{id}")
    Call<ProgressQuestion> putProgress(@Path("id") int id, @Body ProgressQuestion progressQuestion);

    @DELETE("ProgressQuestions/{id}")
    Call<Void> deleteProgress(@Path("id") int id);
}
