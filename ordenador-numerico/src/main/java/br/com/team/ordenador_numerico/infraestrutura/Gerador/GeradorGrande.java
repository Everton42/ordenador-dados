package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeradorGrande extends Gerador{

	public GeradorGrande() throws FileNotFoundException {
		gravarCoordenadas();
	}

	public void gravarCoordenadas() throws FileNotFoundException {
		PrintWriter n = new PrintWriter(new File(diretorio + "\\BigCoordenate.txt"));
		int i = 0;
		while(i <= 1000000) {
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
