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

    @GET("MarkedQuestions/{username}")
    Call<List<MarkedQuestion>> getMarkedQuestionByUsername(@Path("username") String username);

    @GET("MarkedQuestions/{username}/{idQuestion}")
    Call<MarkedQuestion> getMarkedQuestionByUsernameAndIdQuestion(@Path("username") String username, @Path("idQuestion") int idQuestion);

    @POST("MarkedQuestions")
    Call<MarkedQuestion> postMarkedQuestion(@Body MarkedQuestion markedQuestion);

    @PUT("MarkedQuestions/{username}/{idQuestion}")
    Call<MarkedQuestion> putMarkedQuestion(@Path("username") String username, @Path("idQuestion") int idQuestion, @Body MarkedQuestion markedQuestion);

    @DELETE("MarkedQuestions/{username}/{idQuestion}")
    Call<Void> deleteMarkedQuestion(@Path("username") String username, @Path("idQuestion") int idQuestion);
}
