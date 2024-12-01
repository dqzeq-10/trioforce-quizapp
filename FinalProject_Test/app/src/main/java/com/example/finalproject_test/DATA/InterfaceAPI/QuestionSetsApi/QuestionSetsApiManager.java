package com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.QuestionSet;
import com.example.finalproject_test.DATA.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class QuestionSetsApiManager {
    private static IQuestionSetsApi iQuestionSetsApi;
    private static QuestionSetsApiManager questionSetsApiManager;

    private QuestionSetsApiManager(){
        iQuestionSetsApi = RetrofitService.createInstanceSet();
    }

    public static QuestionSetsApiManager getInstance(){
        if (questionSetsApiManager == null){
            questionSetsApiManager = new QuestionSetsApiManager();
        }
        return questionSetsApiManager;
    }

    public void getSets (Callback<List<QuestionSet>> callback){
        Call<List<QuestionSet>> setsCall = iQuestionSetsApi.getSets();
        setsCall.enqueue(callback);
    }

    public void getSetById(int id, Callback<QuestionSet> callback){
        Call<QuestionSet> scall = iQuestionSetsApi.getSetById(id);
        scall.enqueue(callback);
    }

    public void getSetByIdLevelAndIdCate(int idLevel, int idCategory, Callback<QuestionSet> callback){
        Call<QuestionSet> call = iQuestionSetsApi.getSetByIdLevelAndIdCate(idLevel,idCategory);
        call.enqueue(callback);
    }

    public void postSet(QuestionSet questionSet, Callback<QuestionSet> callback){
        Call<QuestionSet> call = iQuestionSetsApi.postSet(questionSet);
        call.enqueue(callback);
    }

    public void putSet(int id, QuestionSet questionSet, Callback<QuestionSet> callback){
        Call<QuestionSet> call = iQuestionSetsApi.putSet(id, questionSet);
        call.enqueue(callback);
    }

    public void deleteSet(int id, Callback<Void> callback){
        Call<Void> call = iQuestionSetsApi.deleteSet(id);
        call.enqueue(callback);
    }
}

