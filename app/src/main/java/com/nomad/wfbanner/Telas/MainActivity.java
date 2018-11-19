package com.nomad.wfbanner.Telas;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.nomad.wfbanner.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity {

    Button btn_Gerar, btn_Wf_World, btn_Flappy_Doge;
    ConstraintLayout cst_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Gerar = findViewById(R.id.btn_Create_Banner);
        btn_Wf_World = findViewById(R.id.btn_WF_World);
        btn_Flappy_Doge = findViewById(R.id.btn_Flappy_Doge);
        cst_Main = findViewById(R.id.cst_Main);

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


        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Permissões")
                    .setMessage("Dê permissão para o aplicativo funcionar corretamente!")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
                            rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                    .subscribe();
                        }
                    })
                    .setNegativeButton(android.R.string.no, (dialog, which) -> {
                        Snackbar snackbar = Snackbar.make(cst_Main, "Permissões não concedidas. O aplicativo não funcionará.", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


        }


    }

}
