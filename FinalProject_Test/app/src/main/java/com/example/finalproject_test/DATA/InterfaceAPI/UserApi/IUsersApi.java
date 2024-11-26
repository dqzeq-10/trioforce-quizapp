package com.example.finalproject_test.DATA.InterfaceAPI.UserApi;

import com.example.finalproject_test.DATA.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUsersApi {
    // http://localhost:5019/api/Users
    @GET("Users")
    Call<List<User>> getUsers();

    @GET("Users/{id}")
    Call<User> getUserById(@Path("id") String id);


}
