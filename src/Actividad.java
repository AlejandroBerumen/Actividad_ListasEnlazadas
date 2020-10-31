import java.util.LinkedList;
import java.util.Scanner;
class Nodo{
	private int dato;
	private Nodo nodoSiguiente;
	public Nodo() {}
	public Nodo(int dato) {
		this.dato = dato;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}	
}
class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	public ListaEnlazada() {
		nodoInicio = nodoFin = null;
	}
	public boolean listaVacia() {
		if(nodoInicio==null)
			return true;
		else
			return false;	
	}
	public void agregarElementoInicio(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if(nodoInicio==null) {
			nodoInicio = nodoFin = nuevoNodo;
		}else {
			 nuevoNodo.setNodoSiguiente(nodoInicio);
			 nodoInicio = nuevoNodo;
		}
	}
	public void agregarElementoFinal(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		nodoFin.setNodoSiguiente(nuevoNodo);
		nodoFin = nuevoNodo;
	}
	public void eliminarElementoInicio() {
		if(listaVacia()) {
			System.out.println("\nError al eliminar: La lista está vacía");
		}else if(nodoInicio==nodoFin) {
			nodoInicio = nodoFin = null;
		}else {
			Nodo nodoEliminado = nodoInicio;
			nodoInicio = nodoInicio.getNodoSiguiente();
			nodoEliminado = null;
			System.out.println("\nSe eliminó el elemento inicial con éxito");
		}
	}
	public void eliminarElementoFinal() {
		if(listaVacia()) {
			System.out.println("\nError al eliminar: La lista está vacía");
		}else if(nodoInicio==nodoFin) {
			nodoInicio = nodoFin = null;
		}else {
			Nodo nodoEliminado = nodoInicio;
			while(nodoEliminado.getNodoSiguiente()!=nodoFin) {
				nodoEliminado = nodoEliminado.getNodoSiguiente();
			}
			nodoFin = nodoEliminado;
			nodoFin.setNodoSiguiente(null);
			System.out.println("\nSe eliminó el elemento final con éxito");
		}
	}
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;	
		System.out.println();
		while(nodoActual != null) {
			System.out.print("["+nodoActual.getDato()+"] --> ");
			nodoActual = nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
	public int mostrarCantidadElementos() {
		int cantidad = 0;
		Nodo nodoActual = nodoInicio;		
		while(nodoActual != null) {
			cantidad++;
			nodoActual = nodoActual.getNodoSiguiente();
		}
		return cantidad;
	}
}
public class Actividad {
	public static void main(String[] args) {
	ListaEnlazada lista = new ListaEnlazada();
	Scanner x = new Scanner(System.in);
	int elec = 0;
	while(elec!=8) {
	System.out.println("\nPrograma de listas enlazadas\n1.- Verificar lista vacía\n2.- Mostrar elementos\n3.- Insertar elemento al inicio\n4.- Insertar elemento al final\n5.- Eliminar elemento al inicio\n6.- Eliminar elemento al final\n7.- Mostrar cantidad de elementos\n8.- Salir");
	elec = x.nextInt();
	switch(elec) {
	case 1:
		if(lista.listaVacia())
		System.out.println("\nLa lista está vacía");
		else
		System.out.println("\nLa lista contiene elementos");
		break;
	case 2:
		lista.mostrarElementos();
		break;
	case 3:
		System.out.println("\nInserte dato que desea agregar al inicio:");
		int dato = x.nextInt();
		lista.agregarElementoInicio(dato);
		break;
	case 4:
		System.out.println("\nInserte dato que desea agregar al final:");
		int dato2 = x.nextInt();
		lista.agregarElementoFinal(dato2);
		break;
	case 5:
		lista.eliminarElementoInicio();
		break;
	case 6:
		lista.eliminarElementoFinal();
		break;
	case 7:
		System.out.println("\nCantidad de elementos: "+lista.mostrarCantidadElementos());
		break;
	}
	}
	}
}