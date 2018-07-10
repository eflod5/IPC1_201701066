package lista;
import javax.swing.JTextArea;

import aeropuerto.*;

public class ListaAviones extends ListaDoble{
	
	
	public ListaAviones() {
		super();
	}	
	
	public void setAvion(int numero, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
		Avion nuevo = new Avion(numero,tipo,pasajeros,turnosDesabordaje,turnosMantenimiento);		
		insertarFin(nuevo);
	}	
	
	public Avion getAvion(int index) {
		Avion a = (Avion)getElemento(index);
		return a;
	}	
	
	public Nodo getPrimero() {
		return inicio;
	}
	
	public void bajaTurno() {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Avion a = (Avion)aux.getObjeto();
				a.setTurnosDesabordaje(a.getTurnosDesabordaje()-1);
				aux = aux.siguiente;
			}
		}
	}
		
	public void eliminaAvion(ColaAvion cAvion) {
		if(inicio!=null){
			Nodo aux = inicio;
			Nodo auxAnt = null;
			
			while(aux!=null) {
				Avion a = (Avion)aux.getObjeto();
				if(a.getTurnosDesabordaje()<=0) {
					if(auxAnt==null) {
						inicio = inicio.siguiente;
						aux.siguiente=null;
						aux = inicio;
						cAvion.setAvion(a);
					}
					else {						
						auxAnt.siguiente=aux.siguiente;
						aux.siguiente=null;
						aux = auxAnt.siguiente;
						cAvion.setAvion(a);
					}					
				}
				else {
					auxAnt = aux;
					aux = aux.siguiente;
				}
			}
		}
	}
	
	public void printAviones(JTextArea txt) {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Avion a = (Avion)aux.getObjeto();
				txt.append("\nAVION: " + a.getNumero() + "\n");
				txt.append("	TIPO: " + a.getTipo() + "\n 	PASAJEROS: " + a.getPasajeros()  + "\n 	TURNOS DESABORDAJE: " + a.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO " + a.getTurnosMantenimiento() + "\n");
				aux = aux.siguiente;
			}
		}
	}	
}
