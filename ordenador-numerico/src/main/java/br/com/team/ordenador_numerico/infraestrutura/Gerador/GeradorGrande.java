package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.FileNotFoundException;

public class GeradorGrande extends Gerador {
	
	private int tamanho = 1000000;
	private String nome = "\\BigCoordenate.txt";
	
	public GeradorGrande() throws FileNotFoundException {
		gravarCoordenadas(tamanho, nome);
	}
	
}
