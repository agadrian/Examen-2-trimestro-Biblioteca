package org.pebiblioteca


class GestorElementos<T : ElementoBiblioteca> {

    private val elementos = mutableListOf<T>()

    /**
     * Añade el elemento pasado por parametro a la lista de elementos
     */
    fun anadirElemento(elemento: T){
        elementos.add(elemento)
    }

    /**
     * Elimina de la lista de elementos el pasado por parametro
     */
    fun eliminarElemento(id: String){
        // revisar
        val elementoEliminar = elementos.find { it.id == id }
        elementos.remove(elementoEliminar)
    }

    /**
     * Muestra la lista de elementos
     */

    fun obtenerElementos(): List<T> {
        return elementos.toList()
    }

    fun <R : T> filtrarPorCriterio(criterio: (elemento: T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }
}