package com.example.finalproject_test.DATA.ViewModels.MarkedQuestionsVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.MarkedQuestion;
import com.example.finalproject_test.DATA.Repository.MarkedQuestionRepo;

import java.util.List;

public class MarkedQuestionsViewModel extends ViewModel {
    private final MarkedQuestionRepo markedQuestionRepo;

    public MarkedQuestionsViewModel() {
        markedQuestionRepo = new MarkedQuestionRepo();
    }

    public MutableLiveData<List<MarkedQuestion>> getMarkedQuestions() {
        return markedQuestionRepo.getMarkedQuestions();
    }

    public MutableLiveData<List<MarkedQuestion>> getMarkedQuestionsByUsername(String username) {
        return markedQuestionRepo.getMarkedQuestionsByUsername(username);
    }

    public MutableLiveData<MarkedQuestion> getMarkedQuestionByUsernammeAndIdQuestion(String username, int idQuestion) {
        return markedQuestionRepo.getMarkedQuestionByUsernameAndIdQuestion(username, idQuestion);
    }

    public MutableLiveData<Boolean> postMarkedQuestion(MarkedQuestion markedQuestion) {
        return markedQuestionRepo.postMarkedQuestion(markedQuestion);
    }

    public MutableLiveData<Boolean> putMarkedQuestion(String username, int idQuestion, MarkedQuestion markedQuestion) {
        return markedQuestionRepo.putMarkedQuestion(username, idQuestion, markedQuestion);
    }

    public MutableLiveData<Boolean> deleteMarkedQuestion(String username, int idQuestion) {
        return markedQuestionRepo.deleteMarkedQuestion(username, idQuestion);
    }
}
