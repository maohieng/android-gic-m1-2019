package edu.itc.gic.m1.firstapp.pager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/15/2020
 */
public class SongBookPageAdapter extends FragmentPagerAdapter {

    private final Fragment[] mFragments;
    private final String[] pageTitles;

    public SongBookPageAdapter(FragmentManager fm, @NonNull Fragment[] fragments, @NonNull String[] pageTitles) {
        super(fm);
        mFragments = fragments;
        this.pageTitles = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
