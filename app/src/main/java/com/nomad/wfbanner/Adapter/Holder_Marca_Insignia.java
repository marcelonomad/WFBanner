package com.nomad.wfbanner.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nomad.wfbanner.R;

public class Holder_Marca_Insignia extends RecyclerView.ViewHolder {

    public ImageView img_Item;
    public TextView txt_Nome_Item, txt_Descricao_Item;

    public Holder_Marca_Insignia(@NonNull View itemView) {
        super(itemView);
        img_Item = itemView.findViewById(R.id.img_Item);
        txt_Nome_Item = itemView.findViewById(R.id.lbl_Nome_Item);
        txt_Descricao_Item = itemView.findViewById(R.id.txt_Descricao_Item);
    }
}
