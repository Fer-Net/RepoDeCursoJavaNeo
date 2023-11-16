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
         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
         //string response.body()
    }
}

