package br.com.team.ordenador_numerico.negocio.algoritmos;

import br.com.team.ordenador_numerico.negocio.CalcTempoExecucao;

public class QuickSort implements CalcTempoExecucao {

	private double []numeros;

	public QuickSort(double []arr) {
		setNumeros(arr);
	}

	private int particionar(double []arr, int esq, int dir) {
		int i = esq;
		int j = dir;
		double tmp;
		double pivot = arr[((esq + dir) / 2)];

		while (i <= j) {

			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j) {

				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	private void quickSort(double []arr, int esq, int dir) {

		int indice = particionar(arr, esq, dir);
		if (esq < indice - 1)
			quickSort(arr, esq, indice - 1);

		if (indice < dir)
			quickSort(arr, indice, dir);
	}

	public long calcularTempoAlgoritmo() {
		 long tempoInicial = System.currentTimeMillis();
		 quickSort(getNumeros(), 0, getNumeros().length-1);

		 return  System.currentTimeMillis() - tempoInicial;
	}
	
	public void setNumeros(double[] nmr) {
		numeros = nmr;
	}
	
	public double[] getNumeros() {
		return numeros;
	}
}
