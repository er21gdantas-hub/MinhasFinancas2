package com.seudominio.minhasfinancas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seudominio.minhasfinancas.ui.inicio.TelaInicial

/** Grafo de navegação principal. */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinos.INICIO) {
        composable(Destinos.INICIO) { TelaInicial() }
    }
}
