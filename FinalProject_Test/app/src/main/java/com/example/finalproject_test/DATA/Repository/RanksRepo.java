package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.RankingApi.RankingApiManager;
import com.example.finalproject_test.DATA.Models.Ranking;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RanksRepo {
    private static volatile RanksRepo getInstance;

    private final RankingApiManager rankingApiManager;

    private final MutableLiveData<List<Ranking>> ranks = new MutableLiveData<>();
    private final MutableLiveData<Ranking> rank = new MutableLiveData<>();
    private final MutableLiveData<Boolean> operationSuccess = new MutableLiveData<>();

    public RanksRepo(){
        rankingApiManager = RankingApiManager.getInstance();
    }

    public MutableLiveData<List<Ranking>> getRanks(){
        rankingApiManager.getRanks(new Callback<List<Ranking>>() {
            @Override
            public void onResponse(Call<List<Ranking>> call, Response<List<Ranking>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    List<Ranking> body = response.body();
                    ranks.setValue(body);
                }else {
                    ranks.postValue(null);
                }

            }

            @Override
            public void onFailure(Call<List<Ranking>> call, Throwable throwable) {
                ranks.postValue(null);
                Log.e("RankRepo", "failed to getRanks: "+throwable.getMessage() );
            }
        });
        return ranks;
    }

    public MutableLiveData<Ranking> getRankById(String id){
        rankingApiManager.getRankById(id, new Callback<Ranking>() {
            @Override
            public void onResponse(Call<Ranking> call, Response<Ranking> response) {
                if (response.isSuccessful() && response.body()!=null){
                    Ranking body = response.body();
                    rank.setValue(body);
                }else {
                    rank.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Ranking> call, Throwable throwable) {
                rank.postValue(null);
                Log.e("RankRepo", "failed to getRank: "+throwable.getMessage() );
            }
        });
        return rank;
    }

    

    public MutableLiveData<Boolean> postRank(Ranking ranking){
        rankingApiManager.postRank(ranking, new Callback<Ranking>() {
            @Override
            public void onResponse(Call<Ranking> call, Response<Ranking> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Ranking> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("RankRepo", "failed to postRank: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> putRank(String id, Ranking ranking){
        rankingApiManager.putRank(id, ranking, new Callback<Ranking>() {
            @Override
            public void onResponse(Call<Ranking> call, Response<Ranking> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Ranking> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("RankRepo", "failed to putRank: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> deleteRank(String id){
        rankingApiManager.deleteRank(id, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("RankRepo", "failed to deleteRank: "+throwable.getMessage() );
            }
        });
        return  operationSuccess;
    }

}

