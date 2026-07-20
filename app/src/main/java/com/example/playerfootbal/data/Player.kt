package com.example.playerfootbal.data

data class Player(
    val id : String,
    val name: String,
    val age : Int,
    val description : String,
    val playerImageId : String = "",
)
