package org.iesra

import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("MiAplicacion")

fun main() {
    logger.trace("Mensaje TRACE")
    logger.debug("Mensaje DEBUG")
    logger.info("Mensaje INFO")
    logger.warn("Mensaje WARN")
    logger.error("Mensaje ERROR")
}