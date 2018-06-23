package lista;

public class ListaDoble extends Lista{
	
	
	public ListaDoble() {
		super();
	}
	
	public void display() {
		
	}
	
	public void insertarInicio(Object objeto) {
		if(inicio==null) {
			inicio = new Nodo(objeto,null,null);
			fin = inicio;
		}
		else {
			Nodo nuevo = new Nodo(objeto,null,inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
		size++;
	}
	
	public void insertarFin(Object objeto) {
		if(inicio ==null) {
			inicio = new Nodo(objeto,null,null);
			fin=inicio;
		}
		else {
			Nodo nuevo = new Nodo(objeto,fin,null);
			fin.setSiguiente(nuevo);
			fin = nuevo;
		}
		size++;
	}
	
	public Object getElemento(int indice) {
		indice = size - indice-1;
		int cont = 0;
		Nodo temporal = inicio;
		
		while(cont< indice) {
			temporal = temporal.getSiguiente();
			cont++;
		}
		return temporal.getObjeto();
	}	
	
	public void eliminarElemento(int indice) {
		indice = size - indice-1;
		if(indice==0) {
			inicio = inicio.getSiguiente();
		}
		else {
			int cont =0;
			Nodo temp = inicio;
			while(cont< indice-1) {
				temp = temp.getSiguiente();
				cont++;
			}
			temp.setSiguiente(temp.getSiguiente());
		}
		size--;
	}	
}
