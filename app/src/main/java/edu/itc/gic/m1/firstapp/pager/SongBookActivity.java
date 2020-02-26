package edu.itc.gic.m1.firstapp.pager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.db.AppDatabase;
import edu.itc.gic.m1.firstapp.db.ProductionDao;
import edu.itc.gic.m1.firstapp.db.SingerDao;
import edu.itc.gic.m1.firstapp.db.SongDao;
import edu.itc.gic.m1.firstapp.model.Production;
import edu.itc.gic.m1.firstapp.model.Singer;
import edu.itc.gic.m1.firstapp.model.Song;
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

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                ProductionDao productionDao = appDatabase.getProductionDao();

                //Check data before simulate
                List<Production> productionList = productionDao.getAll();

                if (productionList == null || productionList.size() == 0) {
                    // TODO: 1/29/2020 Simulate data production
                    final Production[] productions = new Production[]{
                            new Production("Hang Meas", "http://lh3.googleusercontent.com/W3q_EsCMpldD7fj6b8KFzPRDJ1PMJ2LVKEe2yuPT_IYPxhD-HKKX5s9N8aAnxf3xyE3a4faJS5WJ1M_1bDHN91-OSyWaiOU=s140-c"),
                            new Production("SUNDAY", "http://lh3.googleusercontent.com/W3q_EsCMpldD7fj6b8KFzPRDJ1PMJ2LVKEe2yuPT_IYPxhD-HKKX5s9N8aAnxf3xyE3a4faJS5WJ1M_1bDHN91-OSyWaiOU=s140-c"),
                            new Production("TOWN", "http://lh3.googleusercontent.com/W3q_EsCMpldD7fj6b8KFzPRDJ1PMJ2LVKEe2yuPT_IYPxhD-HKKX5s9N8aAnxf3xyE3a4faJS5WJ1M_1bDHN91-OSyWaiOU=s140-c")
                    };

                    productionDao.save(productions);
                }

                SingerDao singerDao = appDatabase.getSingerDao();
                singerDao.save(new Singer("Meas Soksophea", "http://lh3.googleusercontent.com/W3q_EsCMpldD7fj6b8KFzPRDJ1PMJ2LVKEe2yuPT_IYPxhD-HKKX5s9N8aAnxf3xyE3a4faJS5WJ1M_1bDHN91-OSyWaiOU=s140-c"));
            }
        };
//        new Thread(runnable).start();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
