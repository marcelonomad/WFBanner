package com.nomad.wfbanner.Negocio;

public class Background_NG {
    private String Nome, URL;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Background_NG(String nome, String url) {
        Nome = nome;

        URL = url;
    }
}
