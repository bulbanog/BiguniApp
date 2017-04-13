package com.biguniunibratec.biguniapp;

/**
 * Created by Rayssa&Thiago on 12/04/2017.
 */

public class Carona {
    String nome;
    String origem;
    String destino;
    int vaga;

    public Carona(String nome, String origem, String destino, int vaga) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.vaga = vaga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getVaga() {
        return vaga;
    }

    public void setVaga(int vaga) {
        this.vaga = vaga;
    }
}
