package org.iesra

class Cuenta(val numeroCuenta: Int, var saldo : Double) {


    companion object {
        fun esMorosa(persona: Persona): Boolean {
            return persona.cuentas.filterNotNull().any { it.saldo < 0 }
        }

        fun transeferencia(personaEmisora: Persona,
                           numeroCuentaEmisora: Int,
                           personaRemitente : Persona,
                           numeroCuentaRemitente: Int,
                           cantidad: Double): Boolean {

            val cuentaEmisora = personaEmisora.cuentas.filterNotNull().find { it.numeroCuenta == numeroCuentaEmisora }

            val cuentaRemitente = personaRemitente.cuentas.filterNotNull().find { it.numeroCuenta == numeroCuentaRemitente }

            return if (cuentaEmisora == null) {
                throw IllegalArgumentException("No se encontro la cuenta emisora")
            }
            else if (cuentaRemitente == null) {
                throw IllegalArgumentException("No se encontro la cuenta remitente")
            }
            else if (cuentaEmisora.saldo <= 0.0) {
                throw IllegalArgumentException("El saldo de la cuenta emisora debe de ser positivo")
            }
            else if (cuentaEmisora.saldo < cantidad) {
                throw IllegalArgumentException("Saldo de la cuenta insuficiente")
            } else {
                cuentaEmisora.realizarPagos(cantidad)
                cuentaRemitente.recibirAbonos(cantidad)
                true
            }
        }
    }

    fun recibirAbonos(cantidad: Double) {
        saldo += cantidad
    }

    fun realizarPagos(cantidad: Double) {
        saldo -= cantidad
    }

}