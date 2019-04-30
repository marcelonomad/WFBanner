package com.nomad.wfbanner.interfaces;

import com.nomad.wfbanner.negocio.Conquista_NG;

import java.util.List;

public interface IConquista_Result {
    void onConquista_Completed(List<Conquista_NG> marcas, List<Conquista_NG> insignias, List<Conquista_NG> fitas);
}
