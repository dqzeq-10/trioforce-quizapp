package com.example.finalproject_test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_1;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_10;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_2;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_3;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_4;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_5;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_6;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_7;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_8;
import com.example.finalproject_test.playquizs_Fragments.Play_quiz_fragment_9;


import java.util.List;

public class ViewpagerAdapter_Play_Quiz extends FragmentStateAdapter {

    private final List<Question> questions;


    public ViewpagerAdapter_Play_Quiz(@NonNull FragmentActivity fragmentActivity, List<Question> questions) {
        super(fragmentActivity);
        this.questions = questions;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        if (position>=questions.size()){
//            return new Play_quiz_fragment_Default();
//        }
        //Question question = (position < questions.size()) ? questions.get(position) : null;


        switch(position){
            case 0:
                 return Play_quiz_fragment_1.receiveQuestion(questions.get(position));
            case 1:
                 return  Play_quiz_fragment_2.receiveQuestion(questions.get(position));
            case 2:
                 return  Play_quiz_fragment_3.receiveQuestion(questions.get(position));
            case 3:
                 return  Play_quiz_fragment_4.receiveQuestion(questions.get(position));
            case 4:
                 return  Play_quiz_fragment_5.receiveQuestion(questions.get(position));
            case 5:
                 return  Play_quiz_fragment_6.receiveQuestion(questions.get(position));
            case 6:
                 return  Play_quiz_fragment_7.receiveQuestion(questions.get(position));
            case 7:
                 return  Play_quiz_fragment_8.receiveQuestion(questions.get(position));
            case 8:
                 return  Play_quiz_fragment_9.receiveQuestion(questions.get(position));
            case 9:
                 return  Play_quiz_fragment_10.receiveQuestion(questions.get(position));
            default:
                 return  Play_quiz_fragment_1.receiveQuestion(questions.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

