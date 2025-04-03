package conjunto;

// Clase generica
public class Conjunto<T> {
	private T[] data;
	private int p;

	public Conjunto(int capacity) {
		data = (T[]) new Object[capacity]; // legal, but compiler warning
		p = 0;
	}

	/**
	 * Inserta un elemento al conjunto si el mismo no esta
	 * Si se supera la capacidad del conjunto no hace nada
	 * 
	 */
	public void insertarElemento(T d) {
		if (p < data.length) {
			if (!find(d)) {
				data[p] = d;
				p++;
			}
		}
		
	}

	/**
	 * Retorna la cantidad de elementos de un conjunto
	 * 
	 */
	public int cardinalidad() {
		return 0;
	}

	/**
	 * Retorna un nuevo conjunto con la union del conjunto actual con el conjunto c
	 * 
	 */
	public Conjunto<T> union(Conjunto<T> c) {
		return null;
	}

	/**
	 * Retorna un nuevo conjunto con la interseccion del conjunto actual con el
	 * conjunto c
	 * 
	 */
	public Conjunto<T> interseccion(Conjunto<T> c) {
		return null;
	}

	/**
	 * Retorna si dos conjuntos tienen los mismos elementos
	 * 
	 */
	public boolean iguales(Conjunto<T> c) {
		return true;
	}

	/**
	 * Verifica si un elemento esta dentro del conjunto
	 * Retorna si un elemnto esta en el conjunto
	 * 
	 * @see insertarElemento
	 */
	private boolean find(T elemento) {
	
		return false;
	}

	@Override
	public String toString() {
		return "";
	}

}
