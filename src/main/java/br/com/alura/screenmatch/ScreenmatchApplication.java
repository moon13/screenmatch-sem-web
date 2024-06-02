package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoAPI;
import service.ConverteDados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException, InterruptedException {
		System.out.println("Primeiro programa spring sem web");
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);


		/*Scanner leitura = new Scanner(System.in);
			System.out.println("Digite um filme para busca: ");
			var busca = leitura.nextLine();

			String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=6585022c";

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(endereco))
					.build();
			HttpResponse<String> response = client
					.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());*/

	}
}
