package br.com.team.ordenador_numerico.negocio.algoritmos;

import br.com.team.ordenador_numerico.negocio.CalcTempoExecucao;

public class MergeSort implements CalcTempoExecucao{

	private double []v;
	private double []w;
	
	public MergeSort(double []vet) {
		setVetor(vet);
	}
	
	/*Logica de ordenação*/
	
	public void mergeSort(double[] v, double[] w, int ini, int fim) {
		if(ini < fim) {
			int meio = (ini + fim) / 2;
			mergeSort(v, w, ini, meio);
			mergeSort(v, w, meio + 1, fim);
			intercalar(v, w, ini, meio, fim);
		}
	}
	
	public void intercalar(double[] v, double[] w, int ini, int meio, int fim) {
		for(int k = ini; k <= fim; k++) {
			w[k] = v[k];
		}
		
		int i = ini;
		int j = meio + 1;
		
		for(int k = ini; k <= fim; k++) {
			if(i > meio) v[k] = w[j++];
			else if (j > fim) v[k] = w[i++];
			else if (w[i] < w[j]) v[k] = w[i++];
			else v[k] = w[j++];
		}
	}
	
	/*Calcular o tempo decorrido*/
	
	public long calcularTempoAlgoritmo() {
		 long tempoInicial = System.currentTimeMillis();
		 mergeSort(v, w, 0, v.length-1);

		 return  System.currentTimeMillis() - tempoInicial;
	}
	
	/*Set & Get*/
	
	public void setVetor(double[] vet) {
		v = vet;
		w = new double[v.length];
	}
	
	public double[] getVetor() {
		return v;
	}
	
}
