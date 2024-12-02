/*package com.example.finalproject_test.playquizs_Fragments;

import android.os.Bundle;
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


public class Play_quiz_fragment_Default extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext, btnLuilai;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Play_quiz_fragment_Default() {
        // Required empty public constructor
    }


    public static Play_quiz_fragment_Default newInstance(String param1, String param2) {
        Play_quiz_fragment_Default fragment = new Play_quiz_fragment_Default();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_quizdefault, container, false);



        btnLuilai = view.findViewById(R.id.btnLuiLaidf);
        btnNext = view.findViewById(R.id.btnTiepTucdf);


        // Xử lý sự kiện khi bấm nút "Tiếp tục"
        btnNext.setOnClickListener(v -> {
            // Gọi phương thức từ Activity để chuyển đến Fragment tiếp theo
            if (getActivity() instanceof main_play_quiz) {
                ((main_play_quiz) getActivity()).goToNextFragment();
            }
        });

        return view;
    }


}*/