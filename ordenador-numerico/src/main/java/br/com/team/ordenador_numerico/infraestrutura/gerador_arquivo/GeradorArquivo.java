package br.com.team.ordenador_numerico.infraestrutura.gerador_arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class GeradorArquivo {

	private String path;

	public GeradorArquivo(String path) {
		setPath(path);
	}

	public void gravarTexto(String nomeArquivo, String texto) {
		try (Writer writer = new BufferedWriter(new FileWriter(getPath()+nomeArquivo, true));) {
			writer.append(texto + "\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
