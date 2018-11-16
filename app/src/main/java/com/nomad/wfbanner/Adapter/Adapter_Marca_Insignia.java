package com.nomad.wfbanner.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nomad.wfbanner.Interface.IMarca_Selected;
import com.nomad.wfbanner.Negocio.Conquista_NG;
import com.nomad.wfbanner.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Marca_Insignia extends RecyclerView.Adapter<Holder_Marca_Insignia> {
    private final List<Conquista_NG> mMarca_Insignia;
    private Activity mContext;
    private IMarca_Selected _callback_Marca;


    public Adapter_Marca_Insignia(Activity mContext, List<Conquista_NG> mItems) {
        this.mContext = mContext;
        this.mMarca_Insignia = mItems;
        _callback_Marca = (IMarca_Selected) mContext;
    }

    @NonNull
    @Override
    public Holder_Marca_Insignia onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.marca_insignia_item, viewGroup, false);
        return new Holder_Marca_Insignia(menuItemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Marca_Insignia holder_marca_insignia, int i) {
        final Conquista_NG oItem = mMarca_Insignia.get(i);
        holder_marca_insignia.txt_Nome_Item.setText(oItem.getNome());
        holder_marca_insignia.txt_Descricao_Item.setText(oItem.getDescricao());
        Picasso.get()
                .load(oItem.getImagem())
                .placeholder(R.drawable.loading)
                .into(holder_marca_insignia.img_Item);


        holder_marca_insignia.img_Item.setOnClickListener(v -> {
            _callback_Marca.marca_Selected(oItem.getImagem());
        });

        holder_marca_insignia.txt_Nome_Item.setOnClickListener(v -> {
            _callback_Marca.marca_Selected(oItem.getImagem());
        });
        holder_marca_insignia.txt_Descricao_Item.setOnClickListener(v -> {
            _callback_Marca.marca_Selected(oItem.getImagem());
        });


    }

    @Override
    public int getItemCount() {
        return mMarca_Insignia != null ? mMarca_Insignia.size() : 0;
    }
}
