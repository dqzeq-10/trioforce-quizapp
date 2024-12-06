package com.example.finalproject_test.DATA.ViewModels.SharedVM;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.Models.QuestionSet;

import java.util.ArrayList;

public class SQASharedViewModel extends ViewModel {
    private final MutableLiveData<QuestionSet> setLiveData = new MutableLiveData<>();

    public SQASharedViewModel() {
        QuestionSet questionSet = new QuestionSet();
        questionSet.setQuestions(new ArrayList<>());
        setLiveData.setValue(questionSet);
    }

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
        if (setLiveData.getValue() == null) {
            QuestionSet questionSet = new QuestionSet();
            questionSet.setQuestions(new ArrayList<>());
            setLiveData.setValue(questionSet);
        }
        QuestionSet currentSet = setLiveData.getValue();
        currentSet.getQuestions().add(question);
        setLiveData.setValue(currentSet);
    }

    public void resetData() {
        if (setLiveData.getValue() != null) {
            QuestionSet currentSet = setLiveData.getValue();
            currentSet.setSetName(null); // Đặt lại tên bộ câu hỏi
            currentSet.setAuthorName(null); // Đặt lại tên tác giả
            currentSet.setIdLevel(0); // Đặt lại ID cấp độ
            currentSet.setIdCategory(0); // Đặt lại ID thể loại
            currentSet.setQuestions(new ArrayList<>()); // Xóa danh sách câu hỏi
            setLiveData.setValue(currentSet); // Cập nhật lại LiveData
        }
    }

}
