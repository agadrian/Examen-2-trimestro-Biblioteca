package org.pebiblioteca


class GestorElementos<T : ElementoBiblioteca> (private val gestorBiblioteca: GestorBiblioteca) {



    /**
     * Añade el elemento pasado por parametro a la lista de elementos
     */
    fun anadirElemento(elemento: T){
        gestorBiblioteca.aniadirElementos(elemento)
        GestorConsola.imprimirMensaje("Elemento con ID ${elemento.id} añadido correctamente")
    }

    /**
     * Elimina de la lista de elementos el pasado por parametro
     */
    fun eliminarElemento(elemento: T){
        gestorBiblioteca.eliminarElemento(elemento)
        GestorConsola.imprimirMensaje("Elemento con ID ${elemento.id} eliminado correctamente")
    }

    /**
     * Muestra la lista de elementos
     */

    fun filtrarPorCriterio(criterio: (elemento: ElementoBiblioteca) -> Boolean): List<ElementoBiblioteca> {
        return gestorBiblioteca.obtenerElementos().filter(criterio)
    }


}