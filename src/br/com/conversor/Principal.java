package br.com.conversor;

import br.com.conversor.api.ExchangeRateAPI;
import br.com.conversor.vizualizacao.VisualizacaoDoConversor;

public class Principal {
    public static void main(String[] args) {
        VisualizacaoDoConversor menu= new VisualizacaoDoConversor();
        menu.exibirMenu();

    }
}

