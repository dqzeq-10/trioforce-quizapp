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

import com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi.CategoriesAdapter;
import com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi.IQuestionCategoriesApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RankingApi.IRankingApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.AnsweredQuestion;
import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.Models.QuestionCategory;
import com.example.finalproject_test.DATA.Models.Ranking;
import com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM.QuestionSetsViewModel;
import com.example.finalproject_test.DATA.ViewModels.RanksVM.RanksViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class main_play_quiz extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager_play_quiz;
    private ViewpagerAdapter_Play_Quiz adapter;
    Dialog dialog;
    TextView btn_dialogLuuThoat, btn_dialogHuy, txtLevel, txtcategory;
    QuestionSetsViewModel setsViewModel;
    private int totalScore = 0;
    RanksViewModel ranksViewModel;
    String user;
    Ranking ranking;
    int point=0;
    private Boolean isNewPlay;



    public void startNewGame() {
        point = 0; // Reset điểm phiên chơi
        Log.d("GameStart", "Game started, point reset to 0.");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_play_quiz);



        // Kiểm tra xem user có giá trị hợp lệ không
        if (user == null) {
            Log.e("main_play_quiz", "User ID is null");
        }
        ranksViewModel = new ViewModelProvider(this).get(RanksViewModel.class);

        startNewGame();

        viewPager_play_quiz = findViewById(R.id.viewPager_Play_Quiz);
        tabLayout = findViewById(R.id.tabLayout_Play_Quiz);
        isNewPlay = getIntent().getBooleanExtra("isNewPlay", false);

        user = getIntent().getStringExtra("username");
        if (isNewPlay) {
        // Nhận idCategory, idLevel từ Intent
        int idCate = getIntent().getIntExtra("idCategory", 1);
        int idLevel = getIntent().getIntExtra("idLevel", 1);

        // Khởi tạo ViewModel
        setsViewModel = new ViewModelProvider(this).get(QuestionSetsViewModel.class);
        setsViewModel.getSetByIdLevelAndIdCate(idLevel, idCate).observe(this, set -> {
            if (set != null && set.getQuestions() != null) {
                // Set adapter chỉ khi có dữ liệu
                adapter = new ViewpagerAdapter_Play_Quiz(this, set.getQuestions());
                viewPager_play_quiz.setAdapter(adapter);

                new TabLayoutMediator(tabLayout, viewPager_play_quiz, (tab, position) -> {
                    tab.setText(String.valueOf(position + 1)); // Đặt số tab từ 1 đến 10
                }).attach();
                disableTabs();
            } else {
                Log.e("main_play_quiz", "Dữ liệu câu hỏi rỗng hoặc không hợp lệ");
            }
        });

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
    public  void activeTab(int tabIndex){
        TabLayout.Tab tab =tabLayout.getTabAt(tabIndex);
        if (tab!=null){
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
//    public void updateScore(int score) {
//        Log.d("ScoreUpdate", "Current Score: " + totalScore + ", Adding Points: " + score);
//        totalScore += score;
//        Ranking ranking = new Ranking(user,totalScore);
//        ranking.setPoint(totalScore); // Assuming 'setScore' method exists in Ranking class to set the score
//        ranksViewModel.updateScore(user, ranking);
//    }
//    public void updateScore(int score) {
//        Log.d("ScoreUpdate", "Current Score: " + totalScore + ", Adding Points: " + score);
//
//        // Cộng thêm điểm vào tổng điểm
//        totalScore += score;
//
//        // Cập nhật điểm vào ViewModel
//        ranksViewModel.updateScore(user, score).observe(this, ranking -> {
//            if (ranking != null) {
//                // Khi điểm đã được cập nhật thành công, bạn có thể làm gì đó với đối tượng ranking, ví dụ:
//                totalScore = ranking.getPoint();  // Cập nhật lại điểm hiện tại
//                Log.d("UpdatedScore", "Updated Total Score: " + totalScore);
//            }
//        });
//    }

    public void updateScore(int score) {
//        Log.d("ScoreUpdate", "Current Score: " + totalScore + ", Adding Points: " + score);
//        totalScore += score;
//        Ranking ranking = new Ranking(user, totalScore);
//        Log.d("UserCheck", "Username: " + ranking.getUsername());
//        ranksViewModel.putRank(user, ranking).observe(this, success -> {
//            if (success != null && success) {
//
//                Log.d("UpdatedScore", "Updated Total Score: " + totalScore);
//            } else {
//                Log.e("UpdateScore", "Failed to update score.");
//            }
//        });
        // Lấy điểm hiện tại từ hệ thống (Ví dụ từ ViewModel hoặc dữ liệu đã lưu trữ)
        Log.d("ScoreUpdate", "Current Score: " + totalScore + ", Adding Points: " + score);
        point+=score;
        ranksViewModel.getRankById(user).observe(this, ranking -> {
            if (ranking != null) {
                // Lấy điểm hiện tại của người dùng và cộng thêm điểm mới
                int currentScore = ranking.getPoint();  // Giả sử 'getPoint()' là phương thức lấy điểm

                totalScore = currentScore + score;


                // Tạo đối tượng Ranking với điểm mới
                Ranking updatedRanking = new Ranking(user, totalScore);
                Log.d("UserCheck", "Username: " + updatedRanking.getUsername());

                // Cập nhật điểm vào ViewModel
                ranksViewModel.putRank(user, updatedRanking).observe(this, success -> {
                    if (success != null && success) {
                        Log.d("UpdatedScore", "Updated Total Score: " + totalScore);
                    } else {
                        Log.e("UpdateScore", "Failed to update score.");
                    }
                });
            } else {
                Log.e("UpdateScore", "Ranking not found for user.");
            }
        });// Lấy điểm hiện tại từ hệ thống (Ví dụ từ ViewModel hoặc dữ liệu đã lưu trữ)

    }

    // Chuyển đến màn hình kết quả
    public void goToResult() {
        Intent intent = new Intent(main_play_quiz.this, Result.class);
        intent.putExtra("addscore", point);  // Truyền điểm vào Intent

        startActivity(intent);
    }

}
