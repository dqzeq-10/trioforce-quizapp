package com.example.finalproject_test.DATA.ViewModels.UsersVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.UsersRepo;

import java.util.List;

public class UsersViewModel extends ViewModel {
    private final UsersRepo usersRepo;
    private  MutableLiveData<List<User>> usersLiveData;

    public UsersViewModel(){
        usersRepo = new UsersRepo();
        usersLiveData = usersRepo.getUsers();
    }

    public MutableLiveData<List<User>> getUsers(){
        return usersLiveData;
    }
}
