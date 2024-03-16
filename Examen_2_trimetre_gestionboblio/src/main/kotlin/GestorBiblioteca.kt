package org.pebiblioteca

/**
 * Esta clase será el corazón de nuestro sistema, encargándose de la lógica para gestionar los libros y otros elementos
 */
class GestorBiblioteca(
    private val catalogo: Catalogo<ElementoBiblioteca>,
    private val gestorPrestamo: IGestorPrestamos
) {


    /**
     * Agrega el elemento pasado por parametro a el catalgo
     */
    fun aniadirElementos(elemento: ElementoBiblioteca){
        catalogo.anadirElemento(elemento)
    }

    /**
     * Elimina el elemento pasado por parametro del catalgo
     */
    fun eliminarElemento(elemento: ElementoBiblioteca){
        catalogo.eliminarElemento(elemento)
    }

    /**
     * Registra un prestamo en registroPrestamo, de un libro y del usuario al que se le presta
     */
    fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario){
        gestorPrestamo.registrarPrestamos(elemento, usuario)

    }

    /**
     *Registra la devolucion de un libro
     */
    fun registrarDevolucion(elemento: ElementoBiblioteca){
        gestorPrestamo.registrarDevolucion(elemento)
    }


    fun consultarHistorialPrestamos(){
        GestorConsola.imprimirMensaje("Historial de prestamos: ")
        gestorPrestamo.consultarHistorial()
    }


}