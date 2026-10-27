package com.seudominio.minhasfinancas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val EsquemaClaro = lightColorScheme(
    primary = VerdePrimario,
    primaryContainer = VerdeContainer,
)

private val EsquemaEscuro = darkColorScheme(
    primary = VerdePrimarioClaro,
    primaryContainer = VerdeContainerEscuro,
)

/** Tema do app com suporte a claro/escuro (segue o sistema por enquanto). */
@Composable
fun MinhasFinancasTheme(
    temaEscuro: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (temaEscuro) EsquemaEscuro else EsquemaClaro,
        typography = AppTypography,
        content = content,
    )
}
