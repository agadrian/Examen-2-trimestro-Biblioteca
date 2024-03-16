package org.pebiblioteca



fun main() {
    // Instanciar una GestorBiblioteca
    val catalogo = Catalogo<ElementoBiblioteca>()
    val registroPrestamos = RegistroPrestamos()
    val gestionBiblioteca = GestorBiblioteca(catalogo, registroPrestamos)

    // Agregar al menos tres libros al catálogo.
    val libro = Libro(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "Don Tomas", "Tomatin", "Libro", 2023, "El dueño y señor")
    val libro2 = Libro(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "Recetas", "Arguiñano","Libro",  2020, "Comida")
    val libro3 = Libro(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "Peras", "Peritas", "Libro",1970, "Peras grandes")
    val revista1 = Revista(UtilidadesBiblioteca.CreadoUUID.crearIDUnica(), "National Geographic","Revista", 202)


    gestionBiblioteca.aniadirElementos(libro)
    gestionBiblioteca.aniadirElementos(libro2)
    gestionBiblioteca.aniadirElementos(libro3)
    gestionBiblioteca.aniadirElementos(revista1)


    // Ejercicio 3

    val usuario1 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(),"Diego", mutableListOf())
    val usuario2 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(), "Diegin", mutableListOf())
    val usuario3 = Usuario(UtilidadesBiblioteca.CreadorIdUsers.crearIDUnica(), "Tomas", mutableListOf())

    gestionBiblioteca.registrarPrestamo(libro, usuario1)
    gestionBiblioteca.registrarPrestamo(libro2, usuario2)
    gestionBiblioteca.registrarPrestamo(libro3, usuario3)

    gestionBiblioteca.registrarDevolucion(libro)
    gestionBiblioteca.registrarPrestamo(libro, usuario2)

    gestionBiblioteca.registrarPrestamo(revista1, usuario3)

    // Historial de prestamos geeneral
    gestionBiblioteca.consultarHistorialPrestamos()













}