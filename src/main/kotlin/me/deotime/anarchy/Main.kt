package me.deotime.anarchy

import org.jetbrains.kotlin.diagnostics.DiagnosticFactory
import org.jetbrains.kotlin.diagnostics.DiagnosticFactory0
import org.jetbrains.kotlin.diagnostics.Errors
import java.io.File

fun main() {
    val annotation = buildString {
        append("@file:Suppress(")
        append(
            Errors::class.java.declaredFields
                .onEach { it.isAccessible = true }
                .filter { DiagnosticFactory::class.java.isAssignableFrom(it.type) }
                .joinToString { "\"${it.name}\"" }
        )
        append(")")
        append("\n\n")
        append("""
            fun main() {
               
            }
        """.trimIndent())
    }
    File("AnarchyKotlin.kt").writeText(annotation)

}