package br.com.team.ordenador_numerico.infraestrutura.gerador_arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import br.com.team.ordenador_numerico.negocio.GeradorCoordenada;

public class GeradorArquivo {

	private String path;

	public GeradorArquivo(String path) {
		setPath(path);
	}

	public void gerarArquivoCoordenadaDesordenada(List<Double> coordenadasGeradas, String nomeArquivo) {
		Iterator<Double> itr = coordenadasGeradas.iterator();
		while(itr.hasNext()) {
			double latitude = (double) itr.next();
			double longitude = (double) itr.next();
			String coordenadas = GeradorCoordenada.formataCoordenadas(latitude, longitude);
			gravarTexto(nomeArquivo, coordenadas);
		}
		
	}
	
	public void gerarArquivoOrdenado(double[] arrQuick, String nomeArquivo) {
		for(double arr: arrQuick) {
			gravarTexto(nomeArquivo, String.valueOf(arr));
		}
	}
	
	public void gravarTexto(String nomeArquivo, String texto) {
		try (Writer writer = new BufferedWriter(new FileWriter(getPath()+nomeArquivo, true));) {
			writer.append(texto + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
