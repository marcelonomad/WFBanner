package com.nomad.wfbanner.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.nomad.wfbanner.R;

public class Nome_E_Cla extends AppCompatActivity {
    Button btn_Proximo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_e_cla);

        btn_Proximo = findViewById(R.id.btn_Nome_Cla_Proximo);

        btn_Proximo.setOnClickListener(v -> {
            Intent i = new Intent(this, Fita_Marca_Insignia.class);
            startActivity(i);
        });

    }
}
