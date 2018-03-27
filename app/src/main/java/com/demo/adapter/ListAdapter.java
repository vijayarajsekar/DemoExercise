package com.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.R;
import com.demo.model.Row;
import com.demo.utils.ToastUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vijayaraj_s on 27/03/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    // Variable Declaration
    private List<Row> mItemsList;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        // variable declaration
        public TextView mTitle;
        public TextView mDescription;
        public ImageView mItemImage;

        public ViewHolder(View view) {
            super(view);

            // initializing variables
            mTitle = view.findViewById(R.id.text_title);
            mDescription = view.findViewById(R.id.text_description);
            mItemImage = view.findViewById(R.id.item_image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast(mContext, "Item " + getAdapterPosition() + " clicked");
                }
            });
        }
    }

    /**
     * set data for adapter
     *
     * @param _ctx
     * @param _list
     */
    public ListAdapter(Context _ctx, List<Row> _list) {
        this.mContext = _ctx;
        this.mItemsList = _list;
    }

    /**
     * @param parent
     * @param viewType
     * @return individual view of each item
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflating list row items
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);

        return new ViewHolder(itemView);
    }

    /**
     * @param holder
     * @param position binding the values into relevant list items into row
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Object holding single object values
        Row mItems = mItemsList.get(position);

        // set title value
        holder.mTitle.setText(mItems.getTitle());

        // set description value
        holder.mDescription.setText(mItems.getDescription());

        // Picasso library used to load image url into imageview efficiently
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