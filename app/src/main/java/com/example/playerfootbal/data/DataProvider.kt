package com.example.playerfootbal.data

import com.example.playerfootbal.R

object DataProvider {
    val player =
        Player(
            id = 1,
            name = "David de Gea Quintana",
            age = 28,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            playerImageId = R.drawable.p1
        )

    val playerList = listOf(
        player,
        Player(
            id = 2,
            name = "Eric Bertrand Bailly",
            age = 30,
            description = "Jubilee enjoys thoughtful discussions by the campfire.",
            playerImageId = R.drawable.p2
        ),
        Player(
            id = 3,
            name = "Victor Jörgen Nilsson Lindelöf",
            age = 28,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            playerImageId = R.drawable.p3
        ),
        Player(
            id = 4,
            name = "Jacob Harry Maguire",
            age = 30,
            description = "Mochi is the perfect \"rubbery ducky\" debugging pup, always listening.",
            playerImageId = R.drawable.p4
        ),
        Player(
            id = 5,
            name = "Luke Paul Hoare Shaw",
            age = 12,
            description = "Brewery loves fetching you your favorite homebrew.",
            playerImageId = R.drawable.p5
        ),
        Player(
            id = 6,
            name = "Bruno Miguel Borges Fernandes",
            age = 28,
            description = "Picture yourself in a boat on a river, Lucy is a pup with kaleidoscope eyes.",
            playerImageId = R.drawable.p6
        ),
        Player(
            id = 7,
            name = "Frederico Rodrigues de Paula Santos",
            age = 25,
            description = "Is it a bird? A plane? No, it's Astro blasting off into your heart!",
            playerImageId = R.drawable.p7
        ),
        Player(
            id = 8,
            name = "Paul Labile Pogba",
            age = 29,
            description = "Boo is just a teddy bear in disguise. What he lacks in grace, he makes up in charm.",
            playerImageId = R.drawable.p8
        ),
        Player(
            id = 9,
            name = "Edinson Roberto Gómez Cavani",
            age = 27,
            description = "Pippa likes to look out the window and write pup-poetry.",
            playerImageId = R.drawable.p9
        ),
        Player(
            id = 10,
            name = "Mason Will John Greenwood",
            age = 20,
            description = "Coco enjoys getting pampered at the local puppy spa.",
            playerImageId = R.drawable.p10
        ),
        Player(
            id = 11,
            name = "Daniel Owen James",
            age = 23,
            description = "Brody is a good boy, waiting for your next command.",
            playerImageId = R.drawable.p11
        ),
        Player(
            id = 12,
            name = "Marcus Rashford",
            age = 24,
            description = "Stella! Calm and always up for a challenge, she's the perfect companion.",
            playerImageId = R.drawable.p12
        ),
    )
}
