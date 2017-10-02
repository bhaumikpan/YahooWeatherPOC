package com.bhaumik.yahooweatherpoc.view;

import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.bhaumik.yahooweatherpoc.R;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Weather;
import com.bhaumik.yahooweatherpoc.server.api.YahooServer;
import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    private DotIndicator dotIndicator;
    private boolean isCounterFinished = true;
    private HashMap<Integer, String> cityHashMap;

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    //TODO modify NUM_PAGES as dynamic
    private static final int NUM_PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotIndicator = (DotIndicator) findViewById(R.id.dot_indicator_view);
        dotIndicator.setSelectedDotColor(ContextCompat.getColor(this, android.R.color.black));
        dotIndicator.setUnselectedDotColor(ContextCompat.getColor(this, android.R.color.darker_gray));
        dotIndicator.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        if(cityHashMap == null) {
            cityHashMap = new HashMap<>();
            //TODO enter default geo location ad item 0
        }

        String location;

        for(int i = 0; i<NUM_PAGES ; i ++ ){
            switch (i){
                case 0:
                    location = "95132";
                    cityHashMap.put(0, location);
                    break;
                case 1:
                    location = "San Francisco";
                    cityHashMap.put(1, location);
                    break;
                case 2:
                    location = "07306";
                    cityHashMap.put(2, location);
                    break;
            }
        }

        // The pager widget, which handles animation and allows swiping horizontally to access previous
        // and next wizard steps.

        ViewPager mPager = (ViewPager) findViewById(R.id.container);


        // The pager adapter, which provides the pages to the view pager widget.

        PagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        //TODO handle page changer
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                displayDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideDotAfter3Sec();
    }

    private void displayDot(int position) {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.side_up);
        animation.setDuration(100);
        dotIndicator.startAnimation(animation);

        dotIndicator.setSelectedItem(position, true);
        dotIndicator.setVisibility(View.VISIBLE);
        hideDotAfter3Sec();
    }

    private void hideDotAfter3Sec(){

        if(!isCounterFinished){
            return;
        }
        CountDownTimer counter = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                animation.setDuration(500);
                dotIndicator.startAnimation(animation);
                dotIndicator.setVisibility(View.GONE);
                isCounterFinished = true;
            }
        };
        counter.start();
        isCounterFinished = false;
    }

    public HashMap<Integer, String> getCityHashMap() {
        return cityHashMap;
    }

    public void setCityHashMap(HashMap<Integer, String> cityHashMap) {
        this.cityHashMap = cityHashMap;
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            WeatherFragment fragment = new WeatherFragment();
            Bundle args = new Bundle();
            args.putString(WeatherFragment.WEATHER_CITY, cityHashMap.get(position));
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            dotIndicator.setNumberOfItems(NUM_PAGES);
            return NUM_PAGES;
        }
    }
}
