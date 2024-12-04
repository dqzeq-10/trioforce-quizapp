package com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.ProgressQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ProgressQuestionsApiManager {
    private static IProgressQuestionsApi iProgressQuestionsAPi;
    private static ProgressQuestionsApiManager progressQuestionsApiManager;

    private ProgressQuestionsApiManager() {
        iProgressQuestionsAPi = RetrofitService.createInstancePQ();
    }

    public static ProgressQuestionsApiManager getInstance() {
        if (progressQuestionsApiManager == null) {
            progressQuestionsApiManager = new ProgressQuestionsApiManager();
        }
        return progressQuestionsApiManager;
    }

    public void getProgress(Callback<List<ProgressQuestion>> callback) {
        Call<List<ProgressQuestion>> progressCall = iProgressQuestionsAPi.getProgress();
        progressCall.enqueue(callback);
    }

    public void getProgressByUsername(String username, Callback<List<ProgressQuestion>> callback) {
        Call<List<ProgressQuestion>> progressCall = iProgressQuestionsAPi.getProgressByUsername(username);
        progressCall.enqueue(callback);
    }

    public void getProgressByUsernameAndIdSet(String username, int idSet, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsAPi.getProgressByUsernameAndIdSet(username, idSet);
        progressCall.enqueue(callback);
    }



    public void postProgress(ProgressQuestion progressQuestion, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsAPi.postProgress(progressQuestion);
        progressCall.enqueue(callback);
    }

    public void putProgress(String username, int idSet, ProgressQuestion progressQuestion, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsAPi.putProgress(username, idSet , progressQuestion);
        progressCall.enqueue(callback);

    }

    public void deleteProgress(String username, int idSet, Callback<Void> callback) {
        Call<Void> progressCall = iProgressQuestionsAPi.deleteProgress(username, idSet);
        progressCall.enqueue(callback);
    }
}
