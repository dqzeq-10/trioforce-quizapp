package com.example.finalproject_test.DATA.InterfaceAPI;

import android.app.Application;

import com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi.MarkedQuestionApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionApi.QuestionsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi.QuestionSetsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.RankingApi.RankingApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.UsersApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.MarkedQuestionApi.MarkedQuestionApiManager;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;
    public static QuestionsApiManager questionsApiManager;
<<<<<<< HEAD
    public static MarkedQuestionApiManager markedQuestionApiManager;
=======
    public static QuestionSetsApiManager questionSetsApiManager;
    public static RankingApiManager rankingApiManager;
>>>>>>> 80960fb170091c18f85ad5bdc98e96f09ded370c

    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();
        questionsApiManager = QuestionsApiManager.getInstance();
<<<<<<< HEAD
        markedQuestionApiManager = MarkedQuestionApiManager.getInstance();
=======
        questionSetsApiManager = QuestionSetsApiManager.getInstance();
        rankingApiManager = RankingApiManager.getInstance();

>>>>>>> 80960fb170091c18f85ad5bdc98e96f09ded370c
      //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
      //vd: questionApiManager = new QuestionApiManager.getInstance();
      //...
    }
}
