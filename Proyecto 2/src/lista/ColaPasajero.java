package lista;
import javax.swing.JTextArea;

import aeropuerto.*;

public class ColaPasajero extends Cola {

	public ColaPasajero() {
		super();
	}
	
	public void setPasajero(int numero,int maletas, int documentos,int turnosRegistro) {
		Pasajero pasajero = new Pasajero(numero,maletas,documentos,turnosRegistro);
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
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Pasajero p = (Pasajero)aux.getObjeto();
				txt.append("\nPASAJERO: " + p.getNumero() +  "\n");
				txt.append("	MALETAS: " + p.getMaletas() + "\n 	DOCUMENTOS: " + p.getDocumentos() + "\n 	TURNOS REGISTRO: " + p.getTurnosRegistro() + "\n");
				aux = aux.siguiente;
			}
		}
	}
	
	public void printPasajero() {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Pasajero p = (Pasajero)aux.getObjeto();
				System.out.println("\nPASAJERO: " + p.getNumero() +  "\n");
				System.out.println("	MALETAS: " + p.getMaletas() + "\n 	DOCUMENTOS: " + p.getDocumentos() + "\n 	TURNOS REGISTRO: " + p.getTurnosRegistro() + "\n");
				aux = aux.siguiente;
			}
		}
	}
}
