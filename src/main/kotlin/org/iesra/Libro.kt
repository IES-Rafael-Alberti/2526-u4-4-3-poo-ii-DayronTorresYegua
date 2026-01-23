package org.iesra

class Libro(val titulo : String,
            val  autor: String,
            val numeroPaginas : Int,
            var nota : Int) {

    init {
        require(nota in 0 .. 10) {"La nota debe de estar entre 0 y 10"}
    }

}