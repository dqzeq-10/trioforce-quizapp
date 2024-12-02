package com.example.finalproject_test.DATA.ViewModels.ProgressQuestionsVM;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject_test.DATA.Models.ProgressQuestion;
import com.example.finalproject_test.DATA.Repository.ProgressQuestionsRepo;

import java.util.List;
public class ProgressQuestonsViewModel extends ViewModel {
    private final ProgressQuestionsRepo progressQuestionsRepo;
    private MutableLiveData<List<ProgressQuestion>> PQs;

    public ProgressQuestonsViewModel() {
        progressQuestionsRepo = new ProgressQuestionsRepo();
    }

    public MutableLiveData<List<ProgressQuestion>> getProgressQuestions() {
        return progressQuestionsRepo.getProgressQuestions();
    }
    public MutableLiveData<ProgressQuestion> getProgressQuestionById(int id){
        return progressQuestionsRepo.getProgressQuestionById(id);
    }
    public MutableLiveData<Boolean> posProgress(ProgressQuestion progressQuestion){
        return progressQuestionsRepo.posProgress(progressQuestion);
    }
    public MutableLiveData<Boolean> putProgress(int id, ProgressQuestion progressQuestion){
        return progressQuestionsRepo.putProgress(id, progressQuestion);
    }
    public MutableLiveData<Boolean> deleteProgress(int id){
        return progressQuestionsRepo.deleteProgress(id);
    }
}
