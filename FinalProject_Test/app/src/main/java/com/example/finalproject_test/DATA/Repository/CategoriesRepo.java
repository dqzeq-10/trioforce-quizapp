package com.example.finalproject_test.DATA.Repository;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi.QuestionCategoriesApiManager;
import com.example.finalproject_test.DATA.Models.Level;
import com.example.finalproject_test.DATA.Models.QuestionCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepo {
    private static volatile CategoriesRepo instance;
    private final QuestionCategoriesApiManager categoriesApiManager;
    private final MutableLiveData<List<QuestionCategory>> categories = new MutableLiveData<>();

    public CategoriesRepo(){
        categoriesApiManager = QuestionCategoriesApiManager.getInstance();
    }

    public MutableLiveData<List<QuestionCategory>> getCategories() {
        categoriesApiManager.getCategories(new Callback<List<QuestionCategory>>() {
            @Override
            public void onResponse(Call<List<QuestionCategory>> call, Response<List<QuestionCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<QuestionCategory> body = response.body();
                    categories.setValue(body);
                } else {
                    categories.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<QuestionCategory>> call, Throwable throwable) {
                categories.postValue(null);
                Log.e("levelsViewModel", "API call failed: " + throwable.getMessage());
            }


        });
        return categories;

    }

}
