package br.com.alura.desafiocep.main;

import java.io.IOException;
import java.util.Scanner;

import br.com.alura.desafiocep.api.Consumir;
import br.com.alura.desafiocep.model.Endereco;

public class Principal {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Endereco endereco = new Endereco();
		Consumir con = new Consumir();
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Digite o cep por favor(Apenas números) ");
		String cep = leitura.nextLine();
		
		con.buscaCep(cep);
		
		
	}
	

}
