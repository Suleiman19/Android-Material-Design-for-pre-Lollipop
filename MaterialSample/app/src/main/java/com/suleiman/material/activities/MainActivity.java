package com.suleiman.material.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.suleiman.material.R;
import com.suleiman.material.adapter.SimpleRecyclerAdapter;
import com.suleiman.material.utils.Utils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    Toolbar toolbar;
    RecyclerView recyclerView;
    SimpleRecyclerAdapter adapter;
    Intent intent;

    String[] colors = {"#96CC7A", "#EA705D", "#66BBCC"};

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime)
            startActivity(introIntent);


        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_elevated);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setTitle("Material Design Samples");


        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        if (adapter == null) {
            adapter = new SimpleRecyclerAdapter(this);
            recyclerView.setAdapter(adapter);
        }

        final Context context = this;

        adapter.SetOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, FabHideActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ToolbarOverlayActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, NavDrawerActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, AnimateToolbar.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, TabAnimationActivity.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, NestedToolbarActivity.class);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, QuickReturnActivity.class);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this, RevealAnimation.class);
                        break;
                    case 8:
                        intent = new Intent(MainActivity.this, GmailStyleActivity.class);
                        break;
                    case 9:
                        intent = new Intent(MainActivity.this, PagerActivity.class);
                        break;
                    case 10:
                        intent = new Intent(MainActivity.this, BottomBarActivity.class);
                        break;

                    default:
                        Log.w(TAG, "onItemClick: Undefined Click!");
//                        Toast.makeText(getBaseContext(), "Undefined Click!", Toast.LENGTH_SHORT).show();
                }

                if (intent != null)
                    startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_navigator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
