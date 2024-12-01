package com.example.finalproject_test.playquizs_Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.finalproject_test.R;
import com.example.finalproject_test.Result;
import com.example.finalproject_test.main_play_quiz;
import com.example.finalproject_test.popup_warning_play_Quiz;


public class Play_quiz_fragment_10 extends Fragment {
    private Dialog dialog;
    private Button btnKetThuc, btnNext, btnLuilai;
    private TextView btnDapAn_10A, btnDapAn_10B, btnDapAn_10C, btnDapAn_10D;
    private  boolean  isAnswerSelected = false;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_10() {
        // Constructor mặc định
    }

    public static Play_quiz_fragment_10 newInstance(String param1, String param2) {
        Play_quiz_fragment_10 fragment = new Play_quiz_fragment_10();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_10, container, false);

        // Khởi tạo các nút
        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnKetThuc = view.findViewById(R.id.btnFinish);
        
        btnDapAn_10A = view.findViewById(R.id.btnDapAn_10A);
        btnDapAn_10B = view.findViewById(R.id.btnDapAn_10B);
        btnDapAn_10C = view.findViewById(R.id.btnDapAn_10C);
        btnDapAn_10D = view.findViewById(R.id.btnDapAn_10D);

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAnswerSelected) return;
                // lay id cua dap an duoc chon
                int selectedAnswerId = v.getId();
                //kiem tra dap an duoc chon co dung hay sai
                boolean isCorerct = checkAnswer(selectedAnswerId);

                //thay doi mau sac cua dap an duoc chon
                changeAnswerButtonColor(selectedAnswerId, isCorerct);

                if (isCorerct){
                    if (getActivity() instanceof main_play_quiz) {
                        ((main_play_quiz) getActivity()).updateScore(10);  // Cộng 10 điểm
                    }
                }
                //thay doi mau sac cua dap an duoc chon
                changeAnswerButtonColor(selectedAnswerId, isCorerct);

                // cap nhap mau sac cua tab trong activity
                int tabIndex = 9;
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).setTabBackgroundColor(tabIndex, isCorerct);

                }
                isAnswerSelected = true;
                disableOtherAnswer(selectedAnswerId);
            }

        };

        btnDapAn_10A.setOnClickListener(answerClickListener);
        btnDapAn_10B.setOnClickListener(answerClickListener);
        btnDapAn_10C.setOnClickListener(answerClickListener);
        btnDapAn_10D.setOnClickListener(answerClickListener);


    


        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToPreviousFragment();
            }
        });
        

        // Xử lý sự kiện khi nhấn nút "Kết thúc" (chuyển sang màn hình kết quả)
        btnKetThuc.setOnClickListener(view1 -> {
            if(!isAnswerSelected){
                popup_warning_play_Quiz.showWarningPopup(requireContext());
            }
            else {
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).goToResult();  // Gọi phương thức goToResult
                }
            }
        });
        return view;
    }
    private boolean checkAnswer(int selectedAnswerId) {
        return selectedAnswerId == R.id.btnDapAn_10A;
    }
    private  void changeAnswerButtonColor(int selectedAnswerId, boolean isCorrect) {
        TextView selectedButton = getView().findViewById(selectedAnswerId);
        if (isCorrect) {
            selectedButton.setBackgroundResource(R.drawable.dung);
        } else {
            selectedButton.setBackgroundResource(R.drawable.sai);
        }
    }
    private  void disableOtherAnswer(int selectedAnswerId) {
        if (selectedAnswerId != R.id.btnDapAn_1A) btnDapAn_10A.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1B) btnDapAn_10B.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1C) btnDapAn_10C.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1D) btnDapAn_10D.setEnabled(false);
    }

}
