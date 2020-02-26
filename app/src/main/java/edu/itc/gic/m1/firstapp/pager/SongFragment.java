package edu.itc.gic.m1.firstapp.pager;

import android.content.Context;
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
import edu.itc.gic.m1.firstapp.db.SongDao;
import edu.itc.gic.m1.firstapp.model.Song;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/15/2020
 */
public class SongFragment extends Fragment {

    RecyclerView recyclerView;
    SongListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new SongListAdapter(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final AppDatabase database = AppDatabase.getInstance(getContext());
        SongDao songDao = database.getSongDao();

        LiveData<List<Song>> songLiveData = songDao.getAllAsync();
        songLiveData.observe(this, new Observer<List<Song>>() {
            @Override
            public void onChanged(List<Song> songs) {
                adapter.setData(songs);
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // Classes
    ///////////////////////////////////////////////////////////////////////////

    public static class SongListAdapter extends
            BaseRecyclerAdapter<Song, SongListAdapter.SongViewHolder> {

        public SongListAdapter(Context context) {
            super(context);
        }

        @NonNull
        @Override
        public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.item_list_song, parent, false);

            return new SongViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
            Song item = getData().get(position);

            holder.textName.setText(item.getTitle());
        }

        @Override
        public void onBindViewHolder(@NonNull SongViewHolder holder, int position, @NonNull List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
        }

        class SongViewHolder extends RecyclerView.ViewHolder {

            TextView textName;

            public SongViewHolder(@NonNull View itemView) {
                super(itemView);
                textName = itemView.findViewById(R.id.itemName);
            }
        }

    }
}
