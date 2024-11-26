package com.example.finalproject_test.DATA.InterfaceAPI;

import com.example.finalproject_test.DATA.InterfaceAPI.LoginApi.ILoginRequestApi;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.IUsersApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "http://10.0.2.2:5019/api/";
    private static Retrofit retrofit;

    public static IUsersApi CreateInstanceU() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IUsersApi.class);
    }


    public static ILoginRequestApi createInstanceLogin(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ILoginRequestApi.class);
    }

//   Tạo thêm method tạo instance cho mỗi entity ở đây
//
//    public static IQuestionsApi Create() {
//        return retrofit.create(IUsersApi.class);
//    }
//
//    public static ICategoriesApi Create() {
//        return retrofit.create(IUsersApi.class);
//    }
// ....

}
