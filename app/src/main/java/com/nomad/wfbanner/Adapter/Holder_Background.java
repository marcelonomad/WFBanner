package com.nomad.wfbanner.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nomad.wfbanner.R;

public class Holder_Background extends RecyclerView.ViewHolder {
    public ImageView img_Background;


    public Holder_Background(@NonNull View itemView) {
        super(itemView);
        img_Background = itemView.findViewById(R.id.img_Fundo);
    }
}
