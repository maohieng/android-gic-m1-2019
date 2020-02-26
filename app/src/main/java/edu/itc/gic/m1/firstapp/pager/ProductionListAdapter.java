package edu.itc.gic.m1.firstapp.pager;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.model.Production;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/22/2020
 */
public class ProductionListAdapter extends
        BaseRecyclerAdapter<Production, ProductionListAdapter.ProductionViewHolder> {

    private final Fragment mFragment;

    public ProductionListAdapter(Fragment fragment) {
        super(fragment.getContext());
        this.mFragment = fragment;
    }

    @NonNull
    @Override
    public ProductionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_list_production, parent, false);

        return new ProductionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionViewHolder holder, int position) {
        Production item = getData().get(position);

        holder.textName.setText(item.getName());

        Glide.with(mFragment)
                .load(item.getLogo())
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    class ProductionViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textName;

        public ProductionViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemImage);
            textName = itemView.findViewById(R.id.itemName);
        }
    }

}
