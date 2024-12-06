package com.example.finalproject_test.DATA.InterfaceAPI.CreatedQuestionApi;

import com.example.finalproject_test.DATA.Models.CreatedQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ICreatedQuestionApi {
    @GET("CreatedQuestions")
    Call<List<CreatedQuestion>> getCreatedQuestions();

    @GET("CreatedQuestions/{username}")
    Call<List<CreatedQuestion>> getCreateQuestionByUsername(@Path("username") String username);

    @GET("CreatedQuestions/{username}/{idQuestion}")
    Call<CreatedQuestion> getCreatedQuestionByUsernameAndIdQuestion (@Path("username") String username, @Path("idQuestion") int idQuestion);

    @POST("CreatedQuestions")
    Call<CreatedQuestion> postCreatedQuestion (@Body CreatedQuestion createdQuestion);

    @PUT("CreatedQuestions/{username}/{idQuestion}")
    Call<CreatedQuestion> putCreatedQuestion (@Path("username") String username, @Path("idQuestion") int idQuestion,@Body CreatedQuestion createdQuestion);

    @DELETE("CreatedQuestions/{username}/{idQuestion}")
    Call<Void> deleteCreatedQuestion (@Path("username") String username, @Path("idQuestion") int idQuestion);
}