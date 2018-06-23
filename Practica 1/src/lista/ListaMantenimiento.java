package lista;

import javax.swing.JTextArea;
import aeropuerto.*;

public class ListaMantenimiento extends ListaSimple{
	private boolean x;
	
	public ListaMantenimiento() {
		super();
	}
	
	public void setMantenimiento(boolean estado, Avion avion) {
		Mantenimiento nuevo = new Mantenimiento(estado,avion);
	}
	
	public void addAviones(Avion avion) {
		for(int i=0 ; i<getSize();i++) {
			x=false;
			Mantenimiento m = (Mantenimiento)getElemento(i);
			if(m.getEstado()) {
				m.setEstado(false);
				m.setAvion(avion);
				x=true;
				return;
			}
			else {
				x=false;
			}
		}
	}	
	
	public void iniciarLista() {
		Mantenimiento nuevo = new Mantenimiento(true,null);
		insertarInicio(nuevo);
	}
	
	public void bajarTurno() {
		for(int i=0 ; i<getSize();i++) {
			Mantenimiento m = (Mantenimiento)getElemento(i);
			if(m.getAvion()!=null)
			m.getAvion().setTurnosMantenimiento(m.getAvion().getTurnosMantenimiento()-1);
		}
	}
	
	public void terminaMantenimiento() {
		for(int i=0 ; i<getSize();i++) {
			Mantenimiento m = (Mantenimiento)getElemento(i);
			if(m.getAvion()!=null) {
				if(m.getAvion().getTurnosMantenimiento()<=0) {
					m.setAvion(null);
					m.setEstado(true);
				}
			}
		}
	}
	
	public boolean getEstado() {
		return x;
	}
			
	public void printListaMantenimiento(JTextArea txt) {
		for(int i=0 ; i<getSize();i++) {
			Mantenimiento m = (Mantenimiento)getElemento(i);
			if(m.getAvion()==null) {
				txt.append("\nESTACION " + (i+1));
				txt.append("\n	ESTADO: " + m.getDisponible() + "\n");
			}
			else {
				txt.append("\nESTACION " + (i+1));
				txt.append("\n	ESTADO: " + m.getDisponible() + m.getAvion());
			}
		}
	}
}
