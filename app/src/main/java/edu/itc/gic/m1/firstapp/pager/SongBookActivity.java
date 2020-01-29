package edu.itc.gic.m1.firstapp.pager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.ui.BaseActivity;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/15/2020
 */
public class SongBookActivity extends BaseActivity {

    ViewPager pager;
    Fragment[] fragments;
    String[] pageTitles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_book);
        setTitle("Song Book");
        pager = findViewById(R.id.viewPager);

        fragments = new Fragment[3];
        fragments[0] = new ProductionFragment();
        fragments[1] = new SingerFragment();
        fragments[2] = new SongFragment();

        pageTitles = new String[] {"Productions", "Singers", "Songs"};

        // Customize transformation
        pager.setPageTransformer(true, new ZoomOutPageTransformer());

        // Customize pager tab
        PagerTabStrip pagerTab = findViewById(R.id.pagerTab);
        pagerTab.setTextColor(getResources().getColor(R.color.colorAccent));

        pager.setAdapter(new SongBookPageAdapter(getSupportFragmentManager(),
                fragments, pageTitles));
    }
}
