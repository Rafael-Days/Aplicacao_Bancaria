package org.example.service;

import org.example.Enum.EstadoCivil;
import org.example.Enum.TipoConta;
import org.example.Enum.TipoPessoa;
import org.example.Pessoa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaBancariaTest {

    ////////////////////////////////saldoInicialPoupanca
    @Test
    public void saldoInicialMaisDe50ReaisPoupanca(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(0.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.saldoInicial(60.00);

        assertEquals(60.00, resultado);
    }

    @Test
    public void saldoInicialMenosDe50ReaisPoupanca(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(0.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.saldoInicial(40.00);

        assertEquals(0, resultado);
    }

    ////////////////////////////////// transacaoBancaria
    @Test
    public void transacaoBancariaValorMaiorQueZeroEMenorQueSaldoConta(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.transacaoBancaria(40.00);

        assertEquals(30.00, resultado);
    }

    @Test
    public void transacaoBancariaValorMenorQueZeroEMenorQueSaldoConta(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.transacaoBancaria(-40.00);

        assertEquals(null, resultado);
    }

    @Test
    public void transacaoBancariaValorMaiorQueZeroEMaiorQueSaldoConta(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.transacaoBancaria(90.00);

        assertEquals(null, resultado);
    }

    @Test
    public void transacaoBancariaValorMenorQueZeroEMaiorQueSaldoConta(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.transacaoBancaria(90.00);

        assertEquals(null, resultado);
    }

    /////////////////financiamento
    @Test
    public void financiamentoComValorMaiorQueZeroEMenorQueSaldoConta() {
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.financiamento(50.00);

        assertEquals(66.00, resultado);
    }

    @Test
    public void financiamentoComValorMaiorQueZeroEMaiorQueSaldoConta() {
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.financiamento(80.00);

        assertEquals(63.6, resultado);
    }

    @Test
    public void financiamentoComValorMenorQueZeroEMenorQueSaldoConta() {
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.financiamento(-50.00);

        assertEquals(null, resultado);
    }

    @Test
    public void financiamentoComValorMenorQueZeroEMaiorQueSaldoConta() {
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.financiamento(-50.00);

        assertEquals(null, resultado);
    }

    //////////////// aplicacoes
    @Test
    public void aplicacoesComValorMaiorQueZero(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.aplicacoes(10.00);

        assertEquals(70.60, resultado);
    }

    @Test
    public void aplicacoesComValorMenorQueZero(){
        Pessoa pessoa = new Pessoa(TipoPessoa.PESSOA_FISICA, EstadoCivil.CASADO, "Valdir Silva");
        ContaBancaria contaBancaria = new ContaBancaria(70.00, "1111-11", pessoa, TipoConta.POUPANCA,false);

        Double resultado = contaBancaria.aplicacoes(-10.00);

        assertEquals(null, resultado);
    }
}
