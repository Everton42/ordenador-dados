package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.FileNotFoundException;

public class GeradorPequeno extends Gerador {
	
	private int tamanho = 1000;
	private String nome = "\\SmallCoordenate.txt";
	
	public GeradorPequeno() throws FileNotFoundException {
		gravarCoordenadas(tamanho, nome);
	}
	
}
