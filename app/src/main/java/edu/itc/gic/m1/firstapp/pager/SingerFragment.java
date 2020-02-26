package edu.itc.gic.m1.firstapp.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.db.AppDatabase;
import edu.itc.gic.m1.firstapp.db.SingerDao;
import edu.itc.gic.m1.firstapp.model.Singer;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/15/2020
 */
public class SingerFragment extends Fragment {

    RecyclerView recyclerView;
    SingerListAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singer, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new SingerListAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AppDatabase database = AppDatabase.getInstance(getContext());
        SingerDao singerDao = database.getSingerDao();

        LiveData<List<Singer>> singerLiveData = singerDao.getAllAsync();

        singerLiveData.observe(this, new Observer<List<Singer>>() {
            @Override
            public void onChanged(List<Singer> singers) {
                adapter.setData(singers);
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // Classes
    ///////////////////////////////////////////////////////////////////////////

    public class SingerListAdapter extends
            BaseRecyclerAdapter<Singer, SingerListAdapter.SingerViewHolder> {

        private final Fragment mFragment;

        public SingerListAdapter(Fragment fragment) {
            super(fragment.getContext());
            this.mFragment = fragment;
        }

        @NonNull
        @Override
        public SingerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.item_list_singer, parent, false);

            return new SingerViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull SingerViewHolder holder, int position) {
            Singer item = getData().get(position);

            holder.textName.setText(item.getName());

            Glide.with(mFragment)
                    .load(item.getPhoto())
                    .centerCrop()
                    .into(holder.image);
        }

        @Override
        public void onBindViewHolder(@NonNull SingerViewHolder holder, int position, @NonNull List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
        }

        class SingerViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView textName;

            public SingerViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.itemImage);
                textName = itemView.findViewById(R.id.itemName);
            }
        }

    }
}
