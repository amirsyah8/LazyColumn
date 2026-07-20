package com.example.playerfootbal.data

data class Player(
    val id : Int,
    val name: String,
    val age : Int,
    val description : String,
    val playerImageId : Int = 0,
)
