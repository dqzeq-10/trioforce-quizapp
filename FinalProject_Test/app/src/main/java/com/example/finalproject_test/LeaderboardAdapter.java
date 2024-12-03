package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.Ranking;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<Ranking> rankingList;

    public LeaderboardAdapter(List<Ranking> rankingList){
        this.rankingList = rankingList;
    }

    @NonNull
    @Override
    public LeaderboardAdapter.LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_leaderboard, parent, false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.LeaderboardViewHolder holder, int position) {
        Ranking ranking = rankingList.get(position);

        holder.tvRank.setText(String.valueOf(position+4));
        holder.tvUsername.setText(ranking.getUsername());
        holder.tvPoints.setText(String.valueOf(ranking.getPoint()));
    }

    @Override
    public int getItemCount() {
        return rankingList.size();
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        TextView tvRank,tvUsername, tvPoints;
        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            tvUsername = itemView.findViewById(R.id.playName);
            tvPoints = itemView.findViewById(R.id.point);
        }
    }
}