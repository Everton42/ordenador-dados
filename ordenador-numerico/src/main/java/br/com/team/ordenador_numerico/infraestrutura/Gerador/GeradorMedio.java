package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.FileNotFoundException;

public class GeradorMedio extends Gerador {
	
	private int tamanho = 100000;
	private String nome = "\\MediumCoordenate.txt";
	
	public GeradorMedio() throws FileNotFoundException {
		gravarCoordenadas(tamanho, nome);
	}
	
}
