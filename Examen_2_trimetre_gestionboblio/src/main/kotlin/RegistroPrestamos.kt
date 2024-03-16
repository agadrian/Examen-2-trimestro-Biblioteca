package org.pebiblioteca

interface IGestorPrestamos{
    fun registrarPrestamos(elementoBiblioteca: ElementoBiblioteca, usuario: Usuario)
    fun registrarDevolucion(elementoBiblioteca: ElementoBiblioteca)
    fun consultarHistorial()

}


/**
 * Mantendrá un registro de los préstamos actuales y un historial de todos los préstamos realizados, permitiendo registrar préstamos y devoluciones, así como consultar el historial de préstamos de elementoBibliotecas específicos o usuarios.
 */
class RegistroPrestamos: IGestorPrestamos {

    private val prestamosActuales = mutableMapOf<String, MutableList<String>>()
    private val historialPrestamos = mutableMapOf<String, MutableList<String>>()


    /**
     * Registra el prestamo de un elementoBiblioteca
     */
    override fun registrarPrestamos(elementoBiblioteca: ElementoBiblioteca, usuario: Usuario) {
        val infoPrestamo = "Elemento: ${elementoBiblioteca.tipo} - ID: ${elementoBiblioteca.id} - Titulo: ${elementoBiblioteca.titulo}"

        // Verificar si la ID del elementoBiblioteca ya tiene una lista de prestamos, si no la creamos
        if (!prestamosActuales.containsKey(elementoBiblioteca.id)) {
            prestamosActuales[elementoBiblioteca.id] = mutableListOf(infoPrestamo)
        }

        if(elementoBiblioteca.estado == EstadoElemento.DISPONIBLE){
            // Agregar prestamo a la lista de prestamos actuales
            prestamosActuales[elementoBiblioteca.id]?.add("ID Usuario: ${usuario.id}") ?: GestorConsola.imprimirMensaje("Error al añadir el prestamo de ${elementoBiblioteca.tipo} con titulo ${elementoBiblioteca.titulo} y ID: ${elementoBiblioteca.id}")

            //agregamos el elementoBiblioteca prestado al usuario
            usuario.agregarElemento(elementoBiblioteca)
            GestorConsola.imprimirMensaje("${elementoBiblioteca.tipo} con titulo ${elementoBiblioteca.titulo} prestado a ${usuario.nombre} correctamente")

            // Registrar el préstamo en el historial
            if (!historialPrestamos.containsKey(elementoBiblioteca.id)) {
                historialPrestamos[elementoBiblioteca.id] = mutableListOf(infoPrestamo)
            } else {
                historialPrestamos[elementoBiblioteca.id]?.add(infoPrestamo)
            }

            elementoBiblioteca.modificarEstado()
        }else{
            GestorConsola.imprimirMensaje("Error - El elemento ${elementoBiblioteca.tipo} con ${elementoBiblioteca.titulo} y ID ${elementoBiblioteca.id} esta prestado actualmente!")
        }

    }

    /**
     * Registra la devolucion de un elementoBiblioteca. El elementoBiblioteca se elimina de prestamos actuales.
     */
    override fun registrarDevolucion(elementoBiblioteca: ElementoBiblioteca) {
        if (prestamosActuales.containsKey(elementoBiblioteca.id)) {
            prestamosActuales.remove(elementoBiblioteca.id)
            elementoBiblioteca.modificarEstado()
            GestorConsola.imprimirMensaje("Devolución registrada con éxito para: ${elementoBiblioteca.titulo} y ID ${elementoBiblioteca.id}.")
        } else {
            GestorConsola.imprimirMensaje("Error - Elemento: ${elementoBiblioteca.tipo} con titulo ${elementoBiblioteca.titulo} y ID ${elementoBiblioteca.id} no tiene préstamos activos.")
        }
    }




    /**
     * Retorna el historial de todos los prestamos
     */
    override fun consultarHistorial(){
        return if (historialPrestamos.isNotEmpty()) historialPrestamos.forEach { println("${it.key} ->  ${it.value}") } else GestorConsola.imprimirMensaje("Historial vacio")
    }




}

