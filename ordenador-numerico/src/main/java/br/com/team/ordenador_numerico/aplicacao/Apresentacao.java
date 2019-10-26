package br.com.team.ordenador_numerico.aplicacao;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import br.com.team.ordenador_numerico.infraestrutura.gerador_arquivo.GeradorArquivo;
import br.com.team.ordenador_numerico.negocio.GeradorCoordenada;
import br.com.team.ordenador_numerico.negocio.algoritmos.QuickSort;

public class Apresentacao {
	public static void main(String[] args) {
		String path = "C:\\Temp\\Coordenadas\\";
		File pastas = new File(path);
		pastas.mkdirs();

		GeradorCoordenada geradorCoordenada = new GeradorCoordenada(10);
		geradorCoordenada.gerarCoordenadas(); 
		List<Double> coordenadasGeradas = geradorCoordenada.getCoordenadas();

		GeradorArquivo geradorArquivo = new GeradorArquivo(path);

		int contador = 0;
		double latitude = 0;
		double longitude = 0;
		for (double coordenada : coordenadasGeradas) { // TODO Logica temporaria, separar bloco da apresentacao
			contador++;

			if (contador == 1) {
				latitude = coordenada;
				continue;
			}
			longitude = coordenada;

			String coordenadas = geradorCoordenada.formataCoordenadas(latitude, longitude);
			geradorArquivo.gravarTexto("arquivo1000", coordenadas);
			contador = 0;
		}

		Double[] arrDouble = coordenadasGeradas.toArray(new Double[coordenadasGeradas.size()]);
		double[] arrCoordenadas = ArrayUtils.toPrimitive(arrDouble);

		QuickSort qk = new QuickSort(arrCoordenadas);
		long tempoExec = qk.calcularTempoAlgoritmo();

		System.out.println(tempoExec);

		contador = 0;
		StringBuilder coordenadaOrdenadas = new StringBuilder();
		for (double coordenada : arrCoordenadas) { // TODO Logica temporaria, separar bloco da apresentacao
			contador++;

			if (contador < 5) { // corrigir 
				coordenadaOrdenadas.append(String.valueOf(coordenada+", "));
				continue;
			}
			coordenadaOrdenadas.append(String.valueOf(", "+coordenada));
			geradorArquivo.gravarTexto("arquivo1000-QuickSort", coordenadaOrdenadas.toString()); // grava coordenadas ordenadas geradas no arquivo
			contador = 0;
			coordenadaOrdenadas.setLength(0);
		}
	}
}
