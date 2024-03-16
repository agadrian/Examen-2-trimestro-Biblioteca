package org.pebiblioteca

/**
 * Data class que represent un libro
 */
data class Libro(
    override val id: String,
    override val titulo: String,
    private val autor: String,
    override val tipo: String = "Revista",
    private val anioPubli: Int,
    private val tematica: String,
    override var estado: EstadoElemento = EstadoElemento.DISPONIBLE
): ElementoBiblioteca(){
    init {
        require(titulo.isNotBlank()) {"El titulo no puede estar vacio"}
        require(autor.isNotBlank()){"El autor no puede estar vacio"}
        require(anioPubli in 1..2024) {"El año debe estar entre 1-2024"}
        require(tematica.isNotBlank()){"El titulo no puede estar vacio"}
    }


    fun getAutor(): String{
        return autor
    }

    fun getAnioPubli(): Int{
        return anioPubli
    }

    fun getTematica(): String{
        return tematica
    }


    override fun prestar() {
        estado = EstadoElemento.PRESTADO
    }

    override fun devolver() {
        estado = EstadoElemento.DISPONIBLE
    }


}





