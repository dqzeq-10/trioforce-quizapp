package com.example.finalproject_test.DATA.ViewModels.SharedVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.Ranking;

import java.util.List;

public class PointUpdateSharedViewModel extends ViewModel {
    MutableLiveData<List<Ranking>> leaderboardLiveData = new MutableLiveData<>();

    public LiveData<List<Ranking>> getLeaderboardLiveData() {
        return leaderboardLiveData;
    }
}
