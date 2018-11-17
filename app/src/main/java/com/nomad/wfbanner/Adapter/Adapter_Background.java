package com.nomad.wfbanner.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nomad.wfbanner.Negocio.Background_NG;
import com.nomad.wfbanner.R;
import com.nomad.wfbanner.Telas.Banner_Criado;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Adapter_Background extends RecyclerView.Adapter<Holder_Background> {
    private Activity mContext;
    private List<Background_NG> items;

    public Adapter_Background(Activity mContext, List<Background_NG> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public Holder_Background onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mitem = LayoutInflater.from(mContext).inflate(R.layout.item_imagem_fundo, viewGroup, false);
        return new Holder_Background(mitem);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Background holder_background, int i) {
        final Background_NG oItem = items.get(i);
        Picasso.get()
                .load(oItem.getURL())
                .placeholder(R.drawable.loading)
                .into(holder_background.img_Background);
        holder_background.img_Background.setOnClickListener(v -> {
            SharedPreferences.Editor editor = mContext.getSharedPreferences("pref_Fundo", MODE_PRIVATE).edit();
            editor.putString("pref_Fundo", oItem.getURL());
            editor.apply();
            Intent intent = new Intent(mContext, Banner_Criado.class);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
