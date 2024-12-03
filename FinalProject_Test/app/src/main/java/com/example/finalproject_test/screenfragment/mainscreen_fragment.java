package com.example.finalproject_test.screenfragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
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

import com.example.finalproject_test.DATA.Models.User;
import com.example.finalproject_test.DATA.ViewModels.SharedVM.SharedViewModel;
import com.example.finalproject_test.R;

import com.example.finalproject_test.activity_choose_mode;
import com.example.finalproject_test.createQuiz;
import com.example.finalproject_test.main_play_quiz;

import java.util.concurrent.atomic.AtomicReference;

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
    TextView tvtatcatheloai,tvthethao,tvkhoahoc, tvvanhoc, tvlichsu, tvtoanhoc, tvamthuc, tvcongnghe, tvdiali, tvamnhac, tvphimanh, tvnguphap, tvdovui;
    TextView ChaoUsername;

    private SharedViewModel<User> sharedViewModel;

    private ViewPager2 vp;
    private View view;
    ScrollView sv;
    LinearLayout hidden;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mainscreen_fragment, container, false);
//        btnChonTheLoai= view.findViewById(R.id.TheThao);

        //==========================================ánh xạ======================================================//

        btnDiemDanh=view.findViewById(R.id.DiemDanh);
        btncauhoihangngay=view.findViewById(R.id.btnChoiHangNgay);

        tvtatcatheloai=view.findViewById(R.id.TatCaTheLoai);

        tvthethao=view.findViewById(R.id.txtTheThao);
        tvkhoahoc=view.findViewById(R.id.txtKhoaHoc);
        tvvanhoc=view.findViewById(R.id.txtVanHoc);
        tvlichsu=view.findViewById(R.id.txtLichSu);
        tvtoanhoc=view.findViewById(R.id.txtToanHoc);
        tvamthuc=view.findViewById(R.id.txtAmThuc);
        tvcongnghe=view.findViewById(R.id.txtCongNghe);
        tvdiali=view.findViewById(R.id.txtDialy);
        tvamnhac=view.findViewById(R.id.txtAmNhac);
        tvphimanh=view.findViewById(R.id.txtPhimAnh);
        tvnguphap=view.findViewById(R.id.txtNguPhap);
        tvdovui=view.findViewById(R.id.txtDoVui);

        hidden=view.findViewById(R.id.hiddenTheLoai);
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

        tvthethao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Thể thao");
                intent.putExtra("idCategory",1);
                startActivity(intent);
            }
        });
        tvkhoahoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Khoa học");
                intent.putExtra("idCategory",2);
                startActivity(intent);
            }
        });
        tvvanhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Văn học");
                intent.putExtra("idCategory",3);
                startActivity(intent);
            }
        });
        tvlichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Lịch sử");
                intent.putExtra("idCategory",4);
                startActivity(intent);
            }
        });
        tvtoanhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Toán học");
                intent.putExtra("idCategory",5);
                startActivity(intent);
            }
        });
        tvamthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Ẩm thực");
                intent.putExtra("idCategory",6);
                startActivity(intent);
            }
        });
        tvcongnghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Công nghệ");
                intent.putExtra("idCategory",7);
                startActivity(intent);
            }
        });
        tvdiali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Địa lý");
                intent.putExtra("idCategory",8);
                startActivity(intent);
            }
        });
        tvamnhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Âm nhạc");
                intent.putExtra("idCategory",9);
                startActivity(intent);
            }
        });
        tvphimanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Phim ảnh");
                intent.putExtra("idCategory",10);
                startActivity(intent);
            }
        });
        tvnguphap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Ngữ pháp");
                intent.putExtra("idCategory",11);
                startActivity(intent);
            }
        });
        tvdovui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_choose_mode.class);
                intent.putExtra("category","Đố vui");
                intent.putExtra("idCategory",12);
                startActivity(intent);
            }
        });

        tvtatcatheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hidden.getVisibility()==View.GONE){
                    tvtatcatheloai.setText("Thu gọn ▲");
                    hidden.setVisibility(View.VISIBLE);
                }
                else {
                    tvtatcatheloai.setText("Tất cả ▼");
                    hidden.setVisibility(View.GONE);
                }
            }
        });
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