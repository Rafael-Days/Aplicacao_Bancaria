package org.example;

import org.example.Enum.TipoConta;

public interface Conta {
    Double saldoInicial(Double valor);
    Double transacaoBancaria(Double valor);
    Double saldo(Double valor);
    Double extrato(Double valor);
    Double financiamento(Double valor);
    Double aplicacoes(Double valor);
}
