package com.example.finalproject_test.screenfragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi.CategoriesAdapter;
import com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi.IQuestionCategoriesApi;
import com.example.finalproject_test.DATA.InterfaceAPI.RetrofitService;
import com.example.finalproject_test.DATA.Models.QuestionCategory;
import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.ViewModels.CategoriesVM.CategoriesViewModel;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SharedViewModel;
import com.example.finalproject_test.R;

import com.example.finalproject_test.activity_choose_mode;
import com.example.finalproject_test.createQuiz;
import com.example.finalproject_test.main_play_quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainscreen_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mainscreen_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btnChonTheLoai;
    ImageButton btnDiemDanh, btnThoat, btnThoat2, btnThoat3, itoProfile;
    AppCompatButton daA, daB, daC, daD;
    Dialog DiemDanh_dialog;
    Button btncauhoihangngay,choingaybtn, taocaudobtn, dapanDung;
    TextView tvtatcatheloai,ChaoUsername, tvTitle;
    private List<QuestionCategory> categoryList = new ArrayList<>();

    //mới thêm nè...)
    private List<QuestionCategory> fullCategoryList = new ArrayList<>(); // Danh sách đầy đủ
    private List<QuestionCategory> displayedCategoryList = new ArrayList<>(); // Danh sách hiển thị
    private boolean isExpanded = false; // Biến cờ theo dõi trạng thái mở rộng
    //...mới thêm nè)
    private CategoriesViewModel categoriesViewModel;


    private SharedViewModel<User> sharedViewModel;
    RecyclerView recyclerView;
    private ViewPager2 vp;
    private View view;
    ScrollView sv;
//    LinearLayout hidden;
CategoriesAdapter menuAdapter;

    public mainscreen_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mainscreen_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static mainscreen_fragment newInstance(String param1, String param2) {
        mainscreen_fragment fragment = new mainscreen_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        categoriesViewModel.getCategories().observe(mainscreen_fragment.this, categories -> {
            if(categories !=null && !categories.isEmpty()){

                for (QuestionCategory qc: categories
                ) {
//vd: gắn dữ liệu nhận về vào textview của UI nha ae: tvOK.setText(lv.getLevelName());
                    Log.d("vk123", "onCreate: "+qc.getCategoryName());
                }

            }
            else {
                Log.d("vk123", "onCreate: thể loại nhận về rỗng nha");
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        // Đặt LayoutManager
        fetchCategories();

    }
    private void fetchCategories() {
        IQuestionCategoriesApi api = RetrofitService.createInstanceCate();
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        // Thực hiện gọi API
        api.getCategories().enqueue(new Callback<List<QuestionCategory>>() {


            @Override
            public void onResponse(Call<List<QuestionCategory>> call, Response<List<QuestionCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
//mới thêm...)
                    fullCategoryList = response.body();
//...mới thêm)
                    // Gán dữ liệu cho adapter và hiển thị trong RecyclerView
//                    List<QuestionCategory> categories = response.body();
                    // Gán dữ liệu cho adapter và hiển thị trong RecyclerView
//                    menuAdapter = new CategoriesAdapter(categories);
//mới thêm...)
                    displayedCategoryList = new ArrayList<>(fullCategoryList.subList(0, Math.min(4, fullCategoryList.size())));
                    menuAdapter = new CategoriesAdapter(getContext(), displayedCategoryList);
                    recyclerView.setAdapter(menuAdapter);
                    setupExpandToggle();
//...mới thêm)

                } else {
                    Toast.makeText(getContext(), "Failed to load categories", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<QuestionCategory>> call, Throwable throwable) {
                Toast.makeText(getContext(), "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    //mới thêm...)
    private void setupExpandToggle() {
        tvtatcatheloai = getView().findViewById(R.id.TatCaTheLoai); // TextView trong XML

        tvtatcatheloai.setOnClickListener(v -> {
            if (isExpanded) {
                // Ẩn bớt, chỉ hiển thị 4 thể loại
                displayedCategoryList = new ArrayList<>(fullCategoryList.subList(0, Math.min(4, fullCategoryList.size())));
                tvtatcatheloai.setText("Tất cả ▼"); // Cập nhật text
            } else {
                // Hiển thị đầy đủ thể loại
                displayedCategoryList = new ArrayList<>(fullCategoryList);
                tvtatcatheloai.setText("Thu gọn ▲"); // Cập nhật text
            }

            isExpanded = !isExpanded; // Đổi trạng thái
            menuAdapter.updateData(displayedCategoryList); // Cập nhật adapter
        });
    }
//...mới thêm)




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mainscreen_fragment, container, false);
//        btnChonTheLoai= view.findViewById(R.id.TheThao);

        //==========================================ánh xạ======================================================//

        btnDiemDanh=view.findViewById(R.id.DiemDanh);
        btncauhoihangngay=view.findViewById(R.id.btnChoiHangNgay);
        tvTitle = view.findViewById(R.id.tvTitleCategories);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        menuAdapter = new CategoriesAdapter(categoryList);
        recyclerView.setAdapter(menuAdapter);
        fetchCategories();
        categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        observeCategories();

//        tvtatcatheloai=view.findViewById(R.id.TatCaTheLoai);


        choingaybtn=view.findViewById(R.id.btnChoiNgay);
        taocaudobtn=view.findViewById(R.id.btnTaoCauDo);
        dapanDung=view.findViewById(R.id.DapAn_B);

        itoProfile = view.findViewById(R.id.itoprofile);

        ChaoUsername = view.findViewById(R.id.Username);
        //==========================================load tự động======================================================//
        //User currentUser =  CurrentUserSesssion.getInstance().getUserCurrent();

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        sharedViewModel.getObjectMLD().observe(getViewLifecycleOwner(), data ->{
            ChaoUsername.setText("Chào "+data.getName()+" !");






        //==========================================các sự kiện======================================================//

        itoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ViewPager2 vpr = getActivity().findViewById(R.id.view_page);
               vpr.setCurrentItem(3);
            }
        });


//        tvtatcatheloai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(hidden.getVisibility()==View.GONE){
//                    tvtatcatheloai.setText("Thu gọn ▲");
//                    hidden.setVisibility(View.VISIBLE);
//                }
//                else {
//                    tvtatcatheloai.setText("Tất cả ▼");
//                    hidden.setVisibility(View.GONE);
//                }
//            }
//        });
        btnDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
        btncauhoihangngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup2();
            }
        });

        choingaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), main_play_quiz.class);
                startActivity(intent);
            }
        });
        taocaudobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), createQuiz.class);
                intent.putExtra("username",data.getUsername());
                startActivity(intent);
            }
        });
        });
        return view;

    }

    private void observeCategories() {
        categoriesViewModel.getCategories().observe(getViewLifecycleOwner(), categories -> {
            if (categories != null && !categories.isEmpty()) {

                for (QuestionCategory qc : categories) {
                    if (tvTitle != null) {
                        tvTitle.setText(qc.getCategoryName());

//                        int imageResId = getImageResIdByCategoryId(qc.getIdCategory()); // Lấy imageResId
//                        qc.setImageResId(imageResId);
//                        loadData();
                    }
                }
            } else {
                Log.d("vk123", "categories is empty or null");
            }
        });
    }

    // Phương thức ánh xạ idCategory sang imageResId
//    private int getImageResIdByCategoryId(int idCategory) {
//        switch (idCategory) {
//            case 1:
//                return R.raw.the_thao;
//            case 2:
//                return R.drawable.btn_easy_mode;
//            case 3:
//                return R.raw.van_hoc;
//            case 4:
//                return R.raw.lich_su;
//            case 5:
//                return R.raw.toan_hoc;
//            case 6:
//                return R.raw.am_thuc;
//            case 7:
//                return R.raw.cong_nghe;
//            case 8:
//                return R.raw.dia_ly;
//            case 9:
//                return R.raw.am_nhac;
//            case 10:
//                return R.raw.phim_anh;
//            case 11:
//                return R.raw.ngu_phap;
//            case 12:
//                return R.raw.do_vui;
//            default:
//                return R.raw.the_thao;
//        }
//    }


    //==========================================show popup======================================================//
    private void showPopup() {
        // Tạo Dialog mới
        Dialog dialog = new Dialog(requireActivity(), R.style.CustomDialog);

        // Đặt layout cho Dialog
        dialog.setContentView(R.layout.dailycheckin_popup);
        btnThoat=dialog.findViewById(R.id.Thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.gravity = Gravity.TOP;
        layoutParams.y = 10;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
    }
    //===========================================show popup 2=====================================================//
    //lưu trạng thái đã chơi dailyquiz chưa
    private boolean hasAnswered = false;
    private boolean lastAnswerCorrect = false;

    Dialog dialog2;
    private void showPopup2() {

        if(hasAnswered){
            showPopupTrueFalse(lastAnswerCorrect);
            return;
        }

        // Create a new Dialog using the context of the hosting activity
       dialog2 = new Dialog(requireActivity(), R.style.CustomDialog);

        // Set the layout for the Dialog
        dialog2.setContentView(R.layout.activity_dailyquiz_popup);
        btnThoat2 = dialog2.findViewById(R.id.dongcuaso);
        daA = dialog2.findViewById(R.id.DapAn_A);
        daB = dialog2.findViewById(R.id.DapAn_B);
        daD = dialog2.findViewById(R.id.DapAn_D);
        daC = dialog2.findViewById(R.id.DapAn_C);

        daA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupTrueFalse(false);
                dialog2.dismiss();
            }
        });
        daB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupTrueFalse(true);
                dialog2.dismiss();
            }
        });
        daC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupTrueFalse(false);
                dialog2.dismiss();
            }
        });
        daD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupTrueFalse(false);
                dialog2.dismiss();
            }
        });

        // Set the click listener to dismiss the dialog
        btnThoat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });

        // Set the window size and gravity
        dialog2.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams layoutParams = dialog2.getWindow().getAttributes();
        layoutParams.gravity = Gravity.TOP;
        layoutParams.y = 10;
        dialog2.getWindow().setAttributes(layoutParams);

        // Show the dialog
        dialog2.show();
    }
    //===========================================show popup true /false answer=====================================================//

    private void showPopupTrueFalse(boolean check){
        Dialog dialogTF = new Dialog(requireActivity(), R.style.CustomDialog);

        if (check){
            dialogTF.setContentView(R.layout.activity_popup_true_answer);
            hasAnswered=true;
            lastAnswerCorrect=true;
        }
        else {
            dialogTF.setContentView(R.layout.activity_popup_false_answer);
            hasAnswered=true;
            lastAnswerCorrect=false;
        }
        dialogTF.setCanceledOnTouchOutside(true);
        dialogTF.show();

        new Handler().postDelayed(() -> dialogTF.dismiss(),3000);
    }













    //===========================================show popup 3=====================================================//
//    private void showPopup3() {
//        // Create a new Dialog using the context of the hosting activity
//        if (dialog2 != null && dialog2.isShowing()) {
//            dialog2.dismiss();
//        }
//        Dialog dialog3 = new Dialog(requireActivity(), R.style.CustomDialog);
//        // Set the layout for the Dialog
//        dialog3.setContentView(R.layout.fragment_popup_true_answer_fragment);
//        btnThoat3 = dialog3.findViewById(R.id.Thoatt);
//
//        // Set the click listener to dismiss the dialog
//        btnThoat3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog3.dismiss();
//            }
//        });
//
//        // Set the window size and gravity
//        dialog3.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        WindowManager.LayoutParams layoutParams = dialog3.getWindow().getAttributes();
//        layoutParams.gravity = Gravity.TOP;
//        layoutParams.y = 10;
//        dialog3.getWindow().setAttributes(layoutParams);
//        // Show the dialog
//        dialog3.show();
//    }
}//end class