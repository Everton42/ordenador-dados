package br.com.team.ordenador_numerico.negocio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GeradorCoordenada {
	private double latitude;
	private double longitude;
	private int quantidade;
	private List<String> coordenadas = new ArrayList<>();

	private static final int COORD_X = 180;
	private static final int COORD_Y = 90;

	public GeradorCoordenada(int qtd) {
		setQuantidade(qtd);
	}

	private double gerarCoordenadaAleatoria(int n) {
		double coordenada = Math.random() * ((n + n)) - n; // TODO verificar se ha erro
		BigDecimal bd = BigDecimal.valueOf(coordenada).setScale(6, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
	}

	public void gerarCoordenadas() {
		int i = 0;
		while (i <= getQuantidade()) {
			setLatitude(gerarCoordenadaAleatoria(COORD_Y));
			setLongitude(gerarCoordenadaAleatoria(COORD_X));
			//String coordenada = String.valueOf(getLatitude()) + " , " + String.valueOf(getLongitude());
			//setCoordenadas(coordenada);
			i++;
		}
	}

	public List<String> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas.add(coordenadas);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
