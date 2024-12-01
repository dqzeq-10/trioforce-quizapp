package com.example.finalproject_test.playquizs_Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.finalproject_test.R;
import com.example.finalproject_test.main_play_quiz;
import com.example.finalproject_test.popup_warning_play_Quiz;


public class Play_quiz_fragment_7 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext, btnLuilai;
    private TextView btnDapAn_7A, btnDapAn_7B, btnDapAn_7C, btnDapAn_7D;
    private  boolean  isAnswerSelected = false;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_7() {

    }

    public static Play_quiz_fragment_7 newInstance(String param1, String param2) {
        Play_quiz_fragment_7 fragment = new Play_quiz_fragment_7();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_7, container, false);

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnNext = view.findViewById(R.id.btnTiepTuc);
        btnDapAn_7A = view.findViewById(R.id.btnDapAn_7A);
        btnDapAn_7B = view.findViewById(R.id.btnDapAn_7B);
        btnDapAn_7C = view.findViewById(R.id.btnDapAn_7C);
        btnDapAn_7D = view.findViewById(R.id.btnDapAn_7D);

        //xu ly su kien khi chon dap an
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
                int tabIndex = 6;
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).setTabBackgroundColor(tabIndex, isCorerct);

                }
                isAnswerSelected = true;
                disableOtherAnswer(selectedAnswerId);
            }

        };

        btnDapAn_7A.setOnClickListener(answerClickListener);
        btnDapAn_7B.setOnClickListener(answerClickListener);
        btnDapAn_7C.setOnClickListener(answerClickListener);
        btnDapAn_7D.setOnClickListener(answerClickListener);




        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToPreviousFragment();
            }
        });

        btnNext.setOnClickListener(v -> {
            if(!isAnswerSelected){
                popup_warning_play_Quiz.showWarningPopup(requireContext());
            }
            else {
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).goToNextFragment();
                }
            }
        });

        return view;
    }
    private boolean checkAnswer(int selectedAnswerId) {
        return selectedAnswerId == R.id.btnDapAn_7A;
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
        if (selectedAnswerId != R.id.btnDapAn_1A) btnDapAn_7A.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1B) btnDapAn_7B.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1C) btnDapAn_7C.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1D) btnDapAn_7D.setEnabled(false);
    }

}