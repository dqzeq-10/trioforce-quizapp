package com.example.finalproject_test.DATA.InterfaceAPI.LoginApi;

import com.example.finalproject_test.DATA.Models.LoginRequest;
import com.example.finalproject_test.DATA.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginRequestApi {
    @POST("Auth/Login")
    Call<User> postLogin(@Body LoginRequest loginRequest);
}
