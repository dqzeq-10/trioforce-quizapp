package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM.QuestionSetsViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class main_play_quiz extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager_play_quiz;
    private ViewpagerAdapter_Play_Quiz adapter;
    Dialog dialog;
    TextView btn_dialogLuuThoat, btn_dialogHuy, txtLevel, txtcategory;
    QuestionSetsViewModel setsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_play_quiz);

        viewPager_play_quiz = findViewById(R.id.viewPager_Play_Quiz);
        tabLayout = findViewById(R.id.tabLayout_Play_Quiz);



        ImageButton btnBack = findViewById(R.id.imagebtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        // nhận idCategory, idLevel
        int idCate = getIntent().getIntExtra("idCategory", 1);
        int idLevel = getIntent().getIntExtra("idLevel", 1);


        setsViewModel = new ViewModelProvider(this).get(QuestionSetsViewModel.class);
        setsViewModel.getSetByIdLevelAndIdCate(idLevel, idCate).observe(main_play_quiz.this, set -> {

            if (set != null && set.getQuestions() != null) {
                // Truyền set.getQuestions().get(0) cho fragment thứ nhất, set.getQuestions().get(1) cho fragment thứ hai,...
                // Set up adapter
                adapter = new ViewpagerAdapter_Play_Quiz(this, set.getQuestions());
                viewPager_play_quiz.setAdapter(adapter);

                new TabLayoutMediator(tabLayout, viewPager_play_quiz, (tab, position) -> {
                    tab.setText(String.valueOf(position + 1)); // Đặt số tab từ 1 đến 10
                }).attach();
            } else
                Log.e("main_play_quiz", "Dữ liệu câu hỏi rỗng hoặc không hợp lệ");




//Bundle
        Bundle dataBundle = new Bundle();
        dataBundle.putInt("idCategory", idCate);
        dataBundle.putInt("idLevel", idLevel);


        //--------------- truyen muc do ----------------------------------------------
        txtLevel = findViewById(R.id.txtlevel);
        String level = getIntent().getStringExtra("level");
        if (level != null) {
            txtLevel.setText(level);
        }
        txtcategory = findViewById(R.id.txtTheLoai);
        String category = getIntent().getStringExtra("category");
        if (category != null) {
            txtcategory.setText(category);
        }
        //--------------------------------- dialog ---------------------------------
        dialog = new Dialog(main_play_quiz.this);
        dialog.setContentView(R.layout.dialog_out_quiz);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.incomple));
        dialog.setCancelable(false);

        btn_dialogHuy = dialog.findViewById(R.id.txtHuy);
        btn_dialogLuuThoat = dialog.findViewById(R.id.txtLuuVaThoat);


        btn_dialogHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_dialogLuuThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(main_play_quiz.this, MainScreen.class);
                startActivity(it);
                finish();
                Toast.makeText(main_play_quiz.this, "Đã luu thành công ", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });


        });

    }

    public void goToPreviousFragment() {
        int Item = viewPager_play_quiz.getCurrentItem();
        if (Item > 0) {
            viewPager_play_quiz.setCurrentItem(Item - 1);
        }
    }

    public void goToNextFragment() {
        int Item = viewPager_play_quiz.getCurrentItem();
        if (Item < adapter.getItemCount() - 1) {
            viewPager_play_quiz.setCurrentItem(Item + 1);
        }
    }


}

