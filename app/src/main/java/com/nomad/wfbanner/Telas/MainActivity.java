package com.nomad.wfbanner.Telas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.nomad.wfbanner.R;

public class MainActivity extends AppCompatActivity {

    Button btn_Gerar, btn_Wf_World, btn_Flappy_Doge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Gerar = findViewById(R.id.btn_Create_Banner);
        btn_Wf_World = findViewById(R.id.btn_WF_World);
        btn_Flappy_Doge = findViewById(R.id.btn_Flappy_Doge);

        btn_Gerar.setOnClickListener(v -> {
            Intent i = new Intent(this, Nome_E_Cla.class);
            startActivity(i);
        });
        btn_Flappy_Doge.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.nomad.flappydoge");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        btn_Wf_World.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=wfworld.com.warfaceworld");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

    }

}
