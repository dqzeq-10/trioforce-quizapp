
package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject_test.DATA.Models.Level;
import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.CurrentUserSesssion;
import com.example.finalproject_test.DATA.ViewModels.LevelsVM.LevelsViewModel;
import com.example.finalproject_test.DATA.ViewModels.LoginVM.LoginViewModel;
import com.example.finalproject_test.DATA.ViewModels.UsersVM.UsersViewModel;

public class activity_choose_mode extends AppCompatActivity {
    ImageButton btnVeManHinhChinh;
    AppCompatButton cdde,cdbthg,cdkho;
    UsersViewModel usersViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_mode);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cdde =findViewById(R.id.CheDoDe);
        cdbthg =findViewById(R.id.CheDoBinhThuong);
        cdkho =findViewById(R.id.CheDoKho);
        btnVeManHinhChinh=(ImageButton) findViewById(R.id.TroVeManHinhChinh);
        User currentUser =  CurrentUserSesssion.getInstance().getUserCurrent();


        //(mới thêm nè...
        int idTheLoai = getIntent().getIntExtra("ID_THE_LOAI", -1); // -1 nếu không có dữ liệu
        String tenTheLoai = getIntent().getStringExtra("TEN_THE_LOAI");
        Log.d("ChooseModeActivity", "ID Thể Loại: " + idTheLoai);
        Log.d("ChooseModeActivity", "Tên Thể Loại: " + tenTheLoai);
        //...mới thêm nè)

        btnVeManHinhChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_choose_mode.this, MainScreen.class);
                startActivity(intent);
            }
        });

        LevelsViewModel levelsViewModel = new ViewModelProvider(this).get(LevelsViewModel.class);
        // Quan sát LiveData
        levelsViewModel.getLevels().observe(this, levels -> {
            if (levels != null) {
                for (Level level : levels) {
                    if (level.getIdLevels() == 1) {
                        cdde.setText(level.getLevelName());
                    } else if (level.getIdLevels() == 2) {
                        cdbthg.setText(level.getLevelName());
                    } else if (level.getIdLevels() == 3) {
                        cdkho.setText(level.getLevelName());
                    }
                }
            } else {
                Toast.makeText(this, "Failed to load levels", Toast.LENGTH_SHORT).show();
            }
        });





        cdde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ChooseMode", "Button Easy clicked");
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
//                int idCategory = getIntent().getIntExtra("idCategory",-1);
//                String category = getIntent().getStringExtra("category");

                int idCategory = getIntent().getIntExtra("ID_THE_LOAI", -1); // -1 nếu không có dữ liệu
                String category = getIntent().getStringExtra("TEN_THE_LOAI");
                Log.d("ChooseModeActivity", "ID Thể Loại: " + idTheLoai);
                Log.d("ChooseModeActivity", "Tên Thể Loại: " + tenTheLoai);

                if (category == null || idCategory == -1) {
                    Log.e("main_play_quiz", "Thiếu dữ liệu Intent: category hoặc idCategory");
                    return;
                }
                Log.d("ChooseMode", "Category: " + category + ", idCategory: " + idCategory);
                if (category != null) {
                    intent.putExtra("category", category);
                    intent.putExtra("idCategory",idCategory);
                }else
                {
                    Log.d("error", "onClick: cdde category bi null");
                }
                intent.putExtra("level","Dễ");
                intent.putExtra("idLevel",1);
                intent.putExtra("username", currentUser.getUsername());
                startActivity(intent);
            }
        });
        cdbthg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("TEN_THE_LOAI");
                int idCategory = getIntent().getIntExtra("ID_THE_LOAI",1);
                if (category == null || idCategory == -1) {
                    Log.e("main_play_quiz", "Thiếu dữ liệu Intent: category hoặc idCategory");
                    return;
                }
                if (category != null) {
                    intent.putExtra("category", category);
                    intent.putExtra("idCategory",idCategory);
                }
                intent.putExtra("level","Thường");
                intent.putExtra("idLevel",2);
                intent.putExtra("username", currentUser.getUsername());
                startActivity(intent);
            }
        });
        cdkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_choose_mode.this, main_play_quiz.class );
                String category = getIntent().getStringExtra("TEN_THE_LOAI");
                int idCategory = getIntent().getIntExtra("ID_THE_LOAI",1);
                if (category != null) {
                    intent.putExtra("category", category);
                    intent.putExtra("idCategory",idCategory);
                }
                intent.putExtra("level","Khó");
                intent.putExtra("idLevel",3);
                intent.putExtra("username", currentUser.getUsername());
                startActivity(intent);
            }
        });

    }
}
