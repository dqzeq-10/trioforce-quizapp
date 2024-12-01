package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi.QuestionSetsApiManager;
import com.example.finalproject_test.DATA.Models.QuestionSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionSetsRepo {
    private static volatile QuestionSetsRepo getInstance;

    private final QuestionSetsApiManager questionSetsApiManager;

    private final MutableLiveData<List<QuestionSet>> sets = new MutableLiveData<>();
    private final MutableLiveData<QuestionSet> set = new MutableLiveData<>();
    private final MutableLiveData<QuestionSet> setreceive = new MutableLiveData<>();
    private final MutableLiveData<Boolean> operationSuccess = new MutableLiveData<>();

    public QuestionSetsRepo(){
        questionSetsApiManager = QuestionSetsApiManager.getInstance();
    }

    public MutableLiveData<List<QuestionSet>> getSets(){
        questionSetsApiManager.getSets(new Callback<List<QuestionSet>>() {
            @Override
            public void onResponse(Call<List<QuestionSet>> call, Response<List<QuestionSet>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    List<QuestionSet> body = response.body();
                    sets.setValue(body);
                }else {
                    sets.postValue(null);
                }

            }

            @Override
            public void onFailure(Call<List<QuestionSet>> call, Throwable throwable) {
                sets.postValue(null);
                Log.e("SetRepo", "failed to getSets: "+throwable.getMessage() );
            }
        });
        return sets;
    }

    public MutableLiveData<QuestionSet> getSetById(int id){
        questionSetsApiManager.getSetById(id, new Callback<QuestionSet>() {
            @Override
            public void onResponse(Call<QuestionSet> call, Response<QuestionSet> response) {
                if (response.isSuccessful() && response.body()!=null){
                    QuestionSet body = response.body();
                    set.setValue(body);
                }else {
                    set.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<QuestionSet> call, Throwable throwable) {
                    set.postValue(null);
                Log.e("SetRepo", "failed to getSet: "+throwable.getMessage() );
            }
        });
        return set;
    }

    public MutableLiveData<QuestionSet> getSetByIdLevelAndIdCate(int idLevel, int idCategory){
        questionSetsApiManager.getSetByIdLevelAndIdCate(idLevel, idCategory, new Callback<QuestionSet>() {
            @Override
            public void onResponse(Call<QuestionSet> call, Response<QuestionSet> response) {
                if (response.isSuccessful() && response.body() != null){
                    Log.d("APIResponse", "Data received: " + response.body().toString());
                    QuestionSet body = response.body();
                    setreceive.setValue(body);
                }else {
                    Log.d("APIResponse", "No data or response failed. Code: " + response.code());
                    setreceive.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<QuestionSet> call, Throwable throwable) {
                setreceive.postValue(null);
                Log.e("APIResponse", "Error: " + throwable.getMessage());
                Log.e("SetRepo", "failed to getSetByIdLevelAndIdCate: "+throwable.getMessage() );
            }
        });
        return setreceive;
    }

    public MutableLiveData<Boolean> postSet(QuestionSet questionSet){
        questionSetsApiManager.postSet(questionSet, new Callback<QuestionSet>() {
            @Override
            public void onResponse(Call<QuestionSet> call, Response<QuestionSet> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<QuestionSet> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("SetRepo", "failed to postSet: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> putSet(int id, QuestionSet questionSet){
        questionSetsApiManager.putSet(id, questionSet, new Callback<QuestionSet>() {
            @Override
            public void onResponse(Call<QuestionSet> call, Response<QuestionSet> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<QuestionSet> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("SetRepo", "failed to putSet: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> deleteSet(int id){
        questionSetsApiManager.deleteSet(id, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("SetRepo", "failed to deleteSet: "+throwable.getMessage() );
            }
        });
        return  operationSuccess;
    }

}

