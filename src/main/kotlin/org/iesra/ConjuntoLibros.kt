package org.iesra

class ConjuntoLibros(var tamanio : Int) {

    val libros : Array<Libro?> = arrayOfNulls(tamanio)
    var numeroLibros : Int = 0

    fun aniadirLibro(libro: Libro) : Boolean {
        val existe = libros.filterNotNull().any {it.titulo == libro.titulo && it.autor == libro.autor}

        if (existe) {
            return false
        }
        else if (numeroLibros >= tamanio) {
            return false
        } else {
            libros[numeroLibros] = libro
            numeroLibros++
            return true
        }
    }

    fun eliminarLibroPorTitulo(titulo : String) : Boolean {

        val existeTitulo = libros.filterNotNull().any {it.titulo == titulo }
        if (!existeTitulo) return false

        var i = 0
        var eliminado = false

        while (i < numeroLibros) {
            if (libros[i]?.titulo == titulo) {
                for (j in i.. numeroLibros - 1) {
                    libros[j] = libros[j + 1]
                }
                libros[numeroLibros - 1] = null
                numeroLibros--
                eliminado = true
            } else {
                i++
            }
        }
        return eliminado
    }

    fun eliminarLibroPorAutor(autor: String): Boolean {
        val existeAutor = libros.filterNotNull().any { it.autor == autor }
        if (!existeAutor) return false

        var i = 0
        var eliminado = false

        while (i < numeroLibros) {
            if (libros[i]?.autor == autor) {
                for (j in i.. numeroLibros - 1) {
                    libros[j] = libros[j + 1]
                }
                libros[numeroLibros - 1] = null
                numeroLibros--
                eliminado = true
            } else {
                i++
            }
        }
        return eliminado
    }

    fun mostrarMayorYMenorCalificacion(): String {
        if (numeroLibros == 0) return "Conjunto vacío"

        val maxNota = libros.filterNotNull().maxOf { it.nota }
        val minNota = libros.filterNotNull().minOf { it.nota }

        return "\nMayor calificación: $maxNota\n" +
                libros.filterNotNull().filter { it.nota == maxNota }.joinToString("\n") { "- ${it.titulo} (${it.autor})" } +
                "\n" +
                "Menor calificación: $minNota\n" +
                libros.filterNotNull().filter { it.nota == minNota }.joinToString("\n") { "- ${it.titulo} (${it.autor})" }
    }

    override fun toString(): String {
        return if (numeroLibros == 0) "Conjunto de libros vacio"
        else libros.sliceArray(0 .. numeroLibros).filterNotNull().joinToString("\n") { libro ->
            "- Titulo: ${libro.titulo}, Autor: ${libro.autor}, Numero paginas: ${libro.numeroPaginas}, Nota: ${libro.nota}" }
    }
}
