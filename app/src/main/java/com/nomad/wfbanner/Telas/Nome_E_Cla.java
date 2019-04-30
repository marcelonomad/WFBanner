package com.nomad.wfbanner.telas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.nomad.wfbanner.adapter.Adapter_Patente;
import com.nomad.wfbanner.negocio.Database.DatabaseAccess;
import com.nomad.wfbanner.negocio.Patente_NG;
import com.nomad.wfbanner.R;

import java.util.List;

public class Nome_E_Cla extends AppCompatActivity {
    Button btn_Proximo;
    EditText txt_Nome, txt_Cla;
    Spinner spn_Patente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_e_cla);

        btn_Proximo = findViewById(R.id.btn_Nome_Cla_Proximo);
        txt_Cla = findViewById(R.id.txt_Cla);
        txt_Nome = findViewById(R.id.txt_Nome);
        spn_Patente = findViewById(R.id.spn_Patente);

        DatabaseAccess da = DatabaseAccess.getInstance(this);

        da.open();
        List<Patente_NG> patentes = da.Pesquisar_Patentes();
        da.close();

        Adapter_Patente adapter_patente = new Adapter_Patente(this, patentes);
        spn_Patente.setAdapter(adapter_patente);

        btn_Proximo.setOnClickListener(v -> {
            SharedPreferences.Editor edit_nome = getSharedPreferences("pref_Nome", MODE_PRIVATE).edit();
            edit_nome.putString("pref_Nome", txt_Nome.getText().toString());
            edit_nome.apply();

            SharedPreferences.Editor edit_cla = getSharedPreferences("pref_Cla", MODE_PRIVATE).edit();
            edit_cla.putString("pref_Cla", txt_Cla.getText().toString());
            edit_cla.apply();

            String url_Patente = ((Patente_NG) spn_Patente.getSelectedItem()).getImagem();
            SharedPreferences.Editor edit_patente = getSharedPreferences("pref_Rank", MODE_PRIVATE).edit();
            edit_patente.putString("pref_Rank", url_Patente);
            edit_patente.apply();

            Intent i = new Intent(this, Fita_Marca_Insignia.class);
            startActivity(i);
        });
    }

}
