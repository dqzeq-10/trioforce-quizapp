package com.example.finalproject_test.DATA.ViewModels.SharedVM;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.Models.QuestionSet;

import java.util.ArrayList;

public class SQASharedViewModel extends ViewModel {
    private final MutableLiveData<QuestionSet> setLiveData = new MutableLiveData<>();

    public MutableLiveData<QuestionSet> getSetLiveData() {
        return setLiveData;
    }

    public void setSetName(String setName) {
        QuestionSet set = setLiveData.getValue();
        if (set != null) {
            set.setSetName(setName);
            setLiveData.setValue(set);
        }
    }

    public void setAuthorName(String authorName) {
        QuestionSet set = setLiveData.getValue();
        if (set != null) {
            set.setAuthorName(authorName);
            setLiveData.setValue(set);
        }
    }

    public void setIdLevel(int idLevel) {
        QuestionSet set = setLiveData.getValue();
        if (set != null) {
            set.setIdLevel(idLevel);
            setLiveData.setValue(set);
        }
    }

    public void setIdCategory(int idCategory) {
        QuestionSet set = setLiveData.getValue();
        if (set != null) {
            set.setIdCategory(idCategory);
            setLiveData.setValue(set);
        }
    }

    public void addQuestion(Question question) {
        QuestionSet set = setLiveData.getValue();
        if (set != null) {
            if (set.getQuestions() == null) {

                set.setQuestions(new ArrayList<>());
            }
            set.getQuestions().add(question);
            setLiveData.setValue(set);
        }
    }


}
