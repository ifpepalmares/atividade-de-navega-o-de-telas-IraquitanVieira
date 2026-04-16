@file:Suppress("unused")

package com.example.lazycolumnbasic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class EquipeF1(
    val id: Int,
    val nome: String,
    var favorita: Boolean = false,
)

@Composable
fun ListaEquipesF1Screen(
    modifier: Modifier = Modifier,
) {
    val equipes = remember {
        mutableStateListOf(
            EquipeF1(1, "Red Bull Racing"),
            EquipeF1(2, "Mercedes"),
            EquipeF1(3, "Ferrari"),
            EquipeF1(4, "McLaren"),
            EquipeF1(5, "Aston Martin"),
            EquipeF1(6, "Alpine"),
            EquipeF1(7, "Williams"),
            EquipeF1(8, "RB"),
            EquipeF1(9, "Sauber"),
            EquipeF1(10, "Haas"),
        )
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = equipes,
            key = { it.id },
        ) { equipe ->
            EquipeF1Row(
                equipe = equipe,
                onFavoritaChange = { marcado -> equipe.favorita = marcado },
            )
        }
    }
}

@Composable
private fun EquipeF1Row(
    equipe: EquipeF1,
    modifier: Modifier = Modifier,
    onFavoritaChange: (Boolean) -> Unit,
) {
    androidx.compose.foundation.layout.Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Checkbox(
            checked = equipe.favorita,
            onCheckedChange = onFavoritaChange,
        )
        Text(
            text = equipe.nome,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ListaEquipesF1Preview() {
    MaterialTheme {
        ListaEquipesF1Screen()
    }
}
