package com.example.clothesshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ClothingAdapter extends RecyclerView.Adapter implements Filterable {
    private Context mContext;
    private ArrayList<ClothingItem> mClothingList;
    private ArrayList<ClothingItem> mClothingListListAll;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ClothingAdapter(Context context, ArrayList<ClothingItem> exampleList) {
        mContext = context;
        mClothingList = exampleList;
        mClothingListListAll = new ArrayList<>();
        mClothingListListAll.addAll(exampleList);
    }



    @NonNull
    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;

        view = layoutInflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClothingItem currentItem = mClothingList.get(position);
        String creatorName = currentItem.getClothesName();
        String likeCount = currentItem.getPrice();
        String orderCount = String.valueOf(currentItem.getOrders());
            ViewHolder ViewHolder = (ViewHolder) holder;
            ViewHolder.mTextViewName.setText(creatorName);
            ViewHolder.mTextViewPrice.setText(likeCount);
            ViewHolder.mTextViewOrders.setText("\uD83D\uDE9A"+ orderCount + " Orders");

            int i = mContext.getResources().getIdentifier(
                    currentItem.getImagefilename(), "drawable",
                    mContext.getPackageName());
            ViewHolder.mImageView.setImageResource(i);

        setFadeAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mClothingList.size();
    }

    @Override
    public Filter getFilter() {

        return myFilter;
    }

    Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<ClothingItem> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(mClothingListListAll);
            } else {
                for (ClothingItem Example: mClothingListListAll) {
                    if (Example.getClothesName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(Example);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mClothingList.clear();
            mClothingList.addAll((Collection<? extends ClothingItem>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewPrice;
        public TextView mTextViewOrders;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewPrice = itemView.findViewById(R.id.text_view_price);
            mTextViewOrders = itemView.findViewById(R.id.text_view_orders);

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

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }

}