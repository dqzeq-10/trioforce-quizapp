package com.example.finalproject_test.DATA.InterfaceAPI.AnswersApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.Answer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AnswersApiManager {
    private static IAnswersApi iAnswersApi;
    private static AnswersApiManager answersApiManager;

    private AnswersApiManager(){
        iAnswersApi = RetrofitService.createInstanceAns();
    }

    public static AnswersApiManager getInstance(){
        if (answersApiManager == null){
            answersApiManager = new AnswersApiManager();
        }
        return answersApiManager;
    }

    public void getAnswers (Callback<List<Answer>> callback){
        Call<List<Answer>> qCall = iAnswersApi.getAnswers();
        qCall.enqueue(callback);
    }

    public void getAnswerById (int id, Callback<Answer> callback){
        Call<Answer> call = iAnswersApi.getAnswerById(id);
        call.enqueue(callback);
    }

    public void postAnswer (Answer answer, Callback<Answer> callback){
        Call<Answer> call = iAnswersApi.postAnswer(answer);
        call.enqueue(callback);
    }

    public void putAnswer (int id, Answer answer, Callback<Answer> callback){
        Call<Answer> call = iAnswersApi.putAnswer(id, answer);
        call.enqueue(callback);
    }

    public void deleteAnswer (int id, Callback<Void> callback){
        Call<Void> call = iAnswersApi.deleteAnswer(id);
        call.enqueue(callback);
    }



}
