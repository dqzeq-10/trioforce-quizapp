package com.example.finalproject_test.createQuestions_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.finalproject_test.DATA.ViewModels.SharedVM.SQASharedViewModel;
import com.example.finalproject_test.R;
import com.example.finalproject_test.popup_warning_create_Quiz;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link create_Fragment_Ques1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class create_Fragment_Ques1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnNext;
    private EditText cauhoi,da1,da2,da3,da4;
    private CheckBox chb1,chb2,chb3,chb4;

    private SQASharedViewModel sqaSharedViewModel;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public create_Fragment_Ques1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment create_Fragment_Ques1.
     */
    // TODO: Rename and change types and number of parameters
    public static create_Fragment_Ques1 newInstance(String param1, String param2) {
        create_Fragment_Ques1 fragment = new create_Fragment_Ques1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create___ques1, container, false);


        sqaSharedViewModel = new ViewModelProvider(requireActivity()).get(SQASharedViewModel.class);


        cauhoi = view.findViewById(R.id.cauhoi1);

        da1 = view.findViewById(R.id.dapan1A);
        chb1 =view.findViewById(R.id.check1A);

        da2 = view.findViewById(R.id.dapan1B);
        chb2 = view.findViewById(R.id.check1B);

        da3 = view.findViewById(R.id.dapan1C);
        chb3= view.findViewById(R.id.check1C);

        da4 = view.findViewById(R.id.dapan1D);
        chb4 = view.findViewById(R.id.check1D);

        btnNext = view.findViewById(R.id.btnNext);




        // Xử lý sự kiện khi bấm nút "Tiếp tục"
        btnNext.setOnClickListener(v -> {

        popup_warning_create_Quiz.showWarningPopup(requireContext());
        });

        return view;
    }



}