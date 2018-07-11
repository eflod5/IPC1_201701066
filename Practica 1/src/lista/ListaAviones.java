package lista;
import javax.swing.JTextArea;

import aeropuerto.*;

public class ListaAviones extends ListaDoble{
	
	
	public ListaAviones() {
		super();
	}	
	
	public void setAvion(int numero, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
		Avion nuevo = new Avion(numero,tipo,pasajeros,turnosDesabordaje,turnosMantenimiento);		
		insertar(nuevo);
	}	
	
	public Avion getAvion(int index) {
		Avion a = (Avion)getElemento(index);
		return a;
	}
	
	public void bajaTurno() {
		for(int i=0 ; i<getSize();i++) {
			Avion a = (Avion)getElemento(i);
			a.setTurnosDesabordaje(a.getTurnosDesabordaje()-1);
		}
	}
	
	public void eliminaAvion(ColaAvion cAvion) {
		for(int i = 0; i<getSize(); i++) {
			Avion a = (Avion)getElemento(i);
			if(a.getTurnosDesabordaje()<=0) {
				eliminarElemento(i);
				cAvion.setAvion(a);
			}			
		}
	}
			
	
	public void printAviones(JTextArea txt) {
		for(int i=0 ; i<getSize();i++) {
			Avion a = (Avion)getElemento(i);
			txt.append("\nAVION: " + a.getNumero() + "\n");
			txt.append("	TIPO: " + a.getTipo() + "\n 	PASAJEROS: " + a.getPasajeros()  + "\n 	TURNOS DESABORDAJE: " + a.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO " + a.getTurnosMantenimiento() + "\n");		
		}
	}
}
