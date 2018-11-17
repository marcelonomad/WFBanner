package com.nomad.wfbanner.Interface;

import com.nomad.wfbanner.Negocio.Background_NG;

import java.util.List;

public interface IFundos_Result {
    void onCompleted(List<Background_NG> fundos);
}
