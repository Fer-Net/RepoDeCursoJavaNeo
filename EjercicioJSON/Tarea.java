package main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tarea {

    public static void main(String[] args) {
        // URL de la API de GitHub para obtener información de un repositorio público
        String apiUrl = "https://api.github.com/repos/octocat/hello-world";
        // Realizar la solicitud HTTP utilizando HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            // Obtener la respuesta en formato JSON
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Analizar la respuesta JSON a un objeto Java utilizando jackson
    		ObjectMapper objectMapper = new ObjectMapper();

    		
    		Repositorio repositoryInfo = objectMapper.readValue(response.body(),Repositorio.class);

            // Imprimir información del repositorio
            System.out.println("Nombre del Repositorio: " + repositoryInfo.getName());
            System.out.println("Descripción: " + repositoryInfo.getDescription());
            System.out.println("URL del Repositorio: " + repositoryInfo.getHtml_url());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

