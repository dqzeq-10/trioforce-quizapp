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
//    public MutableLiveData<Boolean> updateScore(String id, Ranking point){
//        return ranksRepo.updateScore(id, point);
//    }
//public MutableLiveData<Ranking> updateScore(String id, int addedPoints) {
//    MutableLiveData<Ranking> currentRank = ranksRepo.getRankById(id);  // Lấy thông tin ranking hiện tại
//
//    currentRank.observeForever(ranking -> {
//        if (ranking != null) {
//            // Cộng điểm mới vào điểm hiện tại
//            int newScore = ranking.getPoint() + addedPoints;
//            ranking.setPoint(newScore);  // Cập nhật điểm trong đối tượng Ranking
//
//            // Cập nhật lại điểm cho người dùng
//            ranksRepo.putRank(id, ranking);  // Gửi yêu cầu cập nhật điểm lên Repository
//        }
//    });
//
//    return currentRank;
//}
}
