package org.pebiblioteca

/**
 * Alberga todos los elementos disponibles en la biblioteca. Facilita la organización y el acceso rápido a estos elementos.
 */
class Catalogo<T: ElementoBiblioteca> {

    private val elementos = mutableListOf<ElementoBiblioteca>()

    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }


    fun eliminarElemento(elemento: T) {
        elementos.remove(elemento)
    }

    fun obtenerElementos(): List<ElementoBiblioteca> {
        return elementos.toList()
    }



}