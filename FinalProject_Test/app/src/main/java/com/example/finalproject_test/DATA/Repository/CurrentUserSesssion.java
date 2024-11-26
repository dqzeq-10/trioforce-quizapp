package com.example.finalproject_test.DATA.Repository;

import com.example.finalproject_test.DATA.Models.User;

public class CurrentUserSesssion {
     private static CurrentUserSesssion instance;
     private User user;

     private  CurrentUserSesssion(){

     }

     public static synchronized CurrentUserSesssion getInstance(){
         if (instance == null){
             instance = new CurrentUserSesssion();
         }
         return instance;
     }

     public void setUserCurrent(User user){
         this.user = user;
     }

     public User getUserCurrent(){
         return user;
     }

     public void clearSession(){
         user = null;
     }


}
