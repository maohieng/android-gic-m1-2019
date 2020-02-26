package edu.itc.gic.m1.firstapp.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.Executors;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.db.AppDatabase;
import edu.itc.gic.m1.firstapp.db.ProductionDao;
import edu.itc.gic.m1.firstapp.db.SongDao;
import edu.itc.gic.m1.firstapp.model.Production;
import edu.itc.gic.m1.firstapp.model.Song;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/15/2020
 */
public class ProductionFragment extends Fragment {

    RecyclerView recyclerView;
    ProductionListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_production, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new ProductionListAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load data from database
        AppDatabase database = AppDatabase.getInstance(getContext());
        final ProductionDao productionDao = database.getProductionDao();

        // Create a thread to load productions from database
        Executors.newSingleThreadExecutor().execute(() -> {
            List<Production> productions = productionDao.getAll();

            // Set data into list adapter
            getActivity().runOnUiThread(() -> adapter.setData(productions));

        });

    }

}
