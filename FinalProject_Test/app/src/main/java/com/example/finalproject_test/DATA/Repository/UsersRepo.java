package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.UsersApiManager;
import com.example.finalproject_test.DATA.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepo {
    private static volatile UsersRepo instance;

    private final UsersApiManager usersApiManager;

    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
//  private final MutableLiveData<List<User>> users = new MutableLiveData<>();
//  ..

    public UsersRepo(){
        usersApiManager = UsersApiManager.getInstance();
    }



    public MutableLiveData<List<User>> getUsers(){
        usersApiManager.getUsers(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful() && response.body()!= null){
                    List<User> body = response.body();
                    users.setValue(body);
                }else{
                    users.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                    users.postValue(null);
                Log.e("UsersViewModel", "API call failed: " + throwable.getMessage());
            }
        });
        return users;
    }
    // Tương tự nha ae thêm các method nhận và lưu giữ dữ liệu
//    public MutableLiveData<List<'entityName'>> getSomethings ...



}
