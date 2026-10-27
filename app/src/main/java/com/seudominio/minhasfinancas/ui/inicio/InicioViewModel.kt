package com.seudominio.minhasfinancas.ui.inicio

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/** Estado da tela inicial. Valores em centavos para evitar erros de arredondamento. */
data class InicioEstado(
    val saldoTotal: Long = 0L,
    val receitasMes: Long = 0L,
    val despesasMes: Long = 0L,
)

/** ViewModel da tela inicial (dados reais virão do Room nas próximas etapas). */
@HiltViewModel
class InicioViewModel @Inject constructor() : ViewModel() {
    private val _estado = MutableStateFlow(InicioEstado())
    val estado: StateFlow<InicioEstado> = _estado.asStateFlow()
}
