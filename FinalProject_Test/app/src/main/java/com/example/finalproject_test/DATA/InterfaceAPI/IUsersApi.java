package com.example.finalproject_test.DATA.InterfaceAPI;

import com.example.finalproject_test.DATA.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUsersApi {
    //https://localhost:7210/api/QuestionCategories
    @GET("Users")
    Call<List<User>> getUsers();

    @GET("Users/{id}")
    Call<List<User>> getUserById(@Path("id") String id);


}
