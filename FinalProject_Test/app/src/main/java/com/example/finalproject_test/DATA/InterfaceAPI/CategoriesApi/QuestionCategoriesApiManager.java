package com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi;

import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;

import com.example.finalproject_test.DATA.Models.QuestionCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class QuestionCategoriesApiManager {
    private static IQuestionCategoriesApi iQuestionCategoriesApi;
    private static QuestionCategoriesApiManager questionCategoriesApiManager;

    private QuestionCategoriesApiManager(){
        iQuestionCategoriesApi = RetrofitService.createInstanceCate();
    }

    public static QuestionCategoriesApiManager getInstance(){
        if (questionCategoriesApiManager == null){
            questionCategoriesApiManager = new QuestionCategoriesApiManager();
        }
        return questionCategoriesApiManager;
    }

    public void getCategories (Callback<List<QuestionCategory>> callback){
        Call<List<QuestionCategory>> categoriesCall = iQuestionCategoriesApi.getCategories();
        categoriesCall.enqueue(callback);
    }
}
