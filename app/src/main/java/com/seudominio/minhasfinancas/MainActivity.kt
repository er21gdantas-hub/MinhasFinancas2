package com.seudominio.minhasfinancas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.seudominio.minhasfinancas.navigation.AppNavHost
import com.seudominio.minhasfinancas.ui.theme.MinhasFinancasTheme
import dagger.hilt.android.AndroidEntryPoint

/** Única Activity do app; todas as telas são Composables. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinhasFinancasTheme {
                AppNavHost()
            }
        }
    }
}
