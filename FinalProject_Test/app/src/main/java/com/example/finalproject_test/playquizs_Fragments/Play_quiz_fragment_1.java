package com.example.finalproject_test.playquizs_Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.finalproject_test.DATA.Models.Question;
import com.example.finalproject_test.R;
import com.example.finalproject_test.main_play_quiz;
import com.example.finalproject_test.popup_warning_play_Quiz;


public class Play_quiz_fragment_1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext, btnLuilai;
    private TextView txtCauhoi;
    private AppCompatButton da1, da2, da3, da4;
    private Question question;
    private static final String ARG_QUESTION = "arg_question";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  boolean  isAnswerSelected = false;

    public Play_quiz_fragment_1() {

    }

    public static Play_quiz_fragment_1 newInstance(String param1, String param2) {
        Play_quiz_fragment_1 fragment = new Play_quiz_fragment_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Play_quiz_fragment_1 receiveQuestion(Question question) {
        Play_quiz_fragment_1 playQuizFragment1 = new Play_quiz_fragment_1();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, question);
        playQuizFragment1.setArguments(args);
        return playQuizFragment1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = (Question) getArguments().getSerializable(ARG_QUESTION);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quiz_1, container, false);
        Log.d("PlayQuizFragment", "Fragment Play_quiz_fragment_1 has been created!");

        txtCauhoi = view.findViewById(R.id.txtCauhoi1);
        da1 = view.findViewById(R.id.btnDapAn_1A);
        da2 = view.findViewById(R.id.btnDapAn_1B);
        da3 = view.findViewById(R.id.btnDapAn_1C);
        da4 = view.findViewById(R.id.btnDapAn_1D);

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnNext = view.findViewById(R.id.btnTiepTuc);


        txtCauhoi.setText(question.getQuestionText());

        da1.setText(question.getAnswers().get(0).getAnswerText().toString());
        da1.setTag(question.getAnswers().get(0).isCorrect());
        Log.d("setTag", da1.getTag().toString());

        da2.setText(question.getAnswers().get(1).getAnswerText().toString());
        da2.setTag(question.getAnswers().get(1).isCorrect());
        Log.d("setTag", da2.getTag().toString());

        da3.setText(question.getAnswers().get(2).getAnswerText().toString());
        da3.setTag(question.getAnswers().get(2).isCorrect());
        Log.d("setTag", da3.getTag().toString());

        da4.setText(question.getAnswers().get(3).getAnswerText().toString());
        da4.setTag(question.getAnswers().get(3).isCorrect());
        Log.d("setTag", da4.getTag().toString());

        //xu ly su kien khi chon dap an
        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAnswerSelected) return;
            // lay id cua dap an duoc chon
                int selectedAnswerId = v.getId();
                //kiem tra dap an duoc chon co dung hay sai
            boolean isCorerct = checkAnswer(selectedAnswerId);
                Log.d("AnswerClick", "Selected Answer: " + selectedAnswerId + " Correct: " + isCorerct);

                if (isCorerct) {
                    // Cộng điểm khi trả lời đúng
                    if (getActivity() instanceof main_play_quiz) {
                        ((main_play_quiz) getActivity()).updateScore(10);  // Cộng 10 điểm
                    }
                }

                //thay doi mau sac cua dap an duoc chon
            changeAnswerButtonColor(selectedAnswerId, isCorerct);

            // cap nhap mau sac cua tab trong activity
                int tabIndex = 0;
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).setTabBackgroundColor(tabIndex, isCorerct);
                ((main_play_quiz) getActivity()).activeTab(tabIndex);  // Kích hoạt tab
            }

                isAnswerSelected = true;
                disableOtherAnswer(selectedAnswerId);
            }

        };

        da1.setOnClickListener(answerClickListener);
        da2.setOnClickListener(answerClickListener);
        da3.setOnClickListener(answerClickListener);
        da4.setOnClickListener(answerClickListener);

        // Xử lý sự kiện khi bấm nút "Tiếp tục"
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
        Button selectedButton = getView().findViewById(selectedAnswerId); // lay button duoc chon
        boolean isCorrect = (boolean) selectedButton.getTag();  // lay tag cua button va ep kieu thanh boolean
        return isCorrect;
    }

    private void changeAnswerButtonColor(int selectedAnswerId, boolean isCorrect) {
        Button selectedButton = getView().findViewById(selectedAnswerId);
        if (isCorrect) {
            selectedButton.setBackgroundResource(R.drawable.dung); // Đáp án đúng
        } else {
            selectedButton.setBackgroundResource(R.drawable.sai); // Đáp án sai
        }
    }
    private  void disableOtherAnswer(int selectedAnswerId) {
        if (selectedAnswerId != R.id.btnDapAn_1A) da1.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1B) da2.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1C) da3.setEnabled(false);
        if (selectedAnswerId != R.id.btnDapAn_1D) da4.setEnabled(false);
    }
}
