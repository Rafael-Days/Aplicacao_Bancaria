package org.example.service;

import org.example.Conta;
import org.example.Enum.TipoConta;
import org.example.Pessoa;

public class ContaBancaria implements Conta {
    private Double saldoConta;
    private String numeroConta;
    private org.example.Pessoa Pessoa;
    private TipoConta tipoConta;
    private Boolean contaConjunta;

    public ContaBancaria(Double saldoConta, String numeroConta, Pessoa Pessoa, TipoConta tipoConta, Boolean contaConjunta) {
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
        this.Pessoa = Pessoa;
        this.tipoConta = tipoConta;
        this.contaConjunta = contaConjunta;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getPessoa() {
        return Pessoa;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Boolean getContaConjunta() {
        return contaConjunta;
    }

    @Override
    public Double saldoInicial(Double valor) {
        if (tipoConta == TipoConta.POUPANCA) {
            if (valor >= 50.0) {
                saldoConta = valor;
            } else {
                System.out.println("Uma conta poupança deve ter pelo menos R$ 50,00 de saldo inicial.");
            }
        } else {
            saldoConta = valor;
        }
        return saldoConta;
    }

    @Override
    public Double transacaoBancaria(Double valor) {
        if (valor >= 0 && valor <= saldoConta) {
            saldoConta -= valor;
            return saldoConta;
        } else {
            System.out.println("Não foi possível realizar essa transação.\n");
            return null;
        }
    }

    @Override
    public Double saldo(Double valor) {
        return this.saldoConta;
    }

    @Override
    public Double extrato(Double valor) {
        return this.saldoConta;
    }

    @Override
    public Double financiamento(Double valor) {
        Double taxaJuros = 0.08;
        valor = valor * taxaJuros;
        if (valor >= 0 && valor <= saldoConta) {
            saldoConta -= valor;
            return saldoConta;
        } else {
            System.out.println("Sem saldo suficiente.\n");
            return null;
        }
    }

    @Override
    public Double aplicacoes(Double valor) {
        Double taxaJuros = 0.06;
        if (valor >= 0) {
            valor = valor * taxaJuros;
            saldoConta += valor;
            return saldoConta;
        }else
            System.out.println("Não foi possível efetuar a aplicação.\n");
        return null;
    }
}
