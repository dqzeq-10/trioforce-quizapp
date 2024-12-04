package com.example.finalproject_test.DATA.InterfaceAPI;

import android.app.Application;

import com.example.finalproject_test.DATA.InterfaceAPI.CreatedQuestionApi.CreatedQuestionApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi.MarkedQuestionApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.ProgressQuestionApi.ProgressQuestionsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionApi.QuestionsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi.QuestionSetsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.UsersApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi.MarkedQuestionApiManager;
import com.example.finalproject_test.DATA.Models.CreatedQuestion;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;
    public static QuestionsApiManager questionsApiManager;
    public static QuestionSetsApiManager questionSetsApiManager;

    public static CreatedQuestionApiManager createdQuestionApiManager;
    public static MarkedQuestionApiManager markedQuestionApiManager;
    public static ProgressQuestionsApiManager progressQuestionsApiManager;

    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();
        questionsApiManager = QuestionsApiManager.getInstance();

        questionSetsApiManager = QuestionSetsApiManager.getInstance();

        createdQuestionApiManager = CreatedQuestionApiManager.getInstance();
        markedQuestionApiManager = MarkedQuestionApiManager.getInstance();
        progressQuestionsApiManager = ProgressQuestionsApiManager.getInstance();


        //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
        //vd: questionApiManager = new QuestionApiManager.getInstance();
        //...
    }
}