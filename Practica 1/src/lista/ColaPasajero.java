package lista;
import javax.swing.JTextArea;

import aeropuerto.*;

public class ColaPasajero extends Cola {

	public ColaPasajero() {
		super();
	}
	
	public void setPasajero(int numero,int maletas, int documentos) {
		Pasajero pasajero = new Pasajero(numero,maletas,documentos);
		insertar(pasajero);
	}
	
	public void setPasajero(Pasajero nuevo) {
		insertar(nuevo);
	}	
	
	public void eliminarPasajero() {
		quitar();
	}
		
	public int getMaletas() {
		if(tamCola()!=0) {
			Pasajero p = (Pasajero)getElemento(tamCola()-1);
			return p.getMaletas();
		}
		return 0;
	}
	
	public void printPasajero(JTextArea txt) {
		for (int i = tamCola()-1; i >= 0; i--) {
			Pasajero p = (Pasajero)getElemento(i);
			txt.append("\nPASAJERO: " + p.getNumero() +  "\n");
			txt.append("	MALETAS: " + p.getMaletas() + "\n 	DOCUMENTOS: " + p.getDocumentos() + "\n");
		}
	}
	
}
