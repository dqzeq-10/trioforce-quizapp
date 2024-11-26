package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {

    private final List<ProgressItem> progressItems;

    public ProgressAdapter(List<ProgressItem> progressItems) {
        this.progressItems = progressItems;
    }

    @NonNull
    @Override
    public ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_progress, parent, false);
        return new ProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressViewHolder holder, int position) {
        ProgressItem item = progressItems.get(position);
        holder.tvMonthYear.setText(item.getMonthYear());
        holder.tvTitle.setText(item.getTitle());
        holder.tvProgress.setText("Tiến độ: "+item.getProgress());
        holder.tvAuthor.setText("@" + item.getAuthor());
        holder.ivAvatar.setImageResource(item.getAvataResId());
    }

    @Override
    public int getItemCount() {
        return progressItems.size();
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        TextView tvMonthYear, tvTitle, tvProgress, tvAuthor;
        ImageView ivAvatar;

        public ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonthYear = itemView.findViewById(R.id.tvMonthYear);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvProgress = itemView.findViewById(R.id.tvProgress);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
        }
    }
}
