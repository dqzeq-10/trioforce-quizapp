package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;


import com.example.finalproject_test.DATA.Models.QuestionSet;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SQASharedViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class main_create_quiz extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager_Create_quiz;
    private ViewpagerAdapter_CreateQuiz adapter;
    private SQASharedViewModel sqaSharedViewModel;
    private QuestionSet qset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_create_quiz);

//        String tenbocauhoi = getIntent().getStringExtra("QSName");
//        int tentheloai = getIntent().getIntExtra("QSCate",1);
//        int tenlevel = getIntent().getIntExtra("QSLevel",1);

        sqaSharedViewModel = new ViewModelProvider(this).get(SQASharedViewModel.class);
        sqaSharedViewModel.setSetName(getIntent().getStringExtra("QSName"));
        sqaSharedViewModel.setAuthorName(getIntent().getStringExtra("username"));
        sqaSharedViewModel.setIdCategory(getIntent().getIntExtra("QSCate", 1));
        sqaSharedViewModel.setIdLevel(getIntent().getIntExtra("QSLevel", 1));
       // Toast.makeText(this, "main create đã nhận" + getIntent().getStringExtra("QSName") + getIntent().getIntExtra("QSCate", 1) + getIntent().getIntExtra("QSLevel", 1), Toast.LENGTH_LONG).show();
        Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getSetName());
        Log.d("postset", sqaSharedViewModel.getSetLiveData().getValue().getAuthorName());
        Log.d("postset", String.valueOf(sqaSharedViewModel.getSetLiveData().getValue().getIdLevel()));
        Log.d("postset", String.valueOf(sqaSharedViewModel.getSetLiveData().getValue().getIdCategory()));

        tabLayout = findViewById(R.id.tabLayout_createQuiz);
        viewPager_Create_quiz = findViewById(R.id.viewPager_createQuiz);

        disableTabs();

        // Set up adapter
        adapter = new ViewpagerAdapter_CreateQuiz(this);
        viewPager_Create_quiz.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager_Create_quiz, (tab, position) -> {
            tab.setText(String.valueOf(position + 1)); // Đặt số tab từ 1 đến 10
        }).attach();
        disableTabs();

        ImageButton imagebtnBack = findViewById(R.id.imagebtnBack);
        imagebtnBack.setOnClickListener(view -> {
            Intent it = new Intent(main_create_quiz.this, MainScreen.class);
            startActivity(it);
            finish();
        });
    }


    private void disableTabs() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.view.setEnabled(false);
            }
        }
    }


    public void goToPreviousFragment() {
        int Item = viewPager_Create_quiz.getCurrentItem();
        if (Item > 0) {
            viewPager_Create_quiz.setCurrentItem(Item - 1);
        }
    }

    public void goToNextFragment() {
        int Item = viewPager_Create_quiz.getCurrentItem();
        if (Item < adapter.getItemCount() - 1) {
            viewPager_Create_quiz.setCurrentItem(Item + 1);
        }
    }

}
