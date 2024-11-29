package com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.QuestionSet;
import com.example.finalproject_test.DATA.Repository.QuestionSetsRepo;

import java.util.List;

public class QuestionSetsViewModel extends ViewModel {
    private final QuestionSetsRepo questionSetsRepo;
    private MutableLiveData<List<QuestionSet>> setsLiveData;

    public QuestionSetsViewModel(){
        questionSetsRepo = new QuestionSetsRepo();
        setsLiveData = questionSetsRepo.getSets();
    }

    public MutableLiveData<List<QuestionSet>> getSets(){
        return setsLiveData;
    }
}
