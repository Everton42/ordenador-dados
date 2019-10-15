package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeradorPequeno extends Gerador {
	
	public GeradorPequeno() throws FileNotFoundException {
		gravarCoordenadas();
	}
	
	public void gravarCoordenadas() throws FileNotFoundException {
		PrintWriter n = new PrintWriter(new File(diretorio + "\\SmallCoordenate.txt"));
		int i = 0;
		while(i <= 1000) {
			gerarLatitude();
			gerarLongitude();
			n.write(Latitude + ", " + Longitude +"\n");
			n.flush();
			i++;
		} 
		n.close();
		i = 0;
	}
	
	
}
