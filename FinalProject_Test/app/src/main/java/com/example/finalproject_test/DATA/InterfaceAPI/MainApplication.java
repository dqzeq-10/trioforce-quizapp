package com.example.finalproject_test.DATA.InterfaceAPI;

import android.app.Application;

import com.example.finalproject_test.DATA.InterfaceAPI.LevelApi.LevelsApiManager;
import com.example.finalproject_test.DATA.InterfaceAPI.UserApi.UsersApiManager;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;
    public static LevelsApiManager levelsApiManager;

    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();
        levelsApiManager = LevelsApiManager.getInstance();
      //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
      //vd: questionApiManager = new QuestionApiManager.getInstance();
      //...
    }
}
