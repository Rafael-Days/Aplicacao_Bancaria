package org.example;

import org.example.Enum.EstadoCivil;
import org.example.Enum.TipoPessoa;

public class Pessoa {
    private TipoPessoa tipoPessoa;
    private EstadoCivil estadoCivil;
    private String nome;

    public Pessoa(TipoPessoa tipoPessoa, EstadoCivil estadoCivil, String nome) {
        this.tipoPessoa = tipoPessoa;
        this.estadoCivil = estadoCivil;
        this.nome = nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getNome() {
        return nome;
    }
}
