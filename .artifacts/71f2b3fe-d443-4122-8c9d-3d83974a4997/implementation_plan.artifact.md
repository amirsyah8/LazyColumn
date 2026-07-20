# Implementation Plan - Migrate to GraphQL using Apollo Kotlin

Migrate the Player Football app to fetch data from a NestJS GraphQL backend using **Apollo Kotlin** instead of local static data.

## User Review Required

> [!IMPORTANT]
> **Network Address**: In Android Emulators, `localhost` refers to the device itself. To access your computer's `localhost`, you must use `10.0.2.2`.
>
> **Image Loading**: I will integrate **Coil** to handle loading images from URLs.
>
> **Apollo Plugin**: This requires adding the Apollo Kotlin Gradle plugin, which will generate type-safe models from your GraphQL query.

## Proposed Changes

### [Component Name] Build Configuration

#### [MODIFY] [libs.versions.toml](file:///home/amirshah/AndroidStudioProjects/playerfootbal/gradle/libs.versions.toml)
- Add version for Apollo Kotlin and Coil.
- Define library aliases and plugin alias for Apollo.

#### [MODIFY] [build.gradle.kts](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/build.gradle.kts)
- Add Apollo Kotlin plugin.
- Configure Apollo service (schema location, package name).
- Add dependencies for Apollo and Coil.

#### [MODIFY] [AndroidManifest.xml](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/AndroidManifest.xml)
- Add `android.permission.INTERNET`.
- Add `android:usesCleartextTraffic="true"` to support non-HTTPS local backend.

### [Component Name] Data Layer

#### [NEW] [player.graphql](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/graphql/player.graphql)
- Define the `GetDataPlayer` query.

#### [NEW] [Apollo.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/data/Apollo.kt)
- Singleton to provide the `ApolloClient` instance pointing to `http://10.0.2.2:3002/graphql`.

#### [DELETE] [DataProvider.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/data/DataProvider.kt)
- Remove the local static data source.

### [Component Name] UI Layer

#### [MODIFY] [PlayerListItem.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/PlayerListItem.kt)
- Update to accept the generated Apollo `GetDataPlayerQuery.GetDataPlayer` model.
- Update `PlayerImage` to use Coil's `AsyncImage` with the base URL.

#### [MODIFY] [HomeContent.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/HomeContent.kt)
- Fetch data using `apolloClient.query(GetDataPlayerQuery()).execute()`.
- Handle loading, success, and error states using Compose `State`.

## Verification Plan

### Automated Tests
- Run `./gradlew generateApolloSources` to verify GraphQL code generation.
- Run `./gradlew assembleDebug` to verify compilation.

### Manual Verification
- Deploy to emulator.
- Verify that the list is populated from the backend.
- Verify images load correctly from the URL.
