package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.LoginApi.LoginApiManager;
import com.example.finalproject_test.DATA.Models.LoginRequest;
import com.example.finalproject_test.DATA.Models.User;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {
    private static volatile LoginRepo instance;
    private final LoginApiManager loginApiManager;

    private final MutableLiveData<User> loggedInUser = new MutableLiveData<>();


    public LoginRepo() {
        loginApiManager = LoginApiManager.getInstance();
    }

    public MutableLiveData<User> postLogin(String username, String password) {
        loginApiManager.postLogin(username, password, new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null){
                    loggedInUser.setValue(response.body());
                }else {
                    loggedInUser.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                loggedInUser.setValue(null);
                Log.e("LoginRepo", "API CALL failed: "+throwable.getMessage());
            }
        });

    return loggedInUser;
    }
}

