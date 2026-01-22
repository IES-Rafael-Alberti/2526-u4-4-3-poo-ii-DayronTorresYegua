package org.iesra

import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("MiAplicacion")

fun main() {


    val persona1 = Persona(0, "12345678A")

    val cuenta1 = Cuenta(1, 0.0)
    val cuenta2 = Cuenta(2, 700.0)

    persona1.aniadirCuenta(cuenta1)
    persona1.aniadirCuenta(cuenta2)

    cuenta1.recibirAbonos(1100.0)
    cuenta2.realizarPagos(750.0)

    logger.info("¿La persona es morosa? :  ${Cuenta.esMorosa(persona1)}")

    try {
        val transferencia = Cuenta.transeferencia(persona1, 1, persona1, 2, 1000.0)
        logger.info("Transferencia exitosa")
    } catch (e: IllegalArgumentException) {
        logger.error("Transferencia falló: ${e.message}")
    }

    logger.info("¿La persona es morosa? :  ${Cuenta.esMorosa(persona1)}")

    logger.info("${cuenta1.saldo}")
    logger.info("${cuenta2.saldo}")

}