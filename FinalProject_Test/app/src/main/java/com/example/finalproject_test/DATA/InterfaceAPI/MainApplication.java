package com.example.finalproject_test.DATA.InterfaceAPI;

import android.app.Application;

import com.example.finalproject_test.DATA.InterfaceAPI.QuestionApi.QuestionsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.UsersApiManager;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;
    public static QuestionsApiManager questionsApiManager;

    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();
        questionsApiManager = QuestionsApiManager.getInstance();
      //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
      //vd: questionApiManager = new QuestionApiManager.getInstance();
      //...
    }
}
