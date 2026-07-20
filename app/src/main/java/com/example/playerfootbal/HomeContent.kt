package com.example.playerfootbal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.playerfootbal.data.Player
import com.example.playerfootbal.data.apolloClient
import com.example.playerfootbal.GetDataPlayerQuery

@Composable
fun HomeContent(padding: PaddingValues) {
    var players by remember { mutableStateOf<List<Player>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        try {
            val response = apolloClient.query(GetDataPlayerQuery()).execute()
            players = response.data?.getDataPlayer?.filterNotNull()?.map {
                Player(
                    id = it.id,
                    name = it.name,
                    age = it.age,
                    description = it.description,
                    playerImageId = it.playerImageId
                )
            } ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
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
}