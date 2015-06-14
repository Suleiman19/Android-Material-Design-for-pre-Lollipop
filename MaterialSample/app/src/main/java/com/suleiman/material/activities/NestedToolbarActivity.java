package com.suleiman.material.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.suleiman.material.R;

public class NestedToolbarActivity extends AppCompatActivity {

    Toolbar mToolbar1, mToolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_toolbar);

        mToolbar1 = (Toolbar) findViewById(R.id.nested_toolbar_1);
        mToolbar2 = (Toolbar) findViewById(R.id.nested_toolbar_2);

        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.nested_parentframe);


        setSupportActionBar(mToolbar2);
        getSupportActionBar().setTitle("Title");

        mToolbar1.setNavigationIcon(R.drawable.ic_action_menu);
        mToolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * TODO: Handle Navigation Drawer menu click here
                 */

                Snackbar.make(frameLayout, "Tapped Nav Drawer", Snackbar.LENGTH_SHORT).show();

            }
        });

        mToolbar2.setTitleTextColor(getResources().getColor(android.R.color.tertiary_text_light));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nested_toolbar, menu);
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
