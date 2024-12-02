package com.example.finalproject_test.screenfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalproject_test.DATA.Models.Ranking;
import com.example.finalproject_test.DATA.ViewModels.RanksVM.RanksViewModel;
import com.example.finalproject_test.LeaderboardAdapter;
import com.example.finalproject_test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link leaderboard_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class leaderboard_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private TextView tvTop1username,tvTop1points, tvTop2username, tvTop2points , tvTop3username, tvTop3points;

    private List<Ranking> rankings;
    private LeaderboardAdapter leaderboardAdapter;

    private RanksViewModel ranksViewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public leaderboard_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment leaderboard_fragment.
     */
    // TODO: Rename and change types and number of parameters
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
       View view = inflater.inflate(R.layout.fragment_leaderboard_fragment, container, false);


       recyclerView = view.findViewById(R.id.recyclerViewLeaderboard);

       tvTop1username = view.findViewById(R.id.tvtop1username);
       tvTop1points = view.findViewById(R.id.tvtop1points);

       tvTop2username = view.findViewById(R.id.tvtop2username);
       tvTop2points = view.findViewById(R.id.tvtop2points);

       tvTop3username = view.findViewById(R.id.tvtop3username);
       tvTop3points = view.findViewById(R.id.tvtop3points);

       ranksViewModel = new ViewModelProvider(this).get(RanksViewModel.class);
       ranksViewModel.getRanks().observe(getViewLifecycleOwner(), ranklist ->{
           if (ranklist != null && !ranklist.isEmpty()){

               ranklist.sort((r1,r2)->Integer.compare(r2.getPoint(),r1.getPoint()));

               if(ranklist.size()>=1){
                   tvTop1username.setText(ranklist.get(0).getUsername());
                   tvTop1points.setText(String.valueOf(ranklist.get(0).getPoint()));
               }
               if (ranklist.size()>=2){
                   tvTop2username.setText(ranklist.get(1).getUsername());
                   tvTop2points.setText(String.valueOf(ranklist.get(1).getPoint()));
               }
               if (ranklist.size()>=3){
                   tvTop3username.setText(ranklist.get(2).getUsername());
                   tvTop3points.setText(String.valueOf(ranklist.get(2).getPoint()));
               }

               List<Ranking> rankingListFrom4 = ranklist.size() > 3 ? ranklist.subList(3,ranklist.size()): new ArrayList<>();


               leaderboardAdapter = new LeaderboardAdapter(rankingListFrom4);
               recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
               recyclerView.setAdapter(leaderboardAdapter);
           }else {
               Log.d("rank", "listrank null ");
           }
       });



        return view;
    }
}