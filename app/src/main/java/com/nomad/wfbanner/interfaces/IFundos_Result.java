package com.nomad.wfbanner.interfaces;

import com.nomad.wfbanner.negocio.Background_NG;

import java.util.List;

public interface IFundos_Result {
    void onCompleted(List<Background_NG> fundos);
}
