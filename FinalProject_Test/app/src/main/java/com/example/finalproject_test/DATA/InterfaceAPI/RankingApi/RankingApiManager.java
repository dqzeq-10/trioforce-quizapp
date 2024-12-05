package com.example.finalproject_test.DATA.InterfaceAPI.RankingApi;


import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.Ranking;
import com.example.finalproject_test.DATA.Models.Ranking;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RankingApiManager {
    private static IRankingApi iRankingApi;
    private static RankingApiManager rankingApiManager;

    private RankingApiManager(){
        iRankingApi = RetrofitService.createInstanceRank();
    }
    public static RankingApiManager getInstance(){
        if (rankingApiManager == null){
            rankingApiManager = new RankingApiManager();
        }
        return rankingApiManager;
    }

    public void getRanks (Callback<List<Ranking>> callback){
        Call<List<Ranking>> rankCall = iRankingApi.getRanks();
        rankCall.enqueue(callback);
    }
    
    public void  getRankById(String id, Callback<Ranking> callback){
        Call<Ranking> rankingCall = iRankingApi.getRankById(id);
        rankingCall.enqueue(callback);
    }

    public void postRank(Ranking ranking, Callback<Ranking> callback){
        Call<Ranking> call = iRankingApi.postRank(ranking);
        call.enqueue(callback);
    }

    public void putRank(String id, Ranking ranking, Callback<Ranking> callback){
        Call<Ranking> call = iRankingApi.putRank(id, ranking);
        call.enqueue(callback);
    }

    public void deleteRank(String id, Callback<Void> callback){
        Call<Void> call = iRankingApi.deleteRank(id);
        call.enqueue(callback);
    }

    public void updateScore(String id, Ranking point, Callback<Ranking> callback){
        Call<Ranking> call = iRankingApi.updateScore(id, point);
        call.enqueue(callback);
    }
}
