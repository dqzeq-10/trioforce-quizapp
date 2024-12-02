package com.example.finalproject_test.DATA.InterfaceAPI.CategoriesApi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_test.DATA.Models.QuestionCategory;
import com.example.finalproject_test.R;
import com.example.finalproject_test.activity_choose_mode;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private List<QuestionCategory> categoryList;
    private Context context;

    public CategoriesAdapter(List<QuestionCategory> categoryList) {

        this.categoryList = categoryList;
    }

    //mới thêm...)
    public CategoriesAdapter(Context context, List<QuestionCategory> categories) {
        this.context = context;
        this.categoryList = categories;
    }
    public void updateData(List<QuestionCategory> newCategoryList) {
        this.categoryList = newCategoryList; // Cập nhật danh sách
        notifyDataSetChanged(); // Làm mới giao diện
    }
//...mới thêm)




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuestionCategory category = categoryList.get(position);
        int imageResId = getImageResIdByCategoryId(category.getIdCategory());
        holder.tvCategoryName.setText(category.getCategoryName());
        holder.tvIcon.setImageResource(imageResId);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, activity_choose_mode.class);

                //(mới thêm nè...
                intent.putExtra("ID_THE_LOAI", category.getIdCategory());
                intent.putExtra("TEN_THE_LOAI", category.getCategoryName());
                //...mới thêm nè)

                context.startActivity(intent);

                //(mới thêm nè...
                Log.d("CategoriesAdapter", "ID thể loại: " + category.getIdCategory());
                Log.d("CategoriesAdapter", "Tên thể loại: " + category.getCategoryName());
                //...mới thêm nè)
            }
        });
//        holder.tvIcon.setImageResource(category.getImageResId());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryName;
        ImageView tvIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryName = itemView.findViewById(R.id.tvTitleCategories);
            tvIcon = itemView.findViewById(R.id.ivIcon);
        }

    }

    // Phương thức ánh xạ idCategory sang imageResId
    private int getImageResIdByCategoryId(int idCategory) {
        switch (idCategory) {
            case 1:
                return R.raw.the_thao;
            case 2:
                return R.raw.khoa_hoc;
            case 3:
                return R.raw.van_hoc;
            case 4:
                return R.raw.lich_su;
            case 5:
                return R.raw.toan_hoc;
            case 6:
                return R.raw.am_thuc;
            case 7:
                return R.raw.cong_nghe;
            case 8:
                return R.raw.dia_ly;
            case 9:
                return R.raw.am_nhac;
            case 10:
                return R.raw.phim_anh;
            case 11:
                return R.raw.ngu_phap;
            case 12:
                return R.raw.do_vui;
            default:
                return R.raw.the_thao;
        }
    }

}
