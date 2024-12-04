package com.example.finalproject_test.DATA.InterfaceAPI.CreatedQuestionApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.CreatedQuestion;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CreatedQuestionApiManager {
    private static ICreatedQuestionApi iCreatedQuestionApi;
    private static CreatedQuestionApiManager createdQuestionApiManager;

    private CreatedQuestionApiManager() {
        iCreatedQuestionApi = RetrofitService.createInstanceCQ();
    }

    public static CreatedQuestionApiManager getInstance() {
        if (createdQuestionApiManager == null) {
            createdQuestionApiManager = new CreatedQuestionApiManager();
        }
        return createdQuestionApiManager;
    }

    public void getCreatedQuestions(Callback<List<CreatedQuestion>> callback) {
        Call<List<CreatedQuestion>> rankCall = iCreatedQuestionApi.getCreatedQuestions();
        rankCall.enqueue(callback);
    }

    public void getCreatedQuesitonsByUsername(String username, Callback<List<CreatedQuestion>> callback) {
        Call<List<CreatedQuestion>> call = iCreatedQuestionApi.getCreateQuestionByUsername(username);
        call.enqueue(callback);
    }

    public void getCreatedQuesitonsByUsernameAndIdQuestion(String username, int idQuestion, Callback<CreatedQuestion> callback) {
        Call<CreatedQuestion> call = iCreatedQuestionApi.getCreatedQuestionByUsernameAndIdQuestion(username, idQuestion);
        call.enqueue(callback);
    }


    public void postCreatedQuesiton(CreatedQuestion createdQuestion, Callback<CreatedQuestion> callback) {
        Call<CreatedQuestion> call = iCreatedQuestionApi.postCreatedQuestion(createdQuestion);
        call.enqueue(callback);
    }

    public void putCreatedQuesiton(String username, int idQuestion, CreatedQuestion createdQuestion, Callback<CreatedQuestion> callback) {
        Call<CreatedQuestion> call = iCreatedQuestionApi.putCreatedQuestion(username, idQuestion, createdQuestion);
        call.enqueue(callback);
    }

    public void deleteCreatedQuesiton(String username, int idQuestion, Callback<Void> callback) {
        Call<Void> call = iCreatedQuestionApi.deleteCreatedQuestion(username, idQuestion);
        call.enqueue(callback);
    }
}
