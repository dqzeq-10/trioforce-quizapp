package com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi;
import com.example.finalproject_test.DATA.Models.MarkedQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IMarkedQuestionApi {
    @GET("MarkedQuestions")
    Call<List<MarkedQuestion>> getMarkedQuestions();

    @GET("MarkedQuestions/{id}")
    Call<MarkedQuestion> getMarkedQuestionById(@Path("id") int id);

    @POST("MarkedQuestions")
    Call<MarkedQuestion> postMarkedQuestion(@Body MarkedQuestion markedQuestion);

    @PUT("MarkedQuestions/{id}")
    Call<MarkedQuestion> putMarkedQuestion(@Path("id") int id, @Body MarkedQuestion markedQuestion);

    @DELETE("MarkedQuestions/{id}")
    Call<Void> deleteMarkedQuestion(@Path("id") int id);
}
