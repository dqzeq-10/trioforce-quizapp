package com.example.finalproject_test.screenfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.finalproject_test.LeaderboardAdapter;
import com.example.finalproject_test.LeaderboardItem;
import com.example.finalproject_test.R;

import java.util.ArrayList;
import java.util.List;

public class leaderboard_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private LeaderboardAdapter adapter;
    private List<LeaderboardItem> LeaderboardItems;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public leaderboard_fragment() {
        // Required empty public constructor
    }


    public static leaderboard_fragment newInstance(String param1, String param2) {
        leaderboard_fragment fragment = new leaderboard_fragment();
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
        View view= inflater.inflate(R.layout.fragment_leaderboard_fragment, container, false);
        // anh xa recycleView
       recyclerView = view.findViewById(R.id.recyclerViewLeaderboard);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo danh sách dữ liệu mẫu
        LeaderboardItems = new ArrayList<>();
        LeaderboardItems.add(new LeaderboardItem(4, R.raw.useravatarbxh, "Quy2ngon", "100000000"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(4, R.raw.useravatarbxh, "DucDinhDac", "444444444444444"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));
        LeaderboardItems.add(new LeaderboardItem(2, R.raw.useravatarbxh, "KhanhKhuKho", "12121212"));

        // Gắn Adapter
        adapter = new LeaderboardAdapter(LeaderboardItems);
        recyclerView.setAdapter(adapter);


        return view;
    }
}

