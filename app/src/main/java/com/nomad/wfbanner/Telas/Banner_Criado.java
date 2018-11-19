package com.nomad.wfbanner.Telas;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nomad.wfbanner.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Banner_Criado extends AppCompatActivity {

    ImageView img_Marca, img_Fita, img_Insignia, img_Patente, img_Fundo;
    TextView txt_Nome, txt_Cla;
    Button btn_Salvar;
    FrameLayout frameLayout;
    ConstraintLayout cst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_criado);

        img_Fundo = findViewById(R.id.img_Banner);
        img_Fita = findViewById(R.id.img_Fita);
        img_Marca = findViewById(R.id.img_Marca);
        img_Insignia = findViewById(R.id.img_Insignia);
        img_Patente = findViewById(R.id.img_Patente);
        txt_Cla = findViewById(R.id.txt_Cla);
        txt_Nome = findViewById(R.id.txt_Nome);
        btn_Salvar = findViewById(R.id.btn_Salvar);
        frameLayout = findViewById(R.id.frame_Banner);
        cst = findViewById(R.id.cst_Banner_Criado);

        SharedPreferences pref_nome = getSharedPreferences("pref_Nome", MODE_PRIVATE);
        SharedPreferences pref_cla = getSharedPreferences("pref_Cla", MODE_PRIVATE);
        SharedPreferences pref_Rank = getSharedPreferences("pref_Rank", MODE_PRIVATE);
        SharedPreferences pref_Marca = getSharedPreferences("pref_Marca", MODE_PRIVATE);
        SharedPreferences pref_Fita = getSharedPreferences("pref_Fita", MODE_PRIVATE);
        SharedPreferences pref_Insignia = getSharedPreferences("pref_Insignia", MODE_PRIVATE);
        SharedPreferences pref_Fundo = getSharedPreferences("pref_Fundo", MODE_PRIVATE);

        String nome = pref_nome.getString("pref_Nome", "");
        String cla = pref_cla.getString("pref_Cla", "");
        String patente = pref_Rank.getString("pref_Rank", "");
        String marca = pref_Marca.getString("pref_Marca", "");
        String fita = pref_Fita.getString("pref_Fita", "");
        String insignia = pref_Insignia.getString("pref_Insignia", "");
        String fundo = pref_Fundo.getString("pref_Fundo", "");


        if (marca.length() <= 0)
            marca = "https://wf.cdn.gmru.net/wiki/images/8/8a/Challenge_mark_sm_stage_17.png";
        if (fita.length() <= 0)
            fita = "https://wf.cdn.gmru.net/wiki/images/5/57/Challenge_strip_weapon10_12.png";
        if (insignia.length() <= 0)
            insignia = "https://wf.cdn.gmru.net/wiki/images/2/2d/Challenge_badge_weapon10_49.png";
        if (fundo.length() <= 0)
            fundo = "https://i.imgur.com/BKBjpoQ.png";


        txt_Cla.setText(cla);
        txt_Nome.setText(nome);
        Picasso.get()
                .load(patente)
                .into(img_Patente);
        Picasso.get()
                .load(marca)
                .into(img_Marca);
        Picasso.get()
                .load(fita)
                .into(img_Fita);
        Picasso.get()
                .load(insignia)
                .into(img_Insignia);
        Picasso.get()
                .load(patente)
                .into(img_Patente);
        Picasso.get()
                .load(fundo)
                .into(img_Fundo);


        btn_Salvar.setOnClickListener(v -> {
            Bitmap bitmap = Bitmap.createBitmap(frameLayout.getWidth(), frameLayout.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            frameLayout.draw(canvas);

            try {
                FileOutputStream output = new FileOutputStream(Environment.getExternalStoragePublicDirectory
                        (Environment.DIRECTORY_DCIM) + File.separator + nome.toLowerCase() + ".png");
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                output.close();
                Snackbar snackbar = Snackbar.make(cst, "Banner salvo na galeria!", Snackbar.LENGTH_LONG);
                snackbar.show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
