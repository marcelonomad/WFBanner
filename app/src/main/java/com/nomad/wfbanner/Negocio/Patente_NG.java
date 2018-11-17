package com.nomad.wfbanner.Negocio;

public class Patente_NG {
    public String Nome, Numero, Imagem, Exp;

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

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public Patente_NG(String nome, String numero, String imagem) {

        Nome = nome;
        Numero = numero;
        Imagem = imagem;
    }
}
