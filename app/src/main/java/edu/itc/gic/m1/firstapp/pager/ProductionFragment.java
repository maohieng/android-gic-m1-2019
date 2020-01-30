package edu.itc.gic.m1.firstapp.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.db.AppDatabase;
import edu.itc.gic.m1.firstapp.db.ProductionDao;
import edu.itc.gic.m1.firstapp.model.Production;

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
        recyclerView.setAdapter(adapter = new ProductionListAdapter(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load data from database
        AppDatabase database = AppDatabase.getInstance(getContext());
        ProductionDao productionDao = database.getProductionDao();
        List<Production> productions = productionDao.getAll();

        // Set data into list adapter
        adapter.setData(productions);
    }

}
