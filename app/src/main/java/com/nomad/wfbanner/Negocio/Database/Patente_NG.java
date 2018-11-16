package com.nomad.wfbanner.Negocio.Database;

public class Patente_NG {
    private String Nome, Numero, Imagem;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
        Imagem = imagem;
    }

    public Patente_NG(String nome, String numero, String imagem) {
        Nome = nome;
        Numero = numero;
        Imagem = imagem;
    }
}
