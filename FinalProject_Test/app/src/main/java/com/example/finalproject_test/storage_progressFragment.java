package com.example.finalproject_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link storage_progressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class storage_progressFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public storage_progressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment storage_progressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static storage_progressFragment newInstance(String param1, String param2) {
        storage_progressFragment fragment = new storage_progressFragment();
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
        View view = inflater.inflate(R.layout.fragment_storage_progress, container, false);
        // -----------------XOA CAC ITEM KHI VUOT ,SUA LAI CHO HOP EM NHÉ , CHƯA KHỚP -------------------------------------------------
        /*
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
*/
        return view;
    }
}