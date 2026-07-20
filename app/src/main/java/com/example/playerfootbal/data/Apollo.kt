package com.example.playerfootbal.data

import com.apollographql.apollo.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl("http://10.0.2.2:3002/graphql")
    .build()
