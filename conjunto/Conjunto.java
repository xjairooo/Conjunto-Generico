package conjunto;

// Clase generica
public class Conjunto<T> {
	private T[] elementos;
	private int cantidadElementos;

	public Conjunto(int capacity) {
		elementos = (T[]) new Object[capacity]; // legal, but compiler warning
		cantidadElementos = 0;
	}

	/**
	 * Inserta un elemento al conjunto si no está presente y si hay espacio
	 * disponible.
	 * 
	 * Condiciones:
	 * - Si el elemento ya existe en el conjunto, no se realiza ninguna acción.
	 * - Si el conjunto ha alcanzado su capacidad máxima, no se realiza ninguna
	 * acción.
	 * 
	 * @param elemento El elemento que se desea insertar en el conjunto.
	 */
	public void insertarElemento(T elemento) {
		// Verifica que haya espacio disponible y que el elemento no esté ya en el
		// conjunto
		if (cantidadElementos < elementos.length && !buscarElemento(elemento)) {
			// Agrega el elemento al conjunto
			elementos[cantidadElementos] = elemento;
			// Incrementa el contador de elementos
			cantidadElementos++;
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
	private boolean buscarElemento(T elemento) {
		for (int i = 0; i < cantidadElementos; i++) {
			if (elementos[i].equals(elemento)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "";
	}

}
