package com.code.flashcardenglishviet.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.code.flashcardenglishviet.R;
import com.code.flashcardenglishviet.model.Word;
import com.code.flashcardenglishviet.utils.Var;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sev_user on 10/21/2016.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<Word> data;
    private static MyClickListener myClickListener;
    private Context context;
    private int imageSize = 80;
    private int imageSize1 = 60;
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public CardAdapter(Context context, ArrayList<Word> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Word word = data.get(i);
        //https://github.com/lkuza2/java-speech-api
        Picasso.with(context)
                .load(Var.HOST+word.getAnh())
                .resize(imageSize, imageSize)
                .centerInside()
                .into(viewHolder.imgImage);

        viewHolder.txtWord.setText(Html.fromHtml("<font color=\"#004000\">XP: </font><font color=\"#418725\">"));
//        word.getTen() +" "+  word.getDanhVan() + " " +word.getNghia()
        viewHolder.txtWord1.setText(word.getViDu());
        viewHolder.txtWord2.setText(word.getViDu());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v, int item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtWord, txtWord1, txtWord2;
        private ImageView imgSpeak, imgSpeak1, imgSpeak2, imgImage, imgImage1, imgImage2;
        private RelativeLayout relativeLayout, relativeLayout1, relativeLayout2;
        private LinearLayout linearLayout1, linearLayout2;
        public ViewHolder(View view) {
            super(view);

            txtWord = (TextView) view.findViewById(R.id.txt);
            txtWord1 = (TextView) view.findViewById(R.id.txt1);
            txtWord2 = (TextView) view.findViewById(R.id.txt2);

            imgSpeak = (ImageView) view.findViewById(R.id.speak);
            imgSpeak1 = (ImageView) view.findViewById(R.id.speak1);
            imgSpeak2 = (ImageView) view.findViewById(R.id.speak2);

            imgImage = (ImageView) view.findViewById(R.id.image);
            imgImage1 = (ImageView) view.findViewById(R.id.image1);
            imgImage2 = (ImageView) view.findViewById(R.id.image2);


            relativeLayout = (RelativeLayout) view.findViewById(R.id.layout);
            relativeLayout1 = (RelativeLayout) view.findViewById(R.id.layout1);
            relativeLayout2 = (RelativeLayout) view.findViewById(R.id.layout2);

            linearLayout1 = (LinearLayout) view.findViewById(R.id.linearLayout1);
            linearLayout2 = (LinearLayout) view.findViewById(R.id.linearLayout2);

            view.setOnClickListener(this);
            imgSpeak.setOnClickListener(this);
            imgSpeak1.setOnClickListener(this);
            imgSpeak2.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int item = 0;
            if (v.getId() == imgSpeak1.getId()) {
                item = 1;
            }
            if (v.getId() == imgSpeak2.getId()) {
                item = 2;
            }
            myClickListener.onItemClick(getAdapterPosition(), v, item);
        }
    }

}