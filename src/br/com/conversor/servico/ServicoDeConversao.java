package br.com.conversor.servico;

import br.com.conversor.api.ExchangeRateAPI;
import br.com.conversor.modelo.Moeda;

public class ServicoDeConversao {
    private ExchangeRateAPI api;
    private int contadorDeConversoes;

    public ServicoDeConversao(){
        this.api = new ExchangeRateAPI();
        this.contadorDeConversoes = 0;
    }

    public double converter(Moeda de, Moeda para, double valor) throws Exception {
        double taxa = api.getExchangeRate(de.getCodigo(), para.getCodigo());

        contadorDeConversoes++;
        return valor * taxa;
    }

    public int getContadorDeConversoes(){
        return contadorDeConversoes;
    }
}
