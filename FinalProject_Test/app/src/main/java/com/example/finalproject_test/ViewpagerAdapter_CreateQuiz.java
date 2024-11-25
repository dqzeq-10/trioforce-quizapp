package com.example.finalproject_test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques1;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques10;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques2;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques3;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques4;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques5;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques6;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques7;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques8;
import com.example.finalproject_test.createQuestions_Fragments.create_Fragment_Ques9;

public class ViewpagerAdapter_CreateQuiz extends FragmentStateAdapter {


    public ViewpagerAdapter_CreateQuiz(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewpagerAdapter_CreateQuiz(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new create_Fragment_Ques1();
            case 1:
                return new create_Fragment_Ques2();
            case 2:
                return new create_Fragment_Ques3();
            case 3:
                return new create_Fragment_Ques4();
            case 4:
                return new create_Fragment_Ques5();
            case 5:
                return new create_Fragment_Ques6();
            case 6:
                return new create_Fragment_Ques7();
            case 7:
                return new create_Fragment_Ques8();
            case 8:
                return new create_Fragment_Ques9();
            case 9:
                return new create_Fragment_Ques10();
            default:
                return new create_Fragment_Ques1();
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
