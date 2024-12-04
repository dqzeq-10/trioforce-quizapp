package com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.MarkedQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MarkedQuestionApiManager {
    private static IMarkedQuestionApi iMarkedQuestionApi;
    private static MarkedQuestionApiManager markedQuestionApiManager;

    private MarkedQuestionApiManager() {
        iMarkedQuestionApi = RetrofitService.createInstanceMQ();
    }

    public static MarkedQuestionApiManager getInstance() {
        if (markedQuestionApiManager == null) {
            markedQuestionApiManager = new MarkedQuestionApiManager();
        }
        return markedQuestionApiManager;
    }

    public void getMarkedQuestions(Callback<List<MarkedQuestion>> callback) {
        Call<List<MarkedQuestion>> call = iMarkedQuestionApi.getMarkedQuestions();
        call.enqueue(callback);
    }

    public void getMarkedQuestionByUsername(String username, Callback<List<MarkedQuestion>> callback) {
        Call<List<MarkedQuestion>> call = iMarkedQuestionApi.getMarkedQuestionByUsername(username);
        call.enqueue(callback);
    }

    public void getMarkedQuestionByUsernameAndIdQuestion(String username, int idQuestion, Callback<MarkedQuestion> callback) {
        Call<MarkedQuestion> call = iMarkedQuestionApi.getMarkedQuestionByUsernameAndIdQuestion(username, idQuestion);
        call.enqueue(callback);
    }



    public void postMarkedQuestion(MarkedQuestion markedQuestion, Callback<MarkedQuestion> callback) {
        Call<MarkedQuestion> call = iMarkedQuestionApi.postMarkedQuestion(markedQuestion);
        call.enqueue(callback);

    }

    public void putMarkedQuestion(String username, int idQuestion, MarkedQuestion markedQuestion, Callback<MarkedQuestion> callback) {
        Call<MarkedQuestion> call = iMarkedQuestionApi.putMarkedQuestion(username,idQuestion, markedQuestion);
        call.enqueue(callback);
    }

    public void deleteMarkedQuestion(String username,int idQuestion, Callback<Void> callback) {
        Call<Void> call = iMarkedQuestionApi.deleteMarkedQuestion(username, idQuestion);
        call.enqueue(callback);
    }
}
