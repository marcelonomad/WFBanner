package com.nomad.wfbanner.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nomad.wfbanner.negocio.Conquista_NG;
import com.nomad.wfbanner.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Fita extends RecyclerView.Adapter<Holder_Fita> {

    private final List<Conquista_NG> mFitas;
    private final Activity mContext;


    public Adapter_Fita(Activity mContext, List<Conquista_NG> mFitas) {
        this.mContext = mContext;
        this.mFitas = mFitas;
    }


    @NonNull
    @Override
    public Holder_Fita onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mitem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fita_item, viewGroup, false);
        return new Holder_Fita(mitem);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Fita holder_fita, int i) {
        final Conquista_NG oItem = mFitas.get(i);
        holder_fita.mNome.setText(oItem.getNome());
        holder_fita.mDescricao.setText(oItem.getDescricao());

        Picasso.get()
                .load(oItem.getImagem())
                .placeholder(R.drawable.loading)
                .into(holder_fita.mImagem);
    }

    @Override
    public int getItemCount() {
        return mFitas != null ? mFitas.size() : 0;
    }
}
