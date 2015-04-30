package com.suleiman.material.utils;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Suleiman on 18-04-2015.
 */
public abstract class MyRecyclerScroll extends RecyclerView.OnScrollListener {
    private static final float MINIMUM = 25;

    int scrollDist = 0;
    private boolean isVisible = true;


    //    We dont use this method because its action is called per pixel value change
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        //  Check scrolled distance against the minimum
        if (isVisible && scrollDist > MINIMUM) {
            //  Hide fab & reset scrollDist
            hide();
            scrollDist = 0;
            isVisible = false;
        }
        //  -MINIMUM because scrolling up gives - dy values
        else if (!isVisible && scrollDist < -MINIMUM) {
            //  Show fab & reset scrollDist
            show();
            scrollDist = 0;
            isVisible = true;
        }

        //  Whether we scroll up or down, calculate scroll distance
        if ((isVisible && dy > 0) || (!isVisible && dy < 0)) {
            scrollDist += dy;
        }

    }


    public abstract void show();

    public abstract void hide();
}
