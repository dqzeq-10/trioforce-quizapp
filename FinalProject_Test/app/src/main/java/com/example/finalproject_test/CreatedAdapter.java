package com.example.finalproject_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CreatedAdapter extends RecyclerView.Adapter<CreatedAdapter.CreatedViewHolder> {

    private final List<CreatedItem> createdItems;


    public CreatedAdapter(List<CreatedItem> createdItems) {
        this.createdItems = createdItems;
    }

    @NonNull
    @Override
    public CreatedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho từng item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_created, parent, false);
        return new CreatedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatedViewHolder holder, int position) {
        // Gắn dữ liệu vào từng item
        CreatedItem item = createdItems.get(position);
        holder.tvMonth.setText(item.getMonth());
        holder.tvCategory.setText(item.getCategory());
        holder.tvTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        // Trả về số lượng item trong danh sách
        return createdItems.size();
    }

    // ViewHolder class
    public static class CreatedViewHolder extends RecyclerView.ViewHolder {
        TextView tvMonth, tvCategory, tvTitle;

        public CreatedViewHolder(@NonNull View itemView) {
            super(itemView);

            // Ánh xạ các thành phần giao diện
            tvMonth = itemView.findViewById(R.id.tvMonth);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
