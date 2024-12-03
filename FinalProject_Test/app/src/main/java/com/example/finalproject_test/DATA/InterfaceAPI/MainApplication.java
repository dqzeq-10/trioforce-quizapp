package com.example.finalproject_test.DATA.InterfaceAPI;

import android.app.Application;

import com.example.finalproject_test.DATA.InterfaceAPI.LevelApi.LevelsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionApi.QuestionsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.QuestionSetsApi.QuestionSetsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.RankingApi.RankingApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.UsersApiManager;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;
    public static QuestionsApiManager questionsApiManager;
    public static QuestionSetsApiManager questionSetsApiManager;
    public static RankingApiManager rankingApiManager;
    public static LevelsApiManager levelsApiManager;
    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();
        questionsApiManager = QuestionsApiManager.getInstance();
        questionSetsApiManager = QuestionSetsApiManager.getInstance();
        levelsApiManager = LevelsApiManager.getInstance();
        rankingApiManager = RankingApiManager.getInstance();

      //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
      //vd: questionApiManager = new QuestionApiManager.getInstance();
      //...
    }
}
