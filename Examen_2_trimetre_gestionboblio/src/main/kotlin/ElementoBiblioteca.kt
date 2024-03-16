package org.pebiblioteca

abstract class ElementoBiblioteca: Prestable {
    abstract val id: String
    abstract val titulo: String
    abstract val tipo: String
    abstract var estado: EstadoElemento

    fun modificarEstado(){
        estado = if (estado == EstadoElemento.DISPONIBLE) EstadoElemento.PRESTADO else EstadoElemento.DISPONIBLE
    }
}

interface Prestable{
    fun prestar()
    fun devolver()
}