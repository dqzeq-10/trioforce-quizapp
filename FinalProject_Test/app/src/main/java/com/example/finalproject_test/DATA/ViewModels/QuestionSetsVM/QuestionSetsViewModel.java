package com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.QuestionSet;
import com.example.finalproject_test.DATA.Repository.QuestionSetsRepo;

import java.util.List;

public class QuestionSetsViewModel extends ViewModel {
    private final QuestionSetsRepo questionSetsRepo;
    //private MutableLiveData<List<QuestionSet>> setsLiveData;

    public QuestionSetsViewModel() {
        questionSetsRepo = new QuestionSetsRepo();
        // setsLiveData = questionSetsRepo.getSets();
    }

    public MutableLiveData<List<QuestionSet>> getSets() {
        return questionSetsRepo.getSets();
    }


    public MutableLiveData<QuestionSet> getSetById(int id) {
        return questionSetsRepo.getSetById(id);
    }

    public MutableLiveData<QuestionSet> getSetByIdLevelAndIdCate(int idLevel, int idCategory){
        return questionSetsRepo.getSetByIdLevelAndIdCate(idLevel,idCategory);
    }

    public MutableLiveData<Boolean> postSet(QuestionSet questionSet) {
        return questionSetsRepo.postSet(questionSet);
    }

    public MutableLiveData<Boolean> putSet(int id, QuestionSet questionSet) {
        return questionSetsRepo.putSet(id, questionSet);
    }

    public MutableLiveData<Boolean> deleteSet(int id) {
        return questionSetsRepo.deleteSet(id);
    }
}
