package org.pebiblioteca

data class Revista(
    override val id: String,
    override val titulo: String,
    override val tipo: String = "Revista",
    val numPaginas: Int,
    override var estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca() {

    override fun prestar() {
        estado = EstadoElemento.PRESTADO
    }

    override fun devolver() {
        estado = EstadoElemento.DISPONIBLE
    }
}