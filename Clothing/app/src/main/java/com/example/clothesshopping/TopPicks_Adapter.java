package com.example.clothesshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopPicks_Adapter extends RecyclerView.Adapter  {
    private Context mContext;
    private ArrayList<ClothingItem> mTopPicks;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public TopPicks_Adapter(Context context, ArrayList<ClothingItem> mTopPicksList) {
        mContext = context;
        mTopPicks = mTopPicksList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;

        view = layoutInflater.inflate(R.layout.toppicks_list, parent, false);

        return new ViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClothingItem currentItem = mTopPicks.get(position);

        ViewHolder viewHolder= (ViewHolder) holder;

        int i = mContext.getResources().getIdentifier(
                currentItem.getImagefilename(), "drawable",
                mContext.getPackageName());
        viewHolder.mImageView.setImageResource(i);

    }

    @Override
    public int getItemCount() {
        return mTopPicks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.top_picks_image_view);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }





}


