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
public interface IProgressQuestionsApi {
    @GET("ProgressQuestions")
    Call<List<ProgressQuestion>> getProgress();

    @GET("ProgressQuestions/{username}")
    Call<List<ProgressQuestion>> getProgressByUsername(@Path("username") String username);

    @GET("ProgressQuestions/{username}/{idSet}")
    Call<ProgressQuestion> getProgressByUsernameAndIdSet(@Path("username") String username, @Path("idSet") int idSet);

    @POST("ProgressQuestions")
    Call<ProgressQuestion> postProgress(@Body ProgressQuestion progressQuestion);

    @PUT("ProgressQuestions/{username}/{idSet}")
    Call<ProgressQuestion> putProgress(@Path("username") String username, @Path("idSet") int idSet, @Body ProgressQuestion progressQuestion);

    @DELETE("ProgressQuestions/{username}/{idSet}")
    Call<Void> deleteProgress(@Path("username") String username, @Path("idSet") int idSet);
}
