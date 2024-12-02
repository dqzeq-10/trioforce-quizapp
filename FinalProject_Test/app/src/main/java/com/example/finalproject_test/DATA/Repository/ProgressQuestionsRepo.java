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
    public MutableLiveData<ProgressQuestion> getProgressQuestionById(int id){
        progressQuestionsApiManager.getProgressById(id, new Callback<ProgressQuestion>() {
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
                Log.e("ProgressQuestionsRepo", "failed to getProgressQuestionById: "+throwable.getMessage() );
            }
    });
        return PQ;
    }

    public MutableLiveData<Boolean> posProgress(ProgressQuestion progressQuestion){
        progressQuestionsApiManager.postProgress(progressQuestion, new Callback<ProgressQuestion>() {
            @Override
            public void onResponse(Call<ProgressQuestion> call, Response<ProgressQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<ProgressQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("ProgresQuestionsRepo", "failed to postProgress: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }
    public MutableLiveData<Boolean> putProgress(int id, ProgressQuestion progressQuestion){
        progressQuestionsApiManager.putProgress(id, progressQuestion, new Callback<ProgressQuestion>() {
            @Override
            public void onResponse(Call<ProgressQuestion> call, Response<ProgressQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<ProgressQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("ProgresQuestionsRepo", "failed to putProgress: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }
    public MutableLiveData<Boolean> deleteProgress(int id){
        progressQuestionsApiManager.deleteProgress(id, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("ProgresQuestionsRepo", "failed to deleteProgress: "+throwable.getMessage() );
            }
        });
        return  operationSuccess;
    }

}
