package br.com.team.ordenador_numerico.negocio.algoritmos;

import br.com.team.ordenador_numerico.negocio.CalcTempoExecucao;

public class HeapSort implements CalcTempoExecucao {
	private double[] numeros;

	public HeapSort(double[] arr) {
		setNumeros(arr);
	}

	public void heapSort(double[] arr) {
		int tamanho = arr.length;

		for (int i = tamanho / 2 - 1; i >= 0; i--)
			heapify(arr, tamanho, i);

		for (int i = tamanho - 1; i >= 0; i--) {
			double x = arr[0];
			arr[0] = arr[i];
			arr[i] = x;

			heapify(arr, i, 0);
		}
	}

	void heapify(double[] arr, int heapSize, int i) {
		int maior = i;
		int noEsquerda = 2 * i + 1;
		int noDireira = 2 * i + 2;

		if (noEsquerda < heapSize && arr[noEsquerda] > arr[maior])
			maior = noEsquerda;

		if (noDireira < heapSize && arr[noDireira] > arr[maior])
			maior = noDireira;

		if (maior != i) {
			double troca = arr[i];
			arr[i] = arr[maior];
			arr[maior] = troca;

			heapify(arr, heapSize, maior);
		}
	}

	public long calcularTempoAlgoritmo() {
		long tempoInicial = System.currentTimeMillis();
		heapSort(getNumeros());
		return System.currentTimeMillis() - tempoInicial;
	}

	private void setNumeros(double[] arr) {
		numeros = arr;
	}

	public double[] getNumeros() {
		return numeros;
	}
}
