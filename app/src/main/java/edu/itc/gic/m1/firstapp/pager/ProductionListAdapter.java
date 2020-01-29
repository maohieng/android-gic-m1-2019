package edu.itc.gic.m1.firstapp.pager;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.model.Production;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/22/2020
 */
public class ProductionListAdapter extends
        BaseRecyclerAdapter<Production, ProductionListAdapter.ProductionViewHolder> {

    Context context;

    ProductionListAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ProductionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_list_production, parent, false);

        return new ProductionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionViewHolder holder, int position) {
        Production item = getData().get(position);
        holder.image.setImageURI(Uri.parse(item.getLogo())); // This doesn't work!
        holder.textName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
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
