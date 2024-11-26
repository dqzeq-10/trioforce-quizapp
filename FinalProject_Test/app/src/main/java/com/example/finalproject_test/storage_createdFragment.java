package com.example.finalproject_test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class storage_createdFragment extends Fragment {

    private RecyclerView recyclerView;
    private CreatedAdapter adapter;
    private List<CreatedItem> createdItems;

    public storage_createdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage_created, container, false);

        // Ánh xạ RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_Created);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo danh sách dữ liệu mẫu
        createdItems = new ArrayList<>();
        createdItems.add(new CreatedItem("Tháng 9 năm 2024", "Đố vui:", "Đuôi thì chẳng thấy, mà có hai đầu?"));
        createdItems.add(new CreatedItem("Tháng 10 năm 2022", "Bóng đá:", "Đội bóng nào vô địch World Cup nhiều nhất?"));
        createdItems.add(new CreatedItem("Tháng 10 năm 2022", "Khoa học:", "Đầu máy hơi nước được sản xuất vào năm nào?"));

        // Gắn Adapter
        adapter = new CreatedAdapter(createdItems);
        recyclerView.setAdapter(adapter);

        // Thêm ItemTouchHelper để xử lý vuốt xóa
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false; // Không xử lý di chuyển item
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition(); // Lấy vị trí item bị vuốt
                if (direction == ItemTouchHelper.LEFT) {
                    // Hiển thị dialog xác nhận
                    popup_comfirm_delete popup = new popup_comfirm_delete(getContext(), new popup_comfirm_delete.OnPopupActionListener() {
                        @Override
                        public void onConfirm() {
                            createdItems.remove(position);
                            adapter.notifyItemRemoved(position);
                        }

                        @Override
                        public void onCancel() {
                            adapter.notifyItemChanged(position);
                        }
                    });
                    popup.show();
                }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                    @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                    int actionState, boolean isCurrentlyActive) {
                // Lấy view item
                View itemView = viewHolder.itemView;

                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#2FA3BE") );
                c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(),
                        (float) itemView.getRight(), (float) itemView.getBottom(), paint);

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });

        // Gắn ItemTouchHelper vào RecyclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return view;
    }
}
