package com.suleiman.material.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.suleiman.material.R;
import com.suleiman.material.adapter.SimpleRecyclerAdapter;
import com.suleiman.material.model.VersionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 15-06-2015.
 *
 * Simple Quick Return implementation using Design Support Library.
 * Added Bottom Sheet
 */
public class QuickReturnActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SimpleRecyclerAdapter adapter;
    CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quick_return);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.quickreturn_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.quickreturn_coordinator);
        recyclerView = (RecyclerView) findViewById(R.id.quickreturn_list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> listData = new ArrayList<String>();
        int ct = 0;
        for (int i = 0; i < VersionModel.data.length * 3; i++) {
            listData.add(VersionModel.data[ct]);
            ct++;
            if (ct == VersionModel.data.length) {
                ct = 0;
            }
        }

        if (adapter == null) {
            adapter = new SimpleRecyclerAdapter(listData);
            recyclerView.setAdapter(adapter);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
