package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
public class main_play_quiz extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager_play_quiz;
    private ViewpagerAdapter_Play_Quiz adapter;
    Dialog dialog;
    TextView btn_dialogLuuThoat, btn_dialogHuy, txtLevel, txtcategory;
    private  int totalScore =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_play_quiz);

        tabLayout = findViewById(R.id.tabLayout_Play_Quiz);
        viewPager_play_quiz = findViewById(R.id.viewPager_Play_Quiz);



        // Set up adapter
        adapter = new ViewpagerAdapter_Play_Quiz(this);
        viewPager_play_quiz.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager_play_quiz, (tab, position) -> {
            tab.setText(String.valueOf(position + 1)); // Đặt số tab từ 1 đến 10
        }).attach();
// vo hieu hoa----------------------------------------------------------
        disableTabs();
        // Xử lý các nút Back và Dialog
        ImageButton btnBack = findViewById(R.id.imagebtnBack);
        btnBack.setOnClickListener(view -> dialog.show());

        // Truyền dữ liệu cho Level và Category
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
    }

    //---------------------------------------------------------------------------------------


    // Vô hiệu hóa các tab
    private void disableTabs() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.view.setEnabled(false);
            }
        }
    }
    public void goToPreviousFragment() {
        int item = viewPager_play_quiz.getCurrentItem();
        if (item > 0) {
            viewPager_play_quiz.setCurrentItem(item - 1);
        }
    }

    public void goToNextFragment() {
        int item = viewPager_play_quiz.getCurrentItem();
        if (item < adapter.getItemCount() - 1) {
            viewPager_play_quiz.setCurrentItem(item + 1);
        }
    }

   public void setTabBackgroundColor(int tabIndex, boolean isCorrect) {
        TabLayout.Tab tab = tabLayout.getTabAt(tabIndex);
        if (tab != null) {
            // Tao drawable co nen va duong vien
            GradientDrawable drawable = new GradientDrawable(); // GradientDrawable là lớp để tạo hình dạng
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setCornerRadius(20);

            if (isCorrect) {
                drawable.setColor(Color.parseColor("#5EFF3A")); // Màu nền xanh nếu đúng
                drawable.setStroke(5, Color.parseColor("#008000"));
            } else {
                drawable.setColor(Color.parseColor("#EC3838")); // Màu nền đỏ nếu sai
                drawable.setStroke(5, Color.parseColor("#8B0000")); // Đặt đường viền màu đỏ đậm
            }
            tab.view.setBackground(drawable);
        }
    }

// cap nhap diem tu cac fragment
    public void updateScore(int score) {
        Log.d("ScoreUpdate", "Current Score: " + score + ", Adding Points: " + score); // In ra log

        totalScore += score;
    }
    public void goToResult() {
        Intent intent = new Intent(main_play_quiz.this, Result.class);
        intent.putExtra("totalScore", totalScore );  // Truyền điểm từ biến score vào Intent
        startActivity(intent);
    }

}

