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

    public void putUsers(String id, User user, Callback<Void> callback) {
        // Gọi API updateUser với id và user
        Call<Void> usersCall = iUsersApi.updateUser(id, user);
        usersCall.enqueue(callback); // Thực hiện API call với callback
    }
// Tạo thêm method lấy gì đó, câu hỏi, thể loại,... nhưng mà ở class khác chứ user này còn gì đâu mà lấy nữa
//    public void getSomethings (Callback<List<'entityName'>> callback){
//        Call<List<'entityName'>> 'entityName'Call = i'entityName'Api.get'entityName'();
//        'entityName'Call.enqueue(callback);
//    }


}
