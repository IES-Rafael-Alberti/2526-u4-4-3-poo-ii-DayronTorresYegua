package org.iesra

class Persona(var numeroCuentas: Int, val dni: String) {

    val cuentas: Array<Cuenta?> = arrayOfNulls(3)

    init {
        require(numeroCuentas in 0..3) { "Como máximo se permiten 3 cuentas" }
    }

    fun aniadirCuenta(cuenta: Cuenta) {
        require(numeroCuentas < 3) { "Como máximo se permiten 3 cuentas" }
        cuentas[numeroCuentas] = cuenta
        numeroCuentas++
    }
}
