package edu.itc.gic.m1.firstapp.pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    List<T> data;

    protected final LayoutInflater inflater;

    public BaseRecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
