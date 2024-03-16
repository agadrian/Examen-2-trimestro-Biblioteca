package org.pebiblioteca

/**
 * Alberga todos los elementos disponibles en la biblioteca. Facilita la organización y el acceso rápido a estos elementos.
 */
class Catalogo<T: ElementoBiblioteca> {

    private val gestorElementos = GestorElementos<ElementoBiblioteca>()


    fun <T : ElementoBiblioteca> agregarElemento(elemento: T) {
        gestorElementos.anadirElemento(elemento)
    }


    fun eliminarElementoPorId(id: String) {
        gestorElementos.eliminarElemento(id)
    }

    fun obtenerElementos(): List<ElementoBiblioteca> {
        return gestorElementos.obtenerElementos()
    }


    fun <R> filtrarPorCriterio(criterio: (elemento: ElementoBiblioteca) -> Boolean): List<R> {
        return gestorElementos.filtrarPorCriterio<T>(criterio) as List<R>
    }
}