package lista;

public class Cola extends Lista{	
	int tam=size;
	
	public Cola() {
		super();
		
		tam=size;
	}
		
	public void display() {
		
	}
			
	public void insertar(Object objeto) {
		Nodo nuevo = new Nodo(objeto);
		
		if(estaVacia()) {
			inicio = nuevo;
		}
		else {
			fin.siguiente=nuevo;
		}
		fin=nuevo;
		tam++; //TAMAÑO
	}
	
	public Object quitar() {
		if(estaVacia()) {
			return null;
		}		
		Object aux = inicio.getObjeto();
		inicio = inicio.siguiente;
		tam--; //TAMAÑO
		return aux;
	}
	
	public Object inicioCola() {
		return inicio.getObjeto();
	}
	
	public Object getElemento(int indice) {
		indice = tam-indice-1;
		int cont =0;
		Nodo temp = inicio;
		
		while(cont<indice) {
			temp = temp.getSiguiente();
			cont++;
		}
		return temp.getObjeto();
	}
	
	public int tamCola() {
		return tam;
	}
}
