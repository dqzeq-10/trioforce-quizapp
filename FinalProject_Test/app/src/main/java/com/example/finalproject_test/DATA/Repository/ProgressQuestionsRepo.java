package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi.ProgressQuestionsApiManager;
import com.example.finalproject_test.DATA.Models.ProgressQuestion;
import com.example.finalproject_test.DATA.Models.QuestionSet;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgressQuestionsRepo {
    private static volatile ProgressQuestionsRepo getInstance;

    private final  ProgressQuestionsApiManager progressQuestionsApiManager;

    private MutableLiveData<List<ProgressQuestion>> PQs = new MutableLiveData<>();
    private MutableLiveData<ProgressQuestion> PQ = new MutableLiveData<>();
    private MutableLiveData<Boolean> operationSuccess = new MutableLiveData<>();

    public ProgressQuestionsRepo(){
        progressQuestionsApiManager = ProgressQuestionsApiManager.getInstance();
    }
    public MutableLiveData<List<ProgressQuestion>> getProgressQuestions() {
        progressQuestionsApiManager.getProgress(new Callback<List<ProgressQuestion>>() {
            @Override
            public void onResponse(Call<List<ProgressQuestion>> call, Response<List<ProgressQuestion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ProgressQuestion> body = response.body();
                    PQs.setValue(body);
                } else {
                    PQs.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<ProgressQuestion>> call, Throwable throwable) {
                PQs.postValue(null);
                Log.e("ProgressQuestionsRepo", "failed to getProgressQuestions: " + throwable.getMessage());
            }
        });
        return PQs;
    }
    public MutableLiveData<List<ProgressQuestion>> getProgressByUsername(String username){
        progressQuestionsApiManager.getProgressByUsername(username, new Callback<List<ProgressQuestion>>() {
        @Override
            public void onResponse(Call<List<ProgressQuestion>> call, Response<List<ProgressQuestion>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    List<ProgressQuestion> body = response.body();
                    PQs.setValue(body);
                }
                else {
                    PQs.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<ProgressQuestion>> call, Throwable throwable) {
                PQs.postValue(null);
                Log.e("ProgressQuestionsRepo", "failed to getProgressQuestionByUsername: "+throwable.getMessage() );
            }
    });
        return PQs;
    }


    public MutableLiveData<ProgressQuestion> getProgressByUsernameAndIdSet(String username, int idSet){
        progressQuestionsApiManager.getProgressByUsernameAndIdSet(username, idSet, new Callback<ProgressQuestion>() {
            @Override
            public void onResponse(Call<ProgressQuestion> call, Response<ProgressQuestion> response) {
                if (response.isSuccessful() && response.body()!=null){
                    ProgressQuestion body = response.body();
                    PQ.setValue(body);
                }
                else {
                    PQ.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ProgressQuestion> call, Throwable throwable) {
                PQ.postValue(null);
                Log.e("ProgressQuestionsRepo", "failed to getProgressQuestionByUsernameAndIdSet: "+throwable.getMessage() );
            }
        });
        return PQ;
    }

    public MutableLiveData<Boolean> postProgress(ProgressQuestion progressQuestion){
        progressQuestionsApiManager.postProgress(progressQuestion, new Callback<ProgressQuestion>() {
            @Override
            public void onResponse(Call<ProgressQuestion> call, Response<ProgressQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<ProgressQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("ProgressQuestionsRepo", "failed to postProgress: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }
    public MutableLiveData<Boolean> putProgress(String username, int idSet, ProgressQuestion progressQuestion){
        progressQuestionsApiManager.putProgress(username, idSet, progressQuestion, new Callback<ProgressQuestion>() {
            @Override
            public void onResponse(Call<ProgressQuestion> call, Response<ProgressQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<ProgressQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("ProgressQuestionsRepo", "failed to putProgress: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }
    public MutableLiveData<Boolean> deleteProgress(String username ,int idSet){
        progressQuestionsApiManager.deleteProgress(username, idSet, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("ProgressQuestionsRepo", "failed to deleteProgress: "+throwable.getMessage() );
            }
        });
        return  operationSuccess;
    }

}
