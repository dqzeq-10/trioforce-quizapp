package com.example.finalproject_test.DATA.ViewModels.RanksVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.Ranking;
import com.example.finalproject_test.DATA.Repository.RanksRepo;

import java.util.List;

public class RanksViewModel extends ViewModel {
    private final RanksRepo ranksRepo;

    public RanksViewModel(){
        ranksRepo = new RanksRepo();

    }

    public MutableLiveData<List<Ranking>> getRanks(){
        return ranksRepo.getRanks();
    }

    public MutableLiveData<Ranking> getRankById(String id){
        return ranksRepo.getRankById(id);
    }

    public MutableLiveData<Boolean> postRank(Ranking ranking){
        return ranksRepo.postRank(ranking);
    }

    public MutableLiveData<Boolean> putRank(String id, Ranking ranking){
        return ranksRepo.putRank(id, ranking);
    }

    public MutableLiveData<Boolean> deleteRank(String id){
        return ranksRepo.deleteRank(id);
    }
}
