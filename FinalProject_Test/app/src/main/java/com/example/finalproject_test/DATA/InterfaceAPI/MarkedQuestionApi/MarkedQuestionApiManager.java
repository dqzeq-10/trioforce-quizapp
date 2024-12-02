package com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.MarkedQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MarkedQuestionApiManager {
    private static IMarkedQuestionApi iMarkedQuestionApi;
    private static MarkedQuestionApiManager markedQuestionApiManager;

    private MarkedQuestionApiManager(){
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
  public void getMarkedQuestionById(int id, Callback<MarkedQuestion> callback) {
        Call<MarkedQuestion> call = iMarkedQuestionApi.getMarkedQuestionById(id);
        call.enqueue(callback);
  }
    public  void postMarkedQuestion(MarkedQuestion markedQuestion, Callback<MarkedQuestion> callback) {
        Call<MarkedQuestion> call = iMarkedQuestionApi.postMarkedQuestion(markedQuestion);
        call.enqueue(callback);

    }
    public void putMarkedQuestion(int id, MarkedQuestion markedQuestion, Callback<MarkedQuestion> callback) {
        Call<MarkedQuestion> call = iMarkedQuestionApi.putMarkedQuestion(id, markedQuestion);
        call.enqueue(callback);
    }
public void deleteMarkedQuestion(int id, Callback<Void> callback) {
        Call<Void> call = iMarkedQuestionApi.deleteMarkedQuestion(id);
        call.enqueue(callback);
}
}
