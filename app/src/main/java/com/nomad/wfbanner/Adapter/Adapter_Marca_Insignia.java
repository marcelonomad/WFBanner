package com.nomad.wfbanner.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nomad.wfbanner.Interface.IFita_Selected;
import com.nomad.wfbanner.Interface.IInsignia_Selected;
import com.nomad.wfbanner.Interface.IMarca_Selected;
import com.nomad.wfbanner.Negocio.Conquista_NG;
import com.nomad.wfbanner.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Marca_Insignia extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Conquista_NG> mMarca_Insignia;
    private Activity mContext;
    private IMarca_Selected _callback_Marca;
    private IFita_Selected _callback_Fita;
    private IInsignia_Selected _callback_Insignia;
    private final int TIPO_CONQUISTA;


    public Adapter_Marca_Insignia(Activity mContext, List<Conquista_NG> mItems, int pTipo_Conquista) {
        this.mContext = mContext;
        this.mMarca_Insignia = mItems;
        TIPO_CONQUISTA = pTipo_Conquista;
        _callback_Marca = (IMarca_Selected) mContext;
        _callback_Fita = (IFita_Selected) mContext;
        _callback_Insignia = (IInsignia_Selected) mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (TIPO_CONQUISTA == 0 || TIPO_CONQUISTA == 1) {
            View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.marca_insignia_item, viewGroup, false);
            return new Holder_Marca_Insignia(menuItemLayoutView);
        } else {
            View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.fita_item, viewGroup, false);
            return new Holder_Fita(menuItemLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        final Conquista_NG oItem = mMarca_Insignia.get(i);


        if (TIPO_CONQUISTA == 0 || TIPO_CONQUISTA == 1) {

            Holder_Marca_Insignia marca_insignia = (Holder_Marca_Insignia) holder;

            marca_insignia.txt_Nome_Item.setText(oItem.getNome());
            marca_insignia.txt_Descricao_Item.setText(oItem.getDescricao());
            Picasso.get()
                    .load(oItem.getImagem())
                    .placeholder(R.drawable.loading)
                    .into(marca_insignia.img_Item);
            if (TIPO_CONQUISTA == 0) {
                marca_insignia.img_Item.setOnClickListener(v -> {
                    _callback_Marca.marca_Selected(oItem.getImagem());
                });

                marca_insignia.txt_Nome_Item.setOnClickListener(v -> {
                    _callback_Marca.marca_Selected(oItem.getImagem());
                });
                marca_insignia.txt_Descricao_Item.setOnClickListener(v -> {
                    _callback_Marca.marca_Selected(oItem.getImagem());
                });
            } else {
                marca_insignia.img_Item.setOnClickListener(v -> {
                    _callback_Insignia.insignia_Selected(oItem.getImagem());
                });

                marca_insignia.txt_Nome_Item.setOnClickListener(v -> {
                    _callback_Insignia.insignia_Selected(oItem.getImagem());
                });
                marca_insignia.txt_Descricao_Item.setOnClickListener(v -> {
                    _callback_Insignia.insignia_Selected(oItem.getImagem());
                });
            }

        } else {
            Holder_Fita fita = (Holder_Fita) holder;

            fita.mNome.setText(oItem.getNome());
            fita.mDescricao.setText(oItem.getDescricao());
            Picasso.get()
                    .load(oItem.getImagem())
                    .placeholder(R.drawable.loading)
                    .into(fita.mImagem);

            fita.mImagem.setOnClickListener(v -> {
                _callback_Fita.fita_Selected(oItem.getImagem());
            });

            fita.mNome.setOnClickListener(v -> {
                _callback_Fita.fita_Selected(oItem.getImagem());
            });
            fita.mDescricao.setOnClickListener(v -> {
                _callback_Fita.fita_Selected(oItem.getImagem());
            });

        }
    }

    @Override
    public int getItemCount() {
        return mMarca_Insignia != null ? mMarca_Insignia.size() : 0;
    }
}
