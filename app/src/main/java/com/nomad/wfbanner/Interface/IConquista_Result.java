package com.nomad.wfbanner.Interface;

import com.nomad.wfbanner.Negocio.Conquista_NG;

import java.util.List;

public interface IConquista_Result {
    void onConquista_Completed(List<Conquista_NG> marcas, List<Conquista_NG> insignias, List<Conquista_NG> fitas);
}
