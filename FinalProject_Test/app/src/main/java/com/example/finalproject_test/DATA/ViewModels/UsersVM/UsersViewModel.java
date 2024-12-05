package com.example.finalproject_test.DATA.ViewModels.UsersVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.UsersRepo;

import java.util.List;

public class UsersViewModel extends ViewModel {
    private final UsersRepo usersRepo;
    private  MutableLiveData<List<User>> usersLiveData;
    private MutableLiveData<Void> usersUpdate;

    public UsersViewModel(){
        usersRepo = new UsersRepo();
        usersLiveData = usersRepo.getUsers();
//        usersUpdate = usersRepo.updateUser();
    }

    public MutableLiveData<List<User>> getUsers(){
        return usersLiveData;
    }
    public MutableLiveData<Void> getUsersUpdate(String id, User user){
        usersUpdate = usersRepo.updateUser(id,user);
        return usersUpdate;
    }
}
