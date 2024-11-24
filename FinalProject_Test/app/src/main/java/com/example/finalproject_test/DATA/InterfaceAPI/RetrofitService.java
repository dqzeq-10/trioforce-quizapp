package com.example.finalproject_test.DATA.InterfaceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "http://10.0.2.2:5019/api/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static IUsersApi Create() {
        return retrofit.create(IUsersApi.class);
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
