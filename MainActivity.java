package com.example.thfad_000.myapplication;

import android.app.ListActivity;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_icon_selected)); //setIcon
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.search_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.suggest_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.alarm_icon));

        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter  pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch(tab.getPosition()){
                    case 0: tab.setIcon(R.drawable.home_icon_selected); break;
                    case 1: tab.setIcon(R.drawable.search_icon_selected); break;
                    case 2: tab.setIcon(R.drawable.suggest_icon_selected); break;
                    case 3: tab.setIcon(R.drawable.alarm_icon_selected); break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0: tab.setIcon(R.drawable.home_icon); break;
                    case 1: tab.setIcon(R.drawable.search_icon); break;
                    case 2: tab.setIcon(R.drawable.suggest_icon); break;
                    case 3: tab.setIcon(R.drawable.alarm_icon); break;

                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
