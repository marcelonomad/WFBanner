package com.nomad.wfbanner.Telas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nomad.wfbanner.Adapter.Adapter_Fita;
import com.nomad.wfbanner.Adapter.Adapter_Marca_Insignia;
import com.nomad.wfbanner.Interface.IConquista_Result;
import com.nomad.wfbanner.Interface.IFita_Selected;
import com.nomad.wfbanner.Interface.IInsignia_Selected;
import com.nomad.wfbanner.Interface.IMarca_Selected;
import com.nomad.wfbanner.Negocio.Conquista_NG;
import com.nomad.wfbanner.Negocio.Database.DatabaseAccess;
import com.nomad.wfbanner.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Fita_Marca_Insignia extends AppCompatActivity implements IConquista_Result, IMarca_Selected, IInsignia_Selected, IFita_Selected {

    private List<Conquista_NG> mMarcas, mInsignias, mFitas;
    Adapter_Marca_Insignia adapter;
    Adapter_Fita adapter_fita;
    RecyclerView rcv_Conquista;
    Button btn_Marca, btn_Insignia, btn_Fita, btn_Proximo;
    ImageView img_Marca, img_Fita, img_Insignia, img_Patente;
    TextView txt_Cla, txt_Nome;
    String Fita = null, Marca = null, Insignia = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fita_marca_insignia);

        new get_Conquistas(this).execute();
        rcv_Conquista = findViewById(R.id.rcv_Conquista);
        btn_Marca = findViewById(R.id.btn_Marca);
        btn_Fita = findViewById(R.id.btn_fita);
        btn_Insignia = findViewById(R.id.btn_Insignia);
        img_Marca = findViewById(R.id.img_Marca);
        img_Insignia = findViewById(R.id.img_Insignia);
        img_Fita = findViewById(R.id.img_fita);
        txt_Cla = findViewById(R.id.txt_Cla);
        txt_Nome = findViewById(R.id.txt_Nome);
        img_Patente = findViewById(R.id.img_Patente);
        btn_Proximo = findViewById(R.id.btn_Proximo);

        SharedPreferences pref_nome = getSharedPreferences("pref_Nome", MODE_PRIVATE);
        SharedPreferences pref_cla = getSharedPreferences("pref_Cla", MODE_PRIVATE);
        SharedPreferences pref_Rank = getSharedPreferences("pref_Rank", MODE_PRIVATE);

        String nome = pref_nome.getString("pref_Nome", "");
        String cla = pref_cla.getString("pref_Cla", "");
        String patente = pref_Rank.getString("pref_Rank", "");
        txt_Cla.setText(cla);
        txt_Nome.setText(nome);
        Picasso.get()
                .load(patente)
                .into(img_Patente);


        adapter = new Adapter_Marca_Insignia(this, new ArrayList<>(0), 0);
        adapter_fita = new Adapter_Fita(this, new ArrayList<>(0));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_Conquista.setLayoutManager(layoutManager);
        rcv_Conquista.setAdapter(adapter);

        btn_Marca.setOnClickListener(v -> {
            adapter = new Adapter_Marca_Insignia(Fita_Marca_Insignia.this, mMarcas, 0);
            rcv_Conquista.setAdapter(adapter);
        });

        btn_Insignia.setOnClickListener(v -> {
            adapter = new Adapter_Marca_Insignia(Fita_Marca_Insignia.this, mInsignias, 1);
            rcv_Conquista.setAdapter(adapter);
        });
        btn_Fita.setOnClickListener(v -> {
            adapter = new Adapter_Marca_Insignia(Fita_Marca_Insignia.this, mFitas, 2);
            rcv_Conquista.setAdapter(adapter);
        });

        btn_Proximo.setOnClickListener(v -> {
            if (Marca != null) {
                if (Marca.length() > 0) {
                    SharedPreferences.Editor editor = getSharedPreferences("pref_Marca", MODE_PRIVATE).edit();
                    editor.putString("pref_Marca", Marca);
                    editor.apply();
                }
            }
            if (Fita != null) {
                if (Fita.length() > 0) {
                    SharedPreferences.Editor editor = getSharedPreferences("pref_Fita", MODE_PRIVATE).edit();
                    editor.putString("pref_Fita", Fita);
                    editor.apply();
                }
            }
            if (Insignia != null) {
                if (Insignia.length() > 0) {
                    SharedPreferences.Editor editor = getSharedPreferences("pref_Insignia", MODE_PRIVATE).edit();
                    editor.putString("pref_Insignia", Insignia);
                    editor.apply();
                }
            }
            Intent i = new Intent(Fita_Marca_Insignia.this, Escolher_Fundo.class);
            startActivity(i);
        });

    }

    @Override
    public void onConquista_Completed(List<Conquista_NG> marcas, List<Conquista_NG> insignias, List<Conquista_NG> fitas) {
        mMarcas = marcas;
        mInsignias = insignias;
        mFitas = fitas;
        adapter = new Adapter_Marca_Insignia(Fita_Marca_Insignia.this, mMarcas, 0);
        rcv_Conquista.setAdapter(adapter);
    }

    @Override
    public void marca_Selected(String url_selected) {
        Picasso.get()
                .load(url_selected)
                .into(img_Marca);
        Marca = url_selected;
    }

    @Override
    public void fita_Selected(String url_selected) {
        Picasso.get()
                .load(url_selected)
                .into(img_Fita);
        Fita = url_selected;
    }

    @Override
    public void insignia_Selected(String url_selected) {
        Picasso.get()
                .load(url_selected)
                .into(img_Insignia);
        Insignia = url_selected;
    }
}

class get_Conquistas extends AsyncTask<Void, Void, Void> {
    private Activity mContext;
    private ProgressDialog dialog;
    private List<Conquista_NG> mMarcas, mInsignias, mFitas;
    private IConquista_Result _callback;

    public get_Conquistas(Activity mContext) {
        this.mContext = mContext;
        this._callback = (IConquista_Result) mContext;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(mContext);
        dialog.setMessage("carregando...");
        dialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(mContext);
            databaseAccess.open();

            mMarcas = databaseAccess.Pesquisar_Marcas();
            mInsignias = databaseAccess.Pesquisar_Insignias();
            mFitas = databaseAccess.Pesquisar_Fitas();

            databaseAccess.close();

        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (dialog.isShowing())
            dialog.dismiss();
        _callback.onConquista_Completed(mMarcas, mInsignias, mFitas);
    }
}