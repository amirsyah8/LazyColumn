package com.example.playerfootbal.data

import com.apollographql.apollo.ApolloClient
import com.example.playerfootbal.BuildConfig

val apolloClient = ApolloClient.Builder()
    .serverUrl(BuildConfig.BASE_URL)
    .build()
