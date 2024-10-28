package com.example.finalproject_test;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class main_create_quiz extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager_Create_quiz;
    private ViewpagerAdapter_CreateQuiz adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_create_quiz);

        tabLayout = findViewById(R.id.tabLayout_createQuiz);
        viewPager_Create_quiz = findViewById(R.id.viewPager_createQuiz);

        // Set up adapter
        adapter = new ViewpagerAdapter_CreateQuiz(this);
        viewPager_Create_quiz.setAdapter(adapter);

        // TabLayoutMediator to connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager_Create_quiz, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("1");
                    break;
                case 1:
                    tab.setText("2");
                    break;
                case 2:
                    tab.setText("3");
                    break;
                case 3:
                    tab.setText("4");
                    break;
                case 4:
                    tab.setText("5");
                    break;
                case 5:
                    tab.setText("6");
                    break;
                case 6:
                    tab.setText("7");
                    break;
                case 7:
                    tab.setText("8");
                    break;
                case 8:
                    tab.setText("9");
                    break;
                case 9:
                    tab.setText("10");
                    break;
                    }
        }).attach();
    }
}
