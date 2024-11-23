package com.example.finalproject_test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewpagerAdapter_Play_Quiz extends FragmentStateAdapter {


    public ViewpagerAdapter_Play_Quiz(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewpagerAdapter_Play_Quiz(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new Play_quiz_fragment_1();
            case 1:
                return new Play_quiz_fragment_2();
            case 2:
                return new Play_quiz_fragment_3();
            case 3:
                return new Play_quiz_fragment_4();
            case 4:
                return new Play_quiz_fragment_5();
            case 5:
                return new Play_quiz_fragment_6();
            case 6:
                return new Play_quiz_fragment_7();
            case 7:
                return new Play_quiz_fragment_8();
            case 8:
                return new Play_quiz_fragment_9();
            case 9:
                return new Play_quiz_fragment_10();
            default:
                return new Play_quiz_fragment_1();
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

