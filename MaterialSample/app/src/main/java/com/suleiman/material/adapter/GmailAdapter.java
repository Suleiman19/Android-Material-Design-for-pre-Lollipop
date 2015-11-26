package com.suleiman.material.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.suleiman.material.R;

import java.util.List;
import java.util.Random;

/**
 * Created by sulei on 8/12/2015.
 */
public class GmailAdapter extends RecyclerView.Adapter<GmailAdapter.GmailVH> {
    List<String> dataList;
    String letter;
    Context context;
    ColorGenerator generator = ColorGenerator.MATERIAL;


    /*int colors[] = {R.color.red, R.color.pink, R.color.purple, R.color.deep_purple,
            R.color.indigo, R.color.blue, R.color.light_blue, R.color.cyan, R.color.teal, R.color.green,
            R.color.light_green, R.color.lime, R.color.yellow, R.color.amber, R.color.orange, R.color.deep_orange};*/

    public GmailAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public GmailVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gmail_list_item, viewGroup, false);
        return new GmailVH(view);
    }

    @Override
    public void onBindViewHolder(GmailVH gmailVH, int i) {
        gmailVH.title.setText(dataList.get(i));
//        Get the first letter of list item
        letter = String.valueOf(dataList.get(i).charAt(0));

//        Create a new TextDrawable for our image's background
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(letter, generator.getRandomColor());

        gmailVH.letter.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class GmailVH extends RecyclerView.ViewHolder {
        TextView title;
        ImageView letter;

        public GmailVH(View itemView) {
            super(itemView);
            letter = (ImageView) itemView.findViewById(R.id.gmailitem_letter);
            title = (TextView) itemView.findViewById(R.id.gmailitem_title);
        }
    }

}


