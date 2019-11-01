package br.com.team.ordenador_numerico.aplicacao;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import br.com.team.ordenador_numerico.infraestrutura.gerador_arquivo.GeradorArquivo;
import br.com.team.ordenador_numerico.negocio.GeradorCoordenada;
import br.com.team.ordenador_numerico.negocio.algoritmos.*;

public class Apresentacao {
	public static void main(String[] args) {
		int tamanhoArquivo = 1000;
		String pathOrdenado = "C:\\Temp\\Coordenadas\\Ordenado\\";
		String pathDesordenado = "C:\\Temp\\Coordenadas\\Desordenado\\";

		File pastas = new File(pathOrdenado);
		pastas.mkdirs();
		File diretorio = new File(pathDesordenado);
		diretorio.mkdirs();

		GeradorArquivo geradorArquivoDesordenado = new GeradorArquivo(pathDesordenado);
		GeradorArquivo geradorArquivoOrdenado = new GeradorArquivo(pathOrdenado);

		GeradorCoordenada geradorCoordenadaQuickSort = new GeradorCoordenada(tamanhoArquivo);
		GeradorCoordenada geradorCoordenadaMergeSort = new GeradorCoordenada(tamanhoArquivo);
		GeradorCoordenada geradorCoordenadaHeapSort = new GeradorCoordenada(tamanhoArquivo);

		geradorCoordenadaQuickSort.gerarCoordenadas();
		List<Double> coordenadasGeradasQuickSort = geradorCoordenadaQuickSort.getCoordenadas();

		geradorCoordenadaMergeSort.gerarCoordenadas();
		List<Double> coordenadasGeradasMergeSort = geradorCoordenadaMergeSort.getCoordenadas();

		geradorCoordenadaHeapSort.gerarCoordenadas();
		List<Double> coordenadasGeradasHeapSort = geradorCoordenadaHeapSort.getCoordenadas();

		geradorArquivoDesordenado.gerarArquivoCoordenadaDesordenada(coordenadasGeradasQuickSort,
				"QuickSort" + tamanhoArquivo);
		geradorArquivoDesordenado.gerarArquivoCoordenadaDesordenada(coordenadasGeradasMergeSort,
				"MergeSort" + tamanhoArquivo);
		geradorArquivoDesordenado.gerarArquivoCoordenadaDesordenada(coordenadasGeradasHeapSort,
				"HeapSort" + tamanhoArquivo);

		double[] arrQuick = listaParaArray(coordenadasGeradasQuickSort);
		double[] arrMerge = listaParaArray(coordenadasGeradasMergeSort);
		double[] arrHeap = listaParaArray(coordenadasGeradasHeapSort);

		QuickSort quickSort = new QuickSort(arrQuick);
		MergeSort mergeSort = new MergeSort(arrMerge);
		HeapSort heapSort = new HeapSort(arrHeap);

		long tempoExecQuickSort = quickSort.calcularTempoAlgoritmo();
		long tempoExecMergeSort = mergeSort.calcularTempoAlgoritmo();
		long tempoExecHeapSort = heapSort.calcularTempoAlgoritmo();

		System.out.println("QuickSort: " + tempoExecQuickSort + "ms");
		System.out.println("MergeSort: " + tempoExecMergeSort + "ms");
		System.out.println("HeapSort: " + tempoExecHeapSort + "ms");

		geradorArquivoOrdenado.gerarArquivoOrdenado(arrQuick, "QuickSort" + tamanhoArquivo);
		geradorArquivoOrdenado.gerarArquivoOrdenado(arrMerge, "MergeSort" + tamanhoArquivo);
		geradorArquivoOrdenado.gerarArquivoOrdenado(arrHeap, "HeapSort" + tamanhoArquivo);
	}

	private static double[] listaParaArray(List<Double> coordenadasGeradas) {
		Double[] arrDouble = coordenadasGeradas.toArray(new Double[coordenadasGeradas.size()]);
		return ArrayUtils.toPrimitive(arrDouble);
	}
}