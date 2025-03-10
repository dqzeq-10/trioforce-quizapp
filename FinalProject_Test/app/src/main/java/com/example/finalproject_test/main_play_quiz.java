package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalproject_test.DATA.Models.AnsweredQuestion;
import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM.QuestionSetsViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class main_play_quiz extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager_play_quiz;
    private ViewpagerAdapter_Play_Quiz adapter;
    Dialog dialog;
    TextView btn_dialogLuuThoat, btn_dialogHuy, txtLevel, txtcategory;
    QuestionSetsViewModel setsViewModel;
    private int totalScore = 0;
    private Boolean isNewPlay;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_play_quiz);

        viewPager_play_quiz = findViewById(R.id.viewPager_Play_Quiz);
        tabLayout = findViewById(R.id.tabLayout_Play_Quiz);

        // Nhận idCategory, idLevel, isNewPlay(xac dinh choi new hay choi tiep) từ Intent
        isNewPlay = getIntent().getBooleanExtra("isNewPlay", false);
        username = getIntent().getStringExtra("username");
        if (isNewPlay) {
            // Truyền dữ liệu cấp độ và thể loại
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
            int idCate = getIntent().getIntExtra("idCategory", 1);
            int idLevel = getIntent().getIntExtra("idLevel", 1);
            // Khởi tạo ViewModel
            setsViewModel = new ViewModelProvider(this).get(QuestionSetsViewModel.class);
            setsViewModel.getSetByIdLevelAndIdCate(idLevel, idCate).observe(this, set -> {
                if (set != null && set.getQuestions() != null) {
                    // Set adapter chỉ khi có dữ liệu
                    adapter = new ViewpagerAdapter_Play_Quiz(this, set.getQuestions(),idCate, idLevel, category, level, isNewPlay,username); //bỏ null answered ra
                    viewPager_play_quiz.setAdapter(adapter);

                    new TabLayoutMediator(tabLayout, viewPager_play_quiz, (tab, position) -> {
                        tab.setText(String.valueOf(position + 1)); // Đặt số tab từ 1 đến 10
                    }).attach();
                    disableTabs();
                } else {
                    Log.e("main_play_quiz", "Dữ liệu câu hỏi rỗng hoặc không hợp lệ");
                }
            });


                    //end if(isNewPlay)
        } else { //nhận chơi tiếp tục
            ArrayList<Question> questionsP = (ArrayList<Question>) getIntent().getSerializableExtra("setquestionP");
            ArrayList<AnsweredQuestion> answeredP = (ArrayList<AnsweredQuestion>) getIntent().getSerializableExtra("answeredsP");

            adapter = new ViewpagerAdapter_Play_Quiz(this, questionsP, answeredP);
            viewPager_play_quiz.setAdapter(adapter);

            new TabLayoutMediator(tabLayout, viewPager_play_quiz, (tab, position) -> {
                tab.setText(String.valueOf(position + 1)); // Đặt số tab từ 1 đến 10
            }).attach();
            disableTabs();
        }

        // Dialog khi thoát quiz
        dialog = new Dialog(main_play_quiz.this);
        dialog.setContentView(R.layout.dialog_out_quiz);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.incomple));
        dialog.setCancelable(false);

        btn_dialogHuy = dialog.findViewById(R.id.txtHuy);
        btn_dialogLuuThoat = dialog.findViewById(R.id.txtLuuVaThoat);

        btn_dialogHuy.setOnClickListener(view -> dialog.dismiss());

        btn_dialogLuuThoat.setOnClickListener(view -> {
            Intent it = new Intent(main_play_quiz.this, MainScreen.class);
            startActivity(it);
            finish();
            Toast.makeText(main_play_quiz.this, "Đã lưu thành công", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        });

        // Xử lý nút quay lại
        ImageButton btnBack = findViewById(R.id.imagebtnBack);
        btnBack.setOnClickListener(view -> dialog.show());
    }

    // Vô hiệu hóa các tab
    private void disableTabs() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.view.setEnabled(false);
            }
        }
        viewPager_play_quiz.setUserInputEnabled(false);  // Vô hiệu hóa vuốt

    }

    // kich hoat lai tab
    public void activeTab(int tabIndex) {
        TabLayout.Tab tab = tabLayout.getTabAt(tabIndex);
        if (tab != null) {
            tab.view.setEnabled(true);
        }


    }

    // Chuyển đến fragment trước đó
    public void goToPreviousFragment() {
        int item = viewPager_play_quiz.getCurrentItem();
        if (item > 0) {
            viewPager_play_quiz.setCurrentItem(item - 1);
        }
    }

    // Chuyển đến fragment tiếp theo
    public void goToNextFragment() {
        int item = viewPager_play_quiz.getCurrentItem();
        if (item < adapter.getItemCount() - 1) {
            viewPager_play_quiz.setCurrentItem(item + 1);
        }
    }

    // Thay đổi màu nền của tab
    public void setTabBackgroundColor(int tabIndex, boolean isCorrect) {
        TabLayout.Tab tab = tabLayout.getTabAt(tabIndex);
        if (tab != null) {
            // Tạo drawable với nền và đường viền
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setCornerRadius(20);

            if (isCorrect) {
                drawable.setColor(Color.parseColor("#5EFF3A")); // Màu nền xanh nếu đúng
                drawable.setStroke(5, Color.parseColor("#008000"));
            } else {
                drawable.setColor(Color.parseColor("#EC3838")); // Màu nền đỏ nếu sai
                drawable.setStroke(5, Color.parseColor("#8B0000")); // Đặt đường viền đỏ đậm
            }
            tab.view.setBackground(drawable);
        }
    }

    // Cập nhật điểm từ các fragment
    public void updateScore(int score) {
        Log.d("ScoreUpdate", "Current Score: " + totalScore + ", Adding Points: " + score);
        totalScore += score;

    }

    // Chuyển đến màn hình kết quả
    public void goToResult(int idCategory,int idLevel,String category,String level,Boolean isNewPlay) {
        Intent intent = new Intent(main_play_quiz.this, Result.class);
        intent.putExtra("totalScore", totalScore);  // Truyền điểm vào Intent
        intent.putExtra("idCategoryR", idCategory);
        intent.putExtra("idLevelR", idLevel);
        intent.putExtra("categoryR", category);
        intent.putExtra("levelR", level);
        intent.putExtra("isNewPlayR", isNewPlay);
        startActivity(intent);
    }
}
