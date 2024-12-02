package com.example.finalproject_test.DATA.ViewModels.CategoriesVM;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.QuestionCategory;
import com.example.finalproject_test.DATA.Repository.CategoriesRepo;

import java.util.List;

public class CategoriesViewModel extends ViewModel{
    private final CategoriesRepo categoriesRepo;
    private MutableLiveData<List<QuestionCategory>> categoriesLiveData;

    public CategoriesViewModel() {
        categoriesRepo = new CategoriesRepo();
        categoriesLiveData = categoriesRepo.getCategories();
    }
    public MutableLiveData<List<QuestionCategory>> getCategories() {
        return categoriesLiveData;
    }
}
