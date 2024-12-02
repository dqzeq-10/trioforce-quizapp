package com.example.finalproject_test.DATA.ViewModels.LevelsVM;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.Level;
import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.LevelsRepo;

import java.util.List;
public class LevelsViewModel extends ViewModel {
    private final LevelsRepo levelsRepo;
    private MutableLiveData<List<Level>> levelsLiveData;

    public LevelsViewModel(){
        levelsRepo = new LevelsRepo();
        levelsLiveData = levelsRepo.getLevels();
    }

    public MutableLiveData<List<Level>> getLevels(){
        return levelsLiveData;
    }
}
