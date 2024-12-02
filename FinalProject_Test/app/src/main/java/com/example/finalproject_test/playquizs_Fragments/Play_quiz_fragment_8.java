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


public class Play_quiz_fragment_8 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext, btnLuilai;
    private TextView da1, da2, da3, da4;
    private  boolean  isAnswerSelected = false;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_8() {

    }

    public static Play_quiz_fragment_8 newInstance(String param1, String param2) {
        Play_quiz_fragment_8 fragment = new Play_quiz_fragment_8();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_8, container, false);

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnNext = view.findViewById(R.id.btnTiepTuc);
        da1 = view.findViewById(R.id.btnDapAn_8A);
        da2 = view.findViewById(R.id.btnDapAn_8B);
        da3 = view.findViewById(R.id.btnDapAn_8C);
        da4 = view.findViewById(R.id.btnDapAn_8D);

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
                        ((main_play_quiz) getActivity()).updateScore(10);
                    }
                }

                changeAnswerButtonColor(selectedAnswerId, isCorerct);

                // cap nhap mau sac cua tab trong activity
                int tabIndex = 7;
                if (getActivity() instanceof main_play_quiz) {
                    ((main_play_quiz) getActivity()).setTabBackgroundColor(tabIndex, isCorerct);

                }
                isAnswerSelected = true;
                disableOtherAnswer(selectedAnswerId);
            }

        };

        da1.setOnClickListener(answerClickListener);
        da2.setOnClickListener(answerClickListener);
        da3.setOnClickListener(answerClickListener);
        da4.setOnClickListener(answerClickListener);




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
        return selectedAnswerId == R.id.btnDapAn_8A;
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
        if (selectedAnswerId != R.id.btnDapAn_1A) da1.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1B) da2.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1C) da3.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1D) da4.setEnabled(false);
    }

}