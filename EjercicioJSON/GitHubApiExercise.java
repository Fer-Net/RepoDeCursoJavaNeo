package main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GitHubApiExercise {
	
    public static void main(String[] args) {
        // URL de la API de GitHub para obtener información de un repositorio público
        String apiUrl = "https://api.github.com/repos/garnicaDavid/PronosticoPartido";
        // Realizar la solicitud HTTP utilizando HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        
         try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
			Repositorio repo = null;
			repo = objectMapper.readValue(response.body(), Repositorio.class);
			
			System.out.println(repo.getName());
			System.out.println(repo.getDescription());
			System.out.println(repo.getHtml_url());
         
         
      
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         //string response.body()
    }

}
