package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private final List<LeaderboardItem> leaderboardItems;

    public LeaderboardAdapter(List<LeaderboardItem> leaderboardItems) {
        this.leaderboardItems = leaderboardItems;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_leaderboard, parent, false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        LeaderboardItem item = leaderboardItems.get(position);
        holder.tvRank.setText(String.valueOf(item.getRank()));
        holder.ivAvatar.setImageResource(item.getAvatarResId());
        holder.tvPlayerName.setText(item.getPlayerName());
        holder.tvScore.setText(item.getScore());
    }

    @Override
    public int getItemCount() {
        return leaderboardItems.size();
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        TextView tvRank, tvPlayerName, tvScore;
        ImageView ivAvatar;
// anh xa cac thanh phan giao dien
        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            ivAvatar = itemView.findViewById(R.id.ivAvatarResID);
            tvPlayerName = itemView.findViewById(R.id.playName);
            tvScore = itemView.findViewById(R.id.score);
        }
    }
}
