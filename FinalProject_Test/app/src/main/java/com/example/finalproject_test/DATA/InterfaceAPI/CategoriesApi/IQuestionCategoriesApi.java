package com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi;

import com.example.finalproject_test.DATA.Models.QuestionCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IQuestionCategoriesApi {
    @GET("QuestionCategories")
    Call<List<QuestionCategory>> getCategories();

    @GET("QuestionCategories/{id}")
    Call<QuestionCategory> getCategoryById(@Path("id") int id);

    @POST("QuestionCategories")
    Call<QuestionCategory> postCategory(@Body QuestionCategory questionCategory);

    @PUT("QuestionCategories/{id}")
    Call<QuestionCategory> putCategory(@Path("id") int id, @Body QuestionCategory questionCategory);

    @DELETE("QuestionCategories/{id}")
    Call<Void> deleteCategory(@Path("id") int id);
}
