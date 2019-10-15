package br.com.team.ordenador_numerico.aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.team.ordenador_numerico.infraestrutura.Gerador.GeradorGrande;
import br.com.team.ordenador_numerico.infraestrutura.Gerador.GeradorMedio;
import br.com.team.ordenador_numerico.infraestrutura.Gerador.GeradorPequeno;

public class classeInterfaceVisualExemplo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		File diretorio = new File("C:\\Temp\\Coordenadas");
		diretorio.mkdirs();
		
		GeradorPequeno s = new GeradorPequeno();
		GeradorMedio m = new GeradorMedio();
		GeradorGrande g = new GeradorGrande();
		
	}
}
