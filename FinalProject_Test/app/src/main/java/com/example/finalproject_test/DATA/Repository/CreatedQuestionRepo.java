package com.example.finalproject_test.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.CreatedQuestionApi.CreatedQuestionApiManager;
import com.example.finalproject_test.DATA.Models.CreatedQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatedQuestionRepo {
    private static volatile CreatedQuestionRepo getInstance;

    private final CreatedQuestionApiManager createdQuestionApiManager;

    private final MutableLiveData<List<CreatedQuestion>> CQs = new MutableLiveData<>();
    private final MutableLiveData<CreatedQuestion> CQ = new MutableLiveData<>();
    private final MutableLiveData<Boolean> operationSuccess = new MutableLiveData<>();

    public CreatedQuestionRepo(){

        createdQuestionApiManager = CreatedQuestionApiManager.getInstance();
    }

    public MutableLiveData<List<CreatedQuestion>> getCreatedQuestions() {
        createdQuestionApiManager.getCreatedQuestions(new Callback<List<CreatedQuestion>>() {
            @Override
            public void onResponse(Call<List<CreatedQuestion>> call, Response<List<CreatedQuestion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<CreatedQuestion> body = response.body();
                    CQs.setValue(body);
                } else {
                    CQs.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<CreatedQuestion>> call, Throwable throwable) {
                CQs.postValue(null);
                Log.e("CreatedQuestionRepo", "failed to getCreatedQuestions: " + throwable.getMessage());
            }
        });
        return CQs;
    }

    public MutableLiveData<List<CreatedQuestion>> getCreatedQuestionsByUsername(String username) {
        createdQuestionApiManager.getCreatedQuesitonsByUsername(username, new Callback<List<CreatedQuestion>>() {
            @Override
            public void onResponse(Call<List<CreatedQuestion>> call, Response<List<CreatedQuestion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<CreatedQuestion> body = response.body();
                    CQs.setValue(body);
                } else {
                    CQs.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<CreatedQuestion>> call, Throwable throwable) {
                CQs.postValue(null);
                Log.e("CreatedQuestionRepo", "failed to getCreatedQuestionsByUsername: " + throwable.getMessage());
            }
        });
        return CQs;
    }


    public MutableLiveData<CreatedQuestion> getCreatedQuestionByUsernameAndIdQuestion(String username, int idQuestion){
        createdQuestionApiManager.getCreatedQuesitonsByUsernameAndIdQuestion(username, idQuestion, new Callback<CreatedQuestion>() {
            @Override
            public void onResponse(Call<CreatedQuestion> call, Response<CreatedQuestion> response) {
                if (response.isSuccessful() && response.body()!=null){
                    CreatedQuestion body = response.body();
                    CQ.setValue(body);
                }else {
                    CQ.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<CreatedQuestion> call, Throwable throwable) {
                CQ.postValue(null);
                Log.e("CreatedQuestionRepo", "failed to getCreatedQuestionByUsernameAndIdQuestion: "+throwable.getMessage() );
            }
        });
        return CQ;
    }

    public MutableLiveData<Boolean> postCreatedQuestion(CreatedQuestion createdQuestion){
        createdQuestionApiManager.postCreatedQuesiton(createdQuestion, new Callback<CreatedQuestion>() {
            @Override
            public void onResponse(Call<CreatedQuestion> call, Response<CreatedQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<CreatedQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("CreatedQuestionRepo", "failed to postCreatedQuestion: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> putCreatedQuestion(String username, int idQuestion, CreatedQuestion questionSet){
        createdQuestionApiManager.putCreatedQuesiton(username, idQuestion, questionSet, new Callback<CreatedQuestion>() {
            @Override
            public void onResponse(Call<CreatedQuestion> call, Response<CreatedQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<CreatedQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("CreatedQuestionRepo", "failed to putCreatedQuestion: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> deleteCreatedQuestion(String username, int idQuestion){
        createdQuestionApiManager.deleteCreatedQuesiton(username, idQuestion, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("CreatedQuestionRepo", "failed to deleteCreatedQuestion: "+throwable.getMessage() );
            }
        });
        return  operationSuccess;
    }

}