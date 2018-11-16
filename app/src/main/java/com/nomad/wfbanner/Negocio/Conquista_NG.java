package com.nomad.wfbanner.Negocio;

public class Conquista_NG {
    private String Nome, Descricao, Imagem;

    public Conquista_NG(String nome, String descricao, String imagem) {
        this.Nome = nome;
        this.Descricao = descricao;
        this.Imagem = imagem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
        Imagem = imagem;
    }
}
