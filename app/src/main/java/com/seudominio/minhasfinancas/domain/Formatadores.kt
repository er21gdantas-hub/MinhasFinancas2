package com.seudominio.minhasfinancas.domain

import java.text.NumberFormat
import java.util.Locale

private val LOCALE_BR: Locale = Locale.forLanguageTag("pt-BR")

/** Converte centavos em texto monetário brasileiro, ex.: R$ 1.234,56. */
fun formatarMoeda(centavos: Long): String =
    NumberFormat.getCurrencyInstance(LOCALE_BR).format(centavos / 100.0)
