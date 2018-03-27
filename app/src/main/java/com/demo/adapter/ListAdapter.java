package com.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.R;
import com.demo.model.Row;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vijayaraj_s on 27/03/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<Row> mItemsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // variable declaration
        public TextView mTitle;
        public TextView mDescription;
        public ImageView mItemImage;

        public MyViewHolder(View view) {
            super(view);

            // initializing variables
            mTitle = view.findViewById(R.id.text_title);
            mDescription = view.findViewById(R.id.text_description);
            mItemImage = view.findViewById(R.id.item_image);
        }
    }

    public ListAdapter(List<Row> _list) {
        this.mItemsList = _list;
    }

    /**
     * @param parent
     * @param viewType
     * @return individual view of each item
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflating list row items
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    /**
     * @param holder
     * @param position binding the values into relevant list items into row
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Row mItems = mItemsList.get(position);

        holder.mTitle.setText(mItems.getTitle());
        holder.mDescription.setText(mItems.getDescription());

        Picasso.get()
                .load(mItems.getImageHref())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.mItemImage);
    }

    /**
     * @return size of listitems
     */
    @Override
    public int getItemCount() {
        return mItemsList.size();
    }
}