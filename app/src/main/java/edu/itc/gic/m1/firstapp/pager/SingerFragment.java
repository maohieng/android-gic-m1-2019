package edu.itc.gic.m1.firstapp.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.itc.gic.m1.firstapp.R;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/15/2020
 */
public class SingerFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singer, container, false);
        return view;
    }
}
