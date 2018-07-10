package lista;

import javax.swing.JTextArea;

public class ListaMaletas extends ListaCircularDoble{

	public ListaMaletas() {
		super();
	}
	
	public void setMaleta(int numero) {
		ingresar(numero);
	}
	
	public int getInicio() {
		if(inicio!= null)
		return (int) inicio.getObjeto();
		else
			return 0;
	}
	
	public int getFinal() {
		return (int) fin.getObjeto();
	}
	
	public void eliminarMaleta(int cantidad) {
		while(cantidad!=0) {
			eliminar(1);
			cantidad--;
		}
	}
	
	public void printMaletas(JTextArea txt) {
		Nodo temp = inicio;
		if(inicio!=null) {
			txt.append("\nINICIO: " + getInicio());
			txt.append("\nFIN: " + getFinal()) ;
		do {
			txt.append("\nMALETA: " + temp.getObjeto());			
			temp = temp.siguiente;
		}
		while(temp!=inicio);
		}	
	}
}
