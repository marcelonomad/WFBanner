package com.nomad.wfbanner.Negocio.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nomad.wfbanner.Negocio.Background_NG;
import com.nomad.wfbanner.Negocio.Conquista_NG;
import com.nomad.wfbanner.Negocio.Patente_NG;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public List<Conquista_NG> Pesquisar_Marcas() {
        List<Conquista_NG> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT nome, descricao, imagem FROM Marcas", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Conquista_NG(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Conquista_NG> Pesquisar_Insignias() {
        List<Conquista_NG> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT nome, descricao, imagem FROM Insignias", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Conquista_NG(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Conquista_NG> Pesquisar_Fitas() {
        List<Conquista_NG> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT nome, descricao, imagem FROM Fitas", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Conquista_NG(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Patente_NG> Pesquisar_Patentes() {
        List<Patente_NG> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT nome, numero, imagem FROM Patentes", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Patente_NG(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Background_NG> Pesquisar_Fundos() {
        List<Background_NG> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Nome, URL from Background", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Background_NG(cursor.getString(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

}
