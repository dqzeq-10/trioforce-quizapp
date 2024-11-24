package com.example.finalproject_test.DATA.ViewModels.UsersVM;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject_test.DATA.InterfaceAPI.MainApplication;
import com.example.finalproject_test.DATA.Repository.UsersRepo;

public class UsersViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UsersViewModel.class)) {
            return (T) new UsersViewModel(UsersRepo.getInstance(MainApplication.usersApiManager));
        } else {
            throw new IllegalArgumentException("Unknow ViewModel class");
        }
    }
}
