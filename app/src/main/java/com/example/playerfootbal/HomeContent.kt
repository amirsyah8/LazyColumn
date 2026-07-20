package com.example.playerfootbal

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.playerfootbal.data.DataProvider

@Composable
fun HomeContent(padding: PaddingValues) {
    val players = remember { DataProvider.playerList }
    LazyColumn(
        modifier = Modifier.padding(padding),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = players
        ) { player ->
            PlayerListItem(player = player)
        }
    }
}