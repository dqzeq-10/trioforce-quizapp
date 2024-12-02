package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.LevelApi.LevelsApiManager;
import com.example.finalproject_test.DATA.Models.Level;
import com.example.finalproject_test.DATA.Models.Level;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LevelsRepo {
    private static volatile LevelsRepo instance;

    private final LevelsApiManager levelsApiManager;

    private final MutableLiveData<List<Level>> levels = new MutableLiveData<>();
//  private final MutableLiveData<List<Level>> levels = new MutableLiveData<>();
//  ..

    public LevelsRepo(){
        levelsApiManager = LevelsApiManager.getInstance();
    }



    public MutableLiveData<List<Level>> getLevels(){
        levelsApiManager.getLevels(new Callback<List<Level>>() {
            @Override
            public void onResponse(Call<List<Level>> call, Response<List<Level>> response) {
                if(response.isSuccessful() && response.body()!= null){
                    List<Level> body = response.body();
                    levels.setValue(body);
                }else{
                    levels.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Level>> call, Throwable throwable) {
                levels.postValue(null);
                Log.e("levelsViewModel", "API call failed: " + throwable.getMessage());
            }
        });
        return levels;
    }
}
