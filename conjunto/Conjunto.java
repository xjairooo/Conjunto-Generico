package conjunto;

// Clase generica
public class Conjunto<T> {
	private T[] elementos;
	private int cantidadElementos;

	/**
	 * Constructor de la clase Conjunto. Inicializa un conjunto vacio con una
	 * capacidad maxima de 10 elementos.
	 */
	public Conjunto(int capacidad) {
		elementos = (T[]) new Object[capacidad]; // Legal, pero lanza una advertencia del compilador
		cantidadElementos = 0; // Inicialmente no hay elementos en el conjunto
	}

	/**
	 * Inserta un elemento al conjunto si no está presente y si hay espacio
	 * disponible.
	 * 
	 * Condiciones:
	 * - Si el elemento ya existe en el conjunto, no se realiza ninguna accion.
	 * - Si el conjunto ha alcanzado su capacidad maxima, no se realiza ninguna
	 * accion.
	 * 
	 * @param elemento El elemento que se desea insertar en el conjunto.
	 */
	public void insertarElemento(T elemento) {
		// Verifica que haya espacio disponible y que el elemento no este ya en el
		// conjunto
		if (cantidadElementos < elementos.length && !buscarElemento(elemento)) {
			// Agrega el elemento al conjunto
			elementos[cantidadElementos] = elemento;
			// Incrementa el contador de elementos
			cantidadElementos++;
		}
	}

	/**
	 * @return la cantidad de elementos de un conjunto
	 */
	public int tamanioConjunto() {
		return cantidadElementos;
	}

	/**
	 * Crea un nuevo conjunto con la union del conjunto actual con otro conjunto.
	 * En esa union los elementos nos se repiten
	 * 
	 * @param otroConjunto El conjunto con el que se desea realizar la union
	 * @return Un nuevo conjunto que contiene la union de los elementos del conjunto
	 * 
	 */
	public Conjunto<T> union(Conjunto<T> otroConjunto) {
		// Creamos un un conjunto para la union con capacidad suficiente para ambos
		// conjuntos
		Conjunto<T> unionConjunto = new Conjunto<T>(this.cantidadElementos + otroConjunto.cantidadElementos);

		// Primero agregamos elementos del conjunto actual
		for (int i = 0; i < this.cantidadElementos; i++) {
			unionConjunto.insertarElemento(this.elementos[i]);
		}

		// Luego agregamos elementos del otro conjunto, evitando duplicados
		for (int i = 0; i < otroConjunto.cantidadElementos; i++) {
			T elemento = otroConjunto.elementos[i]; // Obtenemos el elemento del otro conjunto
			// Verificamos si el elemento ya existe en la union antes de agregarlo
			if (!unionConjunto.buscarElemento(elemento)) {
				unionConjunto.insertarElemento(elemento); // Agregamos el elemento a la union si no existe en ella
			}
		}
		return unionConjunto;
	}

	/**
	 * Crea un nuevo conjunto con la interseccion de los elementos del conjunto
	 * actual con otro conjunto.
	 * 
	 * @param otroConjunto El conjunto con el que se desea realizar la interseccion
	 * @return Un nuevo conjunto que contiene la interseccion de los elementos del
	 */
	public Conjunto<T> interseccion(Conjunto<T> otroConjunto) {
		// Creamos un nuevo conjunto para la interseccion
		Conjunto<T> interseccionConjunto = new Conjunto<T>(cantidadElementos + otroConjunto.cantidadElementos);

		for (int i = 0; i < cantidadElementos; i++) {
			T elemento = elementos[i]; // Obtenemos el elemento del conjunto actual

			// Verificamos si el elemento existe en el otro conjunto
			// Si existe, lo agregamos a la interseccion
			if (otroConjunto.buscarElemento(elemento)) {
				interseccionConjunto.insertarElemento(elemento); // Agregamos el elemento a la interseccion si existe en
																	// el otro conjunto
			}
		}
		return interseccionConjunto;
	}

	/**
	 * Verifica si el conjunto actual es un subconjunto de otro conjunto.
	 * 
	 * @param otroConjunto El conjunto con el que se desea comparar
	 * @return true si el conjunto actual es un subconjunto del otro conjunto, false
	 *         en caso contrario.
	 */
	public boolean iguales(Conjunto<T> otroConjunto) {
		if (this.cantidadElementos != otroConjunto.cantidadElementos) { // verifica si ambos conjuntos [] tienen
																		// diferentes dimensiones
			return false; // retorna falso
		}
		for (int i = 0; i < this.cantidadElementos; i++) { // si ambos tienen la misma dimension osea cantidad de
															// elementos, vamos comprobando si ambos conjuntos tienen
															// los mismo elementos
			if (otroConjunto.buscarElemento(this.elementos[i])) { // llamo al metodo "buscarElementos" usando el equals
																	// para saber si tengo o no el elemento en ambos
																	// conjuntos
				return false;
			}
		}
		return true; // si pudo pasar por ambas condiciones (verificacion de misma cantidad de
						// elementos) y (mismo elementos) entonces retorna true
	}

	/**
	 * Verifica si un elemento esta dentro del conjunto
	 * Retorna si un elemento esta en el conjunto
	 * 
	 * @see insertarElemento
	 */
	private boolean buscarElemento(T elemento) {
		for (int i = 0; i < cantidadElementos; i++) {
			if (elementos[i].equals(elemento)) { // Compara el elemento actual con el elemento de otro conjunto
				return true; // Si el elemento es encontrado, retorna true
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder(); // creo un objeto cadena para juntar los elementos
		cadena.append("{"); // imprimo la llave "{" para abrir y comenzar a armar la cadena de elementos del
							// Conjunto
		for (int i = 0; i < cantidadElementos; i++) {
			cadena.append(elementos[i]); // pongo el elemento en la cadena e imprimo
			if (i < cantidadElementos - 1) { /*
												 * uso una condicion if para cuando llego al anteultimo elemento de mi
												 * array deje de imprimir una coma
												 * cuando llegue al ultimo elemento dejo de imprimir una coma y salgo
												 * del for y llegando al objeto cadena para imprimir una llave que
												 * cierra "}"
												 */
				cadena.append(", "); // son los separadores
			}
		}
		cadena.append("}"); // cierro con llave la cadena
		return cadena.toString(); // retorno la cadena ya completada con todo los elementos ya imprimidos
	}

}
