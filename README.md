# Conversor de Moedas

## Descrição

Este é um conversor de moedas que permite ao usuário converter valores entre diferentes moedas em tempo real, utilizando uma API externa para obter as taxas de câmbio. O programa também conta quantas vezes o conversor foi utilizado.

## Funcionalidades

- Conversão entre várias moedas (Dólar, Peso Argentino, Real Brasileiro, Peso Colombiano).
- Atualização de taxas de câmbio em tempo real usando uma API externa.
- Contador de conversões realizadas.
- Tratamento de exceções para garantir a robustez do programa.

## Estrutura do Projeto
br/

  com/
  
    conversor/
    
      Principal.java
      
      api/
      
        ExchangeRateAPI.java
        
      modelo/
      
        Moeda.java
        
      servico/
      
        ServicoDeConversao.java
      visualizacao/
      
        VisualizacaoDoConversor.java
        
      util/
        
## Pré-requisitos
- Java 11 ou superior.
- Biblioteca Gson.
- Conexão com a internet para acessar a API de taxas de câmbio.

## Instalação
1 - Clone o repositório;

2 - Adicione a biblioteca Gson ao seu projeto;

3 - Compile o projeto;

4 - Execute o programa.

## Uso
1 - Ao executar o programa, você verá um menu com opções para conversão entre diferentes moedas.

2 - Escolha uma opção do menu.

3 - Insira o valor a ser convertido.

4 - O programa exibirá o valor convertido e o número de conversões realizadas até o momento.

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Contato
Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para abrir 
uma issue no repositório ou me contatar diretamente através do meu email.
