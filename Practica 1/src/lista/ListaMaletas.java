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
		return (int) inicio.getObjeto();
	}
	
	public int getFinal() {
		return (int) fin.getObjeto();
	}
	
	public void eliminarMaleta(int index) {
		eliminar(index);
	}
	
	public void printMaletas(JTextArea txt) {
		Nodo temp = inicio;
			txt.append("\nINICIO: " + getInicio());
			txt.append("\n FIN: " + getFinal()) ;
		do {
			txt.append("\nMALETA: " + temp.getObjeto());			
			temp = temp.siguiente;
		}
		while(temp!=inicio);
	}
}
