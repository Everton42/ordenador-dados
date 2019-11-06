package br.com.team.ordenador_numerico.negocio;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import br.com.team.ordenador_numerico.infraestrutura.gerador_arquivo.GeradorArquivo;
import br.com.team.ordenador_numerico.negocio.algoritmos.HeapSort;
import br.com.team.ordenador_numerico.negocio.algoritmos.MergeSort;
import br.com.team.ordenador_numerico.negocio.algoritmos.QuickSort;

public class ProcessoOrdenacao {

	private int qtdCoord;
	private String nomeArquivo;
	private static final String PATHORDENADO = "C:\\Temp\\Coordenadas\\Ordenado\\";
	private static final String PATHDESORDENADO = "C:\\Temp\\Coordenadas\\Desordenado\\";

	public ProcessoOrdenacao(String inputNomeArquivo, int inputTamanhoArquivo) {
		setNomeArquivo(inputNomeArquivo);
		setQtdCoord(inputTamanhoArquivo);
	}

	public String iniciar() {

		File pastas = new File(PATHORDENADO);
		pastas.mkdirs();
		File diretorio = new File(PATHDESORDENADO);
		diretorio.mkdirs();

		GeradorArquivo geradorArquivoDesordenado = new GeradorArquivo(PATHDESORDENADO);
		GeradorArquivo geradorArquivoOrdenado = new GeradorArquivo(PATHORDENADO);

		GeradorCoordenada geradorCoordenada = new GeradorCoordenada(getQtdCoord());

		geradorCoordenada.gerarCoordenadas();
		List<Double> coordenadasGeradas = geradorCoordenada.getCoordenadas();

		geradorArquivoDesordenado.gerarArquivoCoordenadaDesordenada(coordenadasGeradas, getNomeArquivo());

		double[] arr = listaParaArray(coordenadasGeradas);
		double[] arrQuick = arr.clone();
		double[] arrMerge = arr.clone();
		double[] arrHeap = arr.clone();

		QuickSort quickSort = new QuickSort(arrQuick);
		MergeSort mergeSort = new MergeSort(arrMerge);
		HeapSort heapSort = new HeapSort(arrHeap);

		long tempoExecQuickSort = quickSort.calcularTempoAlgoritmo();
		long tempoExecMergeSort = mergeSort.calcularTempoAlgoritmo();
		long tempoExecHeapSort = heapSort.calcularTempoAlgoritmo();

		geradorArquivoOrdenado.gerarArquivoOrdenado(arrQuick, getNomeArquivo() + "QuickSort");
		geradorArquivoOrdenado.gerarArquivoOrdenado(arrMerge, getNomeArquivo() + "MergeSort");
		geradorArquivoOrdenado.gerarArquivoOrdenado(arrHeap, getNomeArquivo() + "HeapSort");

		StringBuilder resultadoExecucoes = new StringBuilder();
		String ms = "ms \n";
		resultadoExecucoes.append("QuickSort: " + tempoExecQuickSort + ms);
		resultadoExecucoes.append("MergeSort: " + tempoExecMergeSort + ms);
		resultadoExecucoes.append("HeapSort: " + tempoExecHeapSort + ms);

		return resultadoExecucoes.toString();
	}

	private String getNomeArquivo() {
		return nomeArquivo;
	}

	private static double[] listaParaArray(List<Double> coordenadasGeradas) {
		Double[] arrDouble = coordenadasGeradas.toArray(new Double[coordenadasGeradas.size()]);
		return ArrayUtils.toPrimitive(arrDouble);
	}

	private int getQtdCoord() {
		return qtdCoord;
	}

	private void setQtdCoord(int inputTamanhoArquivo) {
		qtdCoord = inputTamanhoArquivo;
	}

	private void setNomeArquivo(String inputNomeArquivo) {
		nomeArquivo = inputNomeArquivo;
	}
}
