package com.example.finalproject_test.DATA.ViewModels.LoginVM;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.LoginRepo;
import com.example.finalproject_test.DATA.Repository.UsersRepo;

import java.util.List;

public class LoginViewModel extends ViewModel {
    private final LoginRepo loginRepo;
    private final MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public LoginViewModel(){
        loginRepo = new LoginRepo();
    }
    public LiveData<User> loginInVM(String username, String password){
        return loginRepo.postLogin(username,password);

    }

    public MutableLiveData<User> getLoggedInUser(){
        return userMutableLiveData;
    }
}
