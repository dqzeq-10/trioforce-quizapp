package com.example.finalproject_test.DATA.ViewModels.UsersVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.UsersRepo;

import java.util.List;

public class UsersViewModel extends ViewModel {
    private final UsersRepo usersRepo;

    public UsersViewModel(UsersRepo usersRepo){
        this.usersRepo = usersRepo;
    }

    public MutableLiveData<List<User>> getUsers(){
        return usersRepo.getUsers();
    }
}
