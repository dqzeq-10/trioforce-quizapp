package com.example.finalproject_test;


import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalproject_test.DATA.Models.Answer;
import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.Repository.CurrentUserSesssion;
import com.example.finalproject_test.DATA.ViewModels.CategoriesVM.CategoriesViewModel;
import com.example.finalproject_test.DATA.ViewModels.QuestionSetsVM.QuestionSetsViewModel;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SharedViewModel;
import com.example.finalproject_test.screenfragment.ViewPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainScreen extends AppCompatActivity {

    private ViewPager2 vp;
    private BottomNavigationView bnv;
    private SharedViewModel<User> sharedViewModel;
    private QuestionSetsViewModel setsViewModel;
    private CategoriesViewModel categoriesViewModel;
    TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //lấy thông tin của user đang đăng nhập
        User currentUser =  CurrentUserSesssion.getInstance().getUserCurrent();
        //tạo biến chứa thông tin của user đang đăng nhập để dùng chung cho toàn bộ quá trình đăng nhập
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        sharedViewModel.setObjectMLD(currentUser);


        vp = findViewById(R.id.view_page);
        bnv = findViewById(R.id.menu_bar);

        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                bnv.getMenu().getItem(position).setChecked(true);
            }
        });

        ViewPageAdapter vpa = new ViewPageAdapter(this);
        vp.setAdapter(vpa);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bnv.getMenu().findItem(R.id.menu_home).setCheckable(true);
                        break;
                    case 1:
                        bnv.getMenu().findItem(R.id.menu_cup).setCheckable(true);
                        break;
                    case 2:
                        bnv.getMenu().findItem(R.id.menu_bookmark).setCheckable(true);
                        break;
                    case 3:
                        bnv.getMenu().findItem(R.id.menu_user).setCheckable(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_home) {
                    vp.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.menu_cup) {
                    vp.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.menu_bookmark) {
                    vp.setCurrentItem(2);
                    return true;
                } else if (item.getItemId() == R.id.menu_user) {
                    vp.setCurrentItem(3);
                    return true;
                }
                return false;
            }
        });


        setsViewModel = new ViewModelProvider(this).get(QuestionSetsViewModel.class);
        setsViewModel.getSetByIdLevelAndIdCate(1,1).observe(this, data->{
            if (data!=null){
                for (Question qs:data.getQuestions()
                     ) {
                    Log.d("goisetbyidlevelcate", qs.getQuestionText());

                }
            }else {
                Log.d("goisetbyidlevelcate", "data null");
            }

        });

//        IUsersApi iUsersApi = RetrofitService.CreateInstanceU();
//        Call<List<User>> call = iUsersApi.getUsers();
//        call.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                if (response.isSuccessful()) {
//                    List<User> users = response.body();
//                    if (users != null && !users.isEmpty()) {
//                        for (User us : users
//                        ) {
//                            Log.d("dq10", "name: " + us.getName());
//                        }
//
//                    } else {
//                        Log.d("dq10", "k lay dc du lieu, rong") ;
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable throwable) {
//                Log.e("dq10", "onFailure: loigoi api");
//            }
//        });
//        UsersApiManager usersApiManager = MainApplication.usersApiManager;
////        //Khởi tạo  UVMfactory

     //   test chuẩn
//        UsersViewModelFactory UVMfactory = new UsersViewModelFactory();
//
//        //Khởi tạo usersViewModel với ViewModelProvider (tham số là this và UVMfactory).get(UsersViewModel.class)
//        UsersViewModel usersViewModel = new ViewModelProvider(this,UVMfactory).get(UsersViewModel.class);
//
//        //Gọi api để nhận dữ liệu
//        try {
//            usersViewModel.getUsers().observe(this, users -> {
//                try {
//                    if (users != null && !users.isEmpty()){
//                        for (User us: users) {
//                            Log.d("dq123", "username " + us.getUsername()+us.isSex());
//                        }
//
//                    }
//                    else{
//                        Log.d("dq123","du lieu rong");
//                    }
//                }catch (Exception e){
//                    Log.d("dq123","loi"+e.getMessage());
//                }
//
//
//            });
//
//        }catch (Exception e){
//            Log.e("dq123","Lỗi: " + e.getMessage());
//        }


    }
}

