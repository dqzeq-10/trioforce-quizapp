package com.example.finalproject_test.DATA.ViewModels.MarkedQuestionVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.MarkedQuestion;
import com.example.finalproject_test.DATA.Repository.MarkedQuestionRepo;

import java.util.List;

public class MarkedQuestionViewModel extends ViewModel {
    private final MarkedQuestionRepo markedQuestionRepo;
    public MarkedQuestionViewModel(){
        markedQuestionRepo = new MarkedQuestionRepo();

    }
    public MutableLiveData<List<MarkedQuestion>> getMarkedQuestions(){
        return markedQuestionRepo.getMarkedQuestions();
    }

    public MutableLiveData<MarkedQuestion> getMarkedQuestionById(int id){
        return markedQuestionRepo.getMarkedQuestionById(id);
    }
    public MutableLiveData<Boolean> postMarkedQuestion(MarkedQuestion Mquestion){
        return markedQuestionRepo.postMarkedQuestion(Mquestion);
    }

    public MutableLiveData<Boolean> putMarkedQuestion(int id, MarkedQuestion Mquestion){
        return markedQuestionRepo.putMarkedQuestion(id, Mquestion);
    }
    public MutableLiveData<Boolean> deleteMarkedQuestion(int id){
        return markedQuestionRepo.deleteMarkedQuestion(id);
    }
}
