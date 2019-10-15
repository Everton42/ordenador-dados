package br.com.team.ordenador_numerico.infraestrutura.Gerador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Gerador {
	
	protected double Latitude;
	protected double Longitude;
	protected final String diretorio = "C:\\Temp\\Coordenadas";
	protected final int x = 180;
	protected final int y = 90;
	
	public Gerador() {
		
	}
	
	public double gerarCoordenadaAleatoria(int n) {
        double coordenada = Math.random()*((n + n)) - n;
        BigDecimal bd = new BigDecimal(coordenada).setScale(6, RoundingMode.HALF_EVEN);
        return coordenada = bd.doubleValue(); 
    }
	
	public void gravarCoordenadas(int tamanho, String nomeTxt) throws FileNotFoundException {
		PrintWriter n = new PrintWriter(new File(diretorio + nomeTxt));
		int i = 0;
		while(i <= tamanho) {
			Latitude = gerarCoordenadaAleatoria(y);
			Longitude = gerarCoordenadaAleatoria(x);
			n.write(Latitude + ", " + Longitude +"\n");
			n.flush();
			i++;
		} 
		n.close();
	}

}
