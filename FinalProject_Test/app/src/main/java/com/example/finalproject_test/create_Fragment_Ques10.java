package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link create_Fragment_Ques10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class create_Fragment_Ques10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnLuilai, btnfinish;

    public create_Fragment_Ques10() {
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
    public static create_Fragment_Ques10 newInstance(String param1, String param2) {
        create_Fragment_Ques10 fragment = new create_Fragment_Ques10();
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
        View view = inflater.inflate(R.layout.fragment_create___ques10, container, false);

        btnLuilai = view.findViewById(R.id.btnLuiLai);
        btnfinish = view.findViewById(R.id.btnFinish);



        // Xử lý sự kiện khi bấm nút "Lui lại"
        btnLuilai.setOnClickListener(v -> {
            if (getActivity() instanceof main_create_quiz) {
                ((main_create_quiz) getActivity()).goToPreviousFragment();
            }
        });


        btnfinish.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), MainScreen.class);
            startActivity(intent);
            if (getActivity() != null) {
                getActivity().finish(); // Đóng Activity hiện tại
            }
        });

        return view;
    }
}