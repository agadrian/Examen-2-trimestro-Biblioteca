package org.pebiblioteca

/**
 * Representará a los usuarios de la biblioteca, conteniendo información como ID, nombre, y una lista de libros prestados.
 */
class Usuario(
    val id: Int,
    val nombre: String,
    val elementosPrestados: MutableList<ElementoBiblioteca> = mutableListOf()
){


    /**
     * Agrega un libro a la lista
     */
    fun agregarElemento(elemento: ElementoBiblioteca){
        if (elemento !in elementosPrestados){
            elementosPrestados.add(elemento)
            GestorConsola.imprimirMensaje("Libro añadido correctamente")
        }else{
            GestorConsola.imprimirMensaje("Error - El libro ${elemento.titulo} ya esta en tus libros prestados")
        }
    }

    fun eliminarLibro(libro: Libro){
        if (libro in elementosPrestados) {
            elementosPrestados.remove(libro)
            GestorConsola.imprimirMensaje("Libro eliminado correctamente")
        }else{
            GestorConsola.imprimirMensaje("Error - El libro ${libro.titulo} no esta en los prestados")
        }
    }

    fun consultarelementosPrestados() {
        if (elementosPrestados.isNotEmpty()) {
            GestorConsola.imprimirMensaje("Libros prestados a $nombre:")
            elementosPrestados.forEach { println(it.titulo) }
        } else {
            GestorConsola.imprimirMensaje("No hay libros prestados a $nombre.")
        }
    }

}
