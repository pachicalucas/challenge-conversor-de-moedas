package br.com.conversor.vizualizacao;

import br.com.conversor.excecoes.Excecoes;
import br.com.conversor.modelo.Moeda;
import br.com.conversor.servico.ServicoDeConversao;

import java.text.DecimalFormat;
import java.util.Scanner;

public class VisualizacaoDoConversor {
    private ServicoDeConversao servico;
    private Scanner leitura;
    private DecimalFormat df;

    public VisualizacaoDoConversor(){
        this.servico = new ServicoDeConversao();
        this.leitura = new Scanner(System.in);
        this.df = new DecimalFormat("##.000");
    }

    public void exibirMenu(){
        int opcao = 0;
        while (opcao != 7){
            System.out.println("*****************************************************");
            System.out.println("Seja bem-vindo ao Conversor de Moedas ");
            System.out.println("1) Dólar => Peso Argentino");
            System.out.println("2) Peso Argentino => Dólar");
            System.out.println("3) Dólar => Real Brasileiro");
            System.out.println("4) Real Brasileiro => Dólar");
            System.out.println("5) Dólar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            opcao = leitura.nextInt();

            if (opcao >= 1 && opcao <= 6){
                processarOpcao(opcao);
            } else if (opcao == 7) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }

    private void processarOpcao(int opcao) {
        try {
            System.out.println("Qual valor deseja converter: ");
            String valorStr  = leitura.next().replace(',','.');
            double valor = Double.parseDouble(valorStr);
            Moeda de = null, para = null;

            switch (opcao){
                case 1:
                    de = new Moeda("USD");
                    para = new Moeda("ARS");
                    break;
                case 2:
                    de = new Moeda("ARS");
                    para = new Moeda("USD");
                    break;
                case 3:
                    de = new Moeda("USD");
                    para = new Moeda("BRL");
                    break;
                case 4:
                    de = new Moeda("BRL");
                    para = new Moeda("USD");
                    break;
                case 5:
                    de = new Moeda("USD");
                    para = new Moeda("COP");
                    break;
                case 6:
                    de = new Moeda("COP");
                    para = new Moeda("USD");
                    break;
            }

            double resultado = servico.converter(de, para, valor);
            System.out.println("Valor Convertido: " + df.format(resultado));
            System.out.println("Conversões realizadas: " + servico.getContadorDeConversoes());

        } catch (Exception e) {
            Excecoes.handle(e);
        }
    }
}
