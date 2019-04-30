package com.nomad.wfbanner.telas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.nomad.wfbanner.adapter.Adapter_Background;
import com.nomad.wfbanner.interfaces.IFundos_Result;
import com.nomad.wfbanner.negocio.Background_NG;
import com.nomad.wfbanner.negocio.Database.DatabaseAccess;
import com.nomad.wfbanner.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Escolher_Fundo extends AppCompatActivity implements IFundos_Result {

    RecyclerView rcv_Fundo;
    List<Background_NG> fundos;
    Adapter_Background adapter_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_fundo);
        rcv_Fundo = findViewById(R.id.rcv_Imagem);

        adapter_background = new Adapter_Background(Escolher_Fundo.this, new ArrayList<>(0));
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcv_Fundo.setLayoutManager(layoutManager);
        rcv_Fundo.setAdapter(adapter_background);
        new getFundos(this).execute();

    }


    @Override
    public void onCompleted(List<Background_NG> fundos) {
        this.fundos = fundos;
        adapter_background = new Adapter_Background(Escolher_Fundo.this, this.fundos);
        rcv_Fundo.setAdapter(adapter_background);
    }
}

class getFundos extends AsyncTask<Void, Void, Void> {

    private Activity mContext;
    private ProgressDialog dialog;
    private List<Background_NG> mfundos;
    private IFundos_Result _callback;

    public getFundos(Activity mContext) {
        this.mContext = mContext;
        this._callback = (IFundos_Result) mContext;
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
            mfundos = databaseAccess.Pesquisar_Fundos();
            Collections.reverse(mfundos);
            databaseAccess.close();

        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (dialog.isShowing())
            dialog.dismiss();
        _callback.onCompleted(mfundos);
    }
}
