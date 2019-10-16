package br.com.team.ordenador_numerico.aplicacao;

import java.io.File;
import java.util.List;

import br.com.team.ordenador_numerico.infraestrutura.gerador_arquivo.GeradorArquivo;
import br.com.team.ordenador_numerico.negocio.GeradorCoordenada;

public class Apresentacao {
	public static void main(String[] args) {
		String path = "C:\\Temp\\Coordenadas\\";
		File pastas = new File(path);
		pastas.mkdirs(); // cria o diretorio onde ficaram os arquivos.

		GeradorCoordenada geradorCoordenada = new GeradorCoordenada(10);
		geradorCoordenada.gerarCoordenadas(); // gera coordenadas
		List<String> coordenadasGeradas = geradorCoordenada.getCoordenadas();

		GeradorArquivo geradorArquivo = new GeradorArquivo(path);

		for (String coordenada : coordenadasGeradas) {
			geradorArquivo.gravarTexto("arquivo1000", coordenada); // grava coordenadas geradas no arquivo
		}

		// QuickSort qk = new QuickSort(); // precisa do array de numeros
		// System.out.println();

	}
}
