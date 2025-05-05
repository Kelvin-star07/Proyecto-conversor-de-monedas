/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poryecto.conversor.de.monedas.tasaCambio;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author LENOVO
 */
public class ManejadorTasaCambio {

    public double obtenerTasaDeCambios(String monedaBase, String monedaDestino) throws IOException {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/efd9bc701808197a59b55904/latest/" + monedaBase))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

            return conversionRates.get(monedaDestino).getAsDouble();


           

        } catch (InterruptedException | RuntimeException ex) {

            throw new RuntimeException("La operacion fue interrumpida" + ex.getMessage());

        }

    }

}
