package com.example.finalproject_test.DATA.ViewModels.SharedVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.User;

public class SharedViewModel<T> extends ViewModel {
    private final MutableLiveData<T> objectMLD = new MutableLiveData<>();
    public LiveData<T> getObjectMLD(){
        return  objectMLD;
    }
    public void setObjectMLD(T object){
        objectMLD.setValue(object);
    }
    public void clearObjectMLD(){
        objectMLD.setValue(null);
    }
}
