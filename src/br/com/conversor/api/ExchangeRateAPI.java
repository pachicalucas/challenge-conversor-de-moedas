package br.com.conversor.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {
    private HttpClient client;
    private Gson gson;
    private static final String API_KEY = "a0d2598a23971d0fc844bcdf";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public ExchangeRateAPI() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        if (fromCurrency.equals("USD")) {
            return getDirectExchangeRate(fromCurrency, toCurrency);
        } else {
            // Get the exchange rate from the original currency to USD first
            double toUsdRate = getDirectExchangeRate(fromCurrency, "USD");
            // Then get the exchange rate from USD to the target currency
            double usdToTargetRate = getDirectExchangeRate("USD", toCurrency);
            return toUsdRate * usdToTargetRate;
        }
    }

    private double getDirectExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String url = BASE_URL + API_KEY + "/latest/" + fromCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Falha ao obter resposta da API: " + response.statusCode());
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject ratesNode = jsonObject.getAsJsonObject("conversion_rates");

        if (ratesNode == null || !ratesNode.has(toCurrency)) {
            throw new RuntimeException("Falha ao analisar a taxa de câmbio da resposta");
        }

        return ratesNode.get(toCurrency).getAsDouble();
    }
}
