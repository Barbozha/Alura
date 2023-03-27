package application;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		System.out.println(body);
		
		// extrair s� os dados que interessam (t�tulo, poster, classifica��o)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
	
		
		// exibir e manipular os dados 
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println("T�tulo: "+filme.get("title"));
			System.out.println("Imagem: "+filme.get("image"));
			System.out.println("Classifica��o: "+filme.get("imDbRating"));
			System.out.println();
		}

	}

}
