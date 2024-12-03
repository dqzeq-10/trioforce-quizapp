package com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.ProgressQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ProgressQuestionsApiManager {
    private static IProgressQuestionsAPi iProgressQuestionsAPi;
    private static ProgressQuestionsApiManager progressQuestionsApiManager;
    private ProgressQuestionsApiManager (){
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
    public void getProgressById(int id, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsAPi.getProgressById(id);
        progressCall.enqueue(callback);

    }
    public void postProgress(ProgressQuestion progressQuestion, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsAPi.postProgress(progressQuestion);
        progressCall.enqueue(callback);
    }
    public void putProgress(int id, ProgressQuestion progressQuestion, Callback<ProgressQuestion> callback) {
        Call<ProgressQuestion> progressCall = iProgressQuestionsAPi.putProgress(id, progressQuestion);
        progressCall.enqueue(callback);

    }
    public void deleteProgress(int id, Callback<Void> callback) {
        Call<Void> progressCall = iProgressQuestionsAPi.deleteProgress(id);
        progressCall.enqueue(callback);
    }
}
