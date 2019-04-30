package com.nomad.wfbanner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nomad.wfbanner.negocio.Patente_NG;
import com.nomad.wfbanner.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Patente extends ArrayAdapter<Patente_NG> {

    private List<Patente_NG> patentes;
    private Context mContext;

    public Adapter_Patente(Context context, List<Patente_NG> patentes) {
        super(context, R.layout.item_patente, 0, patentes);
        this.mContext = context;
        this.patentes = patentes;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.item_patente, parent, false);

        TextView numero = row.findViewById(R.id.txt_Numero_Patente);
        ImageView imagem = row.findViewById(R.id.img_Patente);

        numero.setText(patentes.get(position).getNumero());
        Picasso.get()
                .load(patentes.get(position).getImagem())
                .placeholder(R.drawable.loading)
                .into(imagem);
        return row;
    }
}
