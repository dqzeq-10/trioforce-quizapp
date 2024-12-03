package com.example.finalproject_test.DATA.Repository;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi.MarkedQuestionApiManager;
import com.example.finalproject_test.DATA.Models.MarkedQuestion;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MarkedQuestionRepo {
    private static volatile MarkedQuestionRepo getInstance;

    private final MarkedQuestionApiManager markedQuestionApiManager;

    private final MutableLiveData<List<MarkedQuestion>> MQs = new MutableLiveData<>();
    private final MutableLiveData<MarkedQuestion> MQ = new MutableLiveData<>();
    private final MutableLiveData<Boolean> operationSuccess = new MutableLiveData<>();

    public MarkedQuestionRepo(){

        markedQuestionApiManager = MarkedQuestionApiManager.getInstance();
    }

    public MutableLiveData<List<MarkedQuestion>> getMarkedQuestions() {
        markedQuestionApiManager.getMarkedQuestions(new Callback<List<MarkedQuestion>>() {
            @Override
            public void onResponse(Call<List<MarkedQuestion>> call, Response<List<MarkedQuestion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MarkedQuestion> body = response.body();
                    MQs.setValue(body);
                } else {
                    MQs.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<MarkedQuestion>> call, Throwable throwable) {
                MQs.postValue(null);
                Log.e("MarkedQuestionRepo", "failed to getMarkedQuestions: " + throwable.getMessage());
            }
        });
        return MQs;
    }


    public MutableLiveData<MarkedQuestion> getMarkedQuestionById(int id){
        markedQuestionApiManager.getMarkedQuestionById(id, new Callback<MarkedQuestion>() {
            @Override
            public void onResponse(Call<MarkedQuestion> call, Response<MarkedQuestion> response) {
                if (response.isSuccessful() && response.body()!=null){
                    MarkedQuestion body = response.body();
                    MQ.setValue(body);
                }else {
                    MQ.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<MarkedQuestion> call, Throwable throwable) {
                MQ.postValue(null);
                Log.e("MakedQuestionRepo", "failed to getMarkedQuestionById: "+throwable.getMessage() );
            }
        });
        return MQ;
    }

    public MutableLiveData<Boolean> postMarkedQuestion(MarkedQuestion markedQuestion){
        markedQuestionApiManager.postMarkedQuestion(markedQuestion, new Callback<MarkedQuestion>() {
            @Override
            public void onResponse(Call<MarkedQuestion> call, Response<MarkedQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<MarkedQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("MarkedQuestionRepo", "failed to postMarkedQuestion: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> putMarkedQuestion(int id, MarkedQuestion questionSet){
        markedQuestionApiManager.putMarkedQuestion(id, questionSet, new Callback<MarkedQuestion>() {
            @Override
            public void onResponse(Call<MarkedQuestion> call, Response<MarkedQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<MarkedQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("MarkedQuestionRepo", "failed to putMarkedQuestion: "+throwable.getMessage() );
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> deleteMarkedQuestion(int id){
        markedQuestionApiManager.deleteMarkedQuestion(id, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("MarkedQuestionRepo", "failed to deleteMarkedQuestion: "+throwable.getMessage() );
            }
        });
        return  operationSuccess;
    }

}
