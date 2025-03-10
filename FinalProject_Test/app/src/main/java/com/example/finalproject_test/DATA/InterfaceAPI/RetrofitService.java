package com.example.finalproject_test.DATA.InterfaceAPI;

import com.example.finalproject_test.DATA.InterfaceAPI.AnswersApi.IAnswersApi;
import com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi.IQuestionCategoriesApi;
import com.example.finalproject_test.DATA.InterfaceAPI.CreatedQuestionApi.ICreatedQuestionApi;
import com.example.finalproject_test.DATA.InterfaceAPI.LevelApi.ILevelsApi;
import com.example.finalproject_test.DATA.InterfaceAPI.LoginApi.ILoginRequestApi;
import com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi.IMarkedQuestionApi;
import com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi.IProgressQuestionsApi;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionApi.IQuestionsApi;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi.IQuestionSetsApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RankingApi.IRankingApi;
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


    public static ILoginRequestApi createInstanceLogin() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ILoginRequestApi.class);
    }

    public static IQuestionSetsApi createInstanceSet() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuestionSetsApi.class);
    }

    public static ILevelsApi createInstanceLevel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ILevelsApi.class);
    }

    public static IQuestionCategoriesApi createInstanceCate() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuestionCategoriesApi.class);
    }

    public static IQuestionsApi createInstanceQ() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuestionsApi.class);
    }

    public static IAnswersApi createInstanceAns() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IAnswersApi.class);
    }

    public static ICreatedQuestionApi createInstanceCQ() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ICreatedQuestionApi.class);
    }

    public static IMarkedQuestionApi createInstanceMQ() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IMarkedQuestionApi.class);
    }

    public static IProgressQuestionsApi createInstancePQ() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IProgressQuestionsApi.class);
    }


    public static IRankingApi createInstanceRank() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IRankingApi.class);
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
