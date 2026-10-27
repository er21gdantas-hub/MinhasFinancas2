package com.seudominio.minhasfinancas.ui.inicio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.seudominio.minhasfinancas.domain.formatarMoeda
import com.seudominio.minhasfinancas.ui.theme.DespesaVermelho
import com.seudominio.minhasfinancas.ui.theme.ReceitaVerde

/** Dashboard inicial: saldo, receitas e despesas do mês. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicial(viewModel: InicioViewModel = hiltViewModel()) {
    val estado by viewModel.estado.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Minhas Finanças") }) },
        floatingActionButton = {
            // Será ligado ao cadastro de transações (etapa 8).
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar transação")
            }
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            CartaoResumo(
                titulo = "Saldo total",
                valor = formatarMoeda(estado.saldoTotal),
                corValor = MaterialTheme.colorScheme.onPrimaryContainer,
                destaque = true,
                modifier = Modifier.fillMaxWidth(),
            )
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                LinhaResumo("Receitas do mês", formatarMoeda(estado.receitasMes), ReceitaVerde)
                LinhaResumo("Despesas do mês", formatarMoeda(estado.despesasMes), DespesaVermelho)
            }
            Text("Transações recentes", style = MaterialTheme.typography.titleMedium)
            Text(
                "Nenhuma transação ainda. Toque em + para começar.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

/** Cartão que ocupa metade da linha (usa weight do RowScope). */
@Composable
private fun RowScope.LinhaResumo(titulo: String, valor: String, cor: Color) {
    CartaoResumo(titulo, valor, cor, false, Modifier.weight(1f))
}

@Composable
private fun CartaoResumo(
    titulo: String,
    valor: String,
    corValor: Color,
    destaque: Boolean,
    modifier: Modifier = Modifier,
) {
    val cores = if (destaque) {
        CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    } else {
        CardDefaults.cardColors()
    }
    Card(modifier = modifier, colors = cores) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(titulo, style = MaterialTheme.typography.labelLarge)
            Text(valor, style = MaterialTheme.typography.headlineSmall, color = corValor)
        }
    }
}
