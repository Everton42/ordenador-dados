package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Gerador {
	
	protected double Latitude;
	protected double Longitude;
	protected String diretorio = "C:\\Temp\\Coordenadas"; 
	
	public Gerador() {
		
	}
	
	public void gerarLatitude() {
		Latitude = Math.random()*((90 + 90)) - 90;
		BigDecimal bd = new BigDecimal(Latitude).setScale(6, RoundingMode.HALF_EVEN);
		Latitude = bd.doubleValue(); 
	}
	
	public void gerarLongitude(){
		Longitude = Math.random()*((180 + 180)) - 180;
		BigDecimal bd = new BigDecimal(Longitude).setScale(6, RoundingMode.HALF_EVEN);
		Longitude = bd.doubleValue();
	}
	
	public abstract void gravarCoordenadas() throws FileNotFoundException;

}
