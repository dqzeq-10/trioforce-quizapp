package com.example.finalproject_test.DATA.InterfaceAPI.UserApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class UsersApiManager {
    private static IUsersApi iUsersApi;
    private static UsersApiManager usersApiManager;

    private UsersApiManager(){
        iUsersApi = RetrofitService.CreateInstanceU();
    }

    public static UsersApiManager getInstance(){
        if (usersApiManager == null){
            usersApiManager = new UsersApiManager();
        }
        return usersApiManager;
    }

    public void getUsers (Callback<List<User>> callback){
        Call<List<User>> usersCall = iUsersApi.getUsers();
        usersCall.enqueue(callback);
    }

    public void postUser(User user, Callback<User> callback){
        Call<User> call = iUsersApi.postUser(user);
        call.enqueue(callback);
    }

    public void putUser(String id, User user, Callback<User> callback){
        Call<User> call = iUsersApi.putUser(id, user);
        call.enqueue(callback);
    }


// Tạo thêm method lấy gì đó, câu hỏi, thể loại,... nhưng mà ở class khác chứ user này còn gì đâu mà lấy nữa
//    public void getSomethings (Callback<List<'entityName'>> callback){
//        Call<List<'entityName'>> 'entityName'Call = i'entityName'Api.get'entityName'();
//        'entityName'Call.enqueue(callback);
//    }


}
