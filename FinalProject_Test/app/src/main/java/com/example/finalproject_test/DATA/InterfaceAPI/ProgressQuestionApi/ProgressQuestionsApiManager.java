package com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.ProgressQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ProgressQuestionsApiManager {
    private static IProgressQuestionsApi iProgressQuestionsApi;
    private static ProgressQuestionsApiManager progressQuestionsApiManager;

    private ProgressQuestionsApiManager(){
        iProgressQuestionsApi = RetrofitService.createInstancePQ();
    }


    public static ProgressQuestionsApiManager getInstance() {
        if (progressQuestionsApiManager == null) {
            progressQuestionsApiManager = new ProgressQuestionsApiManager();
        }
        return progressQuestionsApiManager;
    }

    public void getProgress(Callback<List<ProgressQuestion>> callback) {
        Call<List<ProgressQuestion>> progressCall = iProgressQuestionsApi.getProgress();
        progressCall.enqueue(callback);
    }

    public void getProgressByUsername(String username, Callback<List<ProgressQuestion>> callback) {
        Call<List<ProgressQuestion>> progressCall = iProgressQuestionsApi.getProgressByUsername(username);
        progressCall.enqueue(callback);
    }

    public void getProgressByUsernameAndIdSet(String username, int idSet, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsApi.getProgressByUsernameAndIdSet(username, idSet);
        progressCall.enqueue(callback);
    }



    public void postProgress(ProgressQuestion progressQuestion, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsApi.postProgress(progressQuestion);
        progressCall.enqueue(callback);
    }

    public void putProgress(String username, int idSet, ProgressQuestion progressQuestion, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsApi.putProgress(username, idSet , progressQuestion);
        progressCall.enqueue(callback);

    }

    public void deleteProgress(String username, int idSet, Callback<Void> callback) {
        Call<Void> progressCall = iProgressQuestionsApi.deleteProgress(username, idSet);
        progressCall.enqueue(callback);
    }
}
