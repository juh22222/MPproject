package com.example.thfad_000.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by 주희 on 2017-04-17.
 */

public class VillageInfoActivity extends AppCompatActivity {

    Toolbar viToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viToolbar = (Toolbar) findViewById(R.id.villageInfotoolbar);
        setSupportActionBar(viToolbar);

        setContentView(R.layout.activity_village);
    }
}
