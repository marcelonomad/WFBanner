package com.nomad.wfbanner.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nomad.wfbanner.R;

public class Holder_Fita extends RecyclerView.ViewHolder {

    public TextView mNome, mDescricao;
    public ImageView mImagem;

    public Holder_Fita(@NonNull View itemView) {
        super(itemView);

        mNome = itemView.findViewById(R.id.txt_Nome_Fita);
        mDescricao = itemView.findViewById(R.id.txt_Descricao_Fita);
        mImagem = itemView.findViewById(R.id.img_Fita);

    }
}
