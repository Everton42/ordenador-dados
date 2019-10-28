package br.com.team.ordenador_numerico.negocio.algoritmos;

public class MergeSort {

	public MergeSort() {
		
	}

	public void mergeSort(int[] v, int[] w, int ini, int fim) {
		if(ini < fim) {
			int meio = (ini + fim) / 2;
			mergeSort(v, w, ini, meio);
			mergeSort(v, w, ini + 1, meio);
			intercalar(v, w, ini, meio, fim);
		}
	}
	
	public void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
		
	}
	
}
