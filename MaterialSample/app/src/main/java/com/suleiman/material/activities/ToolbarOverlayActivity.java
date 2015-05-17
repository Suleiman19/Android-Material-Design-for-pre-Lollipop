package com.suleiman.material.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.suleiman.material.R;
import com.suleiman.material.utils.Utils;

public class ToolbarOverlayActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton fab;
    FrameLayout transFrame, mainBg;
    int statusBarHeight;
    boolean isStatusBarTransparent = false, isGrownAnim = false;
    View statusBarHolderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(getResources().getColor(R.color.blank_trans80));

            statusBarHeight = Utils.getStatusBarHeight(this);
            isStatusBarTransparent = true;
        }

        setContentView(R.layout.activity_toolbar_overlay);

        final Animation animGrow = AnimationUtils.loadAnimation(this, R.anim.grow_color);
        final Animation animShrink = AnimationUtils.loadAnimation(this, R.anim.shrink_color);

        toolbar = (Toolbar) findViewById(R.id.toolbar_transparent);
        setSupportActionBar(toolbar);

        statusBarHolderView = findViewById(R.id.test_statusbar_holder);
        if (!isStatusBarTransparent) {
            statusBarHolderView.setVisibility(View.GONE);
        }

        fab = (ImageButton) findViewById(R.id.myfab_main_btn);
        transFrame = (FrameLayout) findViewById(R.id.trans_bg);
        mainBg = (FrameLayout) findViewById(R.id.test_bg);

        animGrow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isGrownAnim = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animShrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isGrownAnim = false;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGrownAnim) {
                    transFrame.startAnimation(animShrink);

                } else {
                    transFrame.startAnimation(animGrow);
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
