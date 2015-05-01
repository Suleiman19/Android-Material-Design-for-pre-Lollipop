package com.suleiman.material.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.suleiman.material.R;
import com.suleiman.material.adapter.SimpleRecyclerAdapter;
import com.suleiman.material.model.VersionModel;
import com.suleiman.material.utils.MyRecyclerScroll;
import com.suleiman.material.utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class FabHideActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    int fabMargin;
    LinearLayout toolbarContainer;
    int toolbarHeight;
    FrameLayout fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.simple_grow);

        setContentView(R.layout.activity_fab_hide);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  FAB margin needed for animation
        fabMargin = getResources().getDimensionPixelSize(R.dimen.fab_margin);
        // toolbar.getHeight() returns 0, so we'll get the value from the dimen resources XML
        toolbarHeight = Utils.getToolbarHeight(this);

        toolbarContainer = (LinearLayout) findViewById(R.id.fabhide_toolbar_container);
        recyclerView = (RecyclerView) findViewById
                (R.id.recyclerview);

        // Set top padding= toolbar height.
        // So there is no overlap when the toolbar hides.
        // Avoid using 0 for the other parameters as it resets padding set via XML!
        recyclerView.setPadding(recyclerView.getPaddingLeft(), toolbarHeight,
                recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //Make the RecyclerView show a list
        recyclerView.setLayoutManager(linearLayoutManager);

        // Adding list data thrice for a more comfortable scroll.
        List<String> listData = new ArrayList<String>();
        int ct = 0;
        for (int i = 0; i < VersionModel.data.length * 3; i++) {
            listData.add(VersionModel.data[ct]);
            ct++;
            if (ct == VersionModel.data.length) {
                ct = 0;
            }

        }

        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(listData);
        recyclerView.setAdapter(simpleRecyclerAdapter);

        recyclerView.setOnScrollListener(new MyRecyclerScroll() {
            @Override
            public void show() {
                toolbarContainer.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
                fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void hide() {
                toolbarContainer.animate().translationY(-toolbarHeight).setInterpolator(new AccelerateInterpolator(2)).start();
                fab.animate().translationY(fab.getHeight() + fabMargin).setInterpolator(new AccelerateInterpolator(2)).start();
            }
        });

        fab = (FrameLayout) findViewById(R.id.myfab_main);
        ImageButton fabBtn=(ImageButton)findViewById(R.id.myfab_main_btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fabBtn.setBackground(getDrawable(R.drawable.fab_selector_ripple));
        }

        fab.startAnimation(animation);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "FAB Clicked", Toast.LENGTH_SHORT).show();

            }
        });


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
