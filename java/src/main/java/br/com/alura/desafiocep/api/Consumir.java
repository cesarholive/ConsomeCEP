package br.com.alura.desafiocep.api;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.desafiocep.model.Endereco;

public class Consumir extends Endereco {

	public void buscaCep(String cep) throws IOException, InterruptedException {

		List<Endereco> meusEnderecos = new ArrayList<>();

		String enderecoApi = "https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(enderecoApi)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		String cepJson = response.body();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Endereco enderecos = gson.fromJson(cepJson, Endereco.class);

		meusEnderecos.add(enderecos);

		FileWriter gravar = new FileWriter("lista.json");
		gravar.write(gson.toJson(meusEnderecos));
		gravar.close();
		
		System.out.println(meusEnderecos);

	}
}
