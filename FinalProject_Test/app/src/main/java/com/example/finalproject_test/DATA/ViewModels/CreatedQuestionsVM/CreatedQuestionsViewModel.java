package com.example.finalproject_test.DATA.ViewModels.CreatedQuestionsVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.CreatedQuestion;
import com.example.finalproject_test.DATA.Repository.CreatedQuestionRepo;

import java.util.List;

public class CreatedQuestionsViewModel extends ViewModel {
    private final CreatedQuestionRepo createdQuestionRepo;

    public CreatedQuestionsViewModel(){
        createdQuestionRepo = new CreatedQuestionRepo();
    }

    public MutableLiveData<List<CreatedQuestion>> getCreatedQuestions(){
        return createdQuestionRepo.getCreatedQuestions();
    }

    public MutableLiveData<List<CreatedQuestion>> getCreatedQuestionByUsername(String username){
        return createdQuestionRepo.getCreatedQuestionsByUsername(username);
    }

    public MutableLiveData<CreatedQuestion> getCreatedQuestionByUsernameAndIdQuestion(String username, int idQuestion){
        return createdQuestionRepo.getCreatedQuestionByUsernameAndIdQuestion(username, idQuestion);
    }

    public MutableLiveData<Boolean> postCreatedQuestion(CreatedQuestion createdQuestion){
        return createdQuestionRepo.postCreatedQuestion(createdQuestion);
    }

    public MutableLiveData<Boolean> putCreatedQuestion(String username, int idQuestion, CreatedQuestion createdQuestion){
        return createdQuestionRepo.putCreatedQuestion(username, idQuestion, createdQuestion);
    }

    public MutableLiveData<Boolean> deleteCreatedQuestion(String username, int idQuestion){
        return createdQuestionRepo.deleteCreatedQuestion(username, idQuestion);
    }
}
