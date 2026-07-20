# Implementation Plan - Fix Code Issues in Player Football App

The user reported issues in the code. My investigation revealed several problems ranging from incorrect theme names and missing imports to incorrect Material 3 usage and layout issues with edge-to-edge display.

## Proposed Changes

### [Component Name] UI Fixes

#### [MODIFY] [MainActivity.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/MainActivity.kt)
- Fix theme name from `PlayerUnitedTheme` to `PlayerFootbalTheme`.
- Update `PlayerFootball` to pass `PaddingValues` from `Scaffold` to `HomeContent`.

#### [MODIFY] [HomeContent.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/HomeContent.kt)
- Add `padding: PaddingValues` parameter to `HomeContent`.
- Import `androidx.compose.foundation.lazy.items`.
- Use the passed `padding` in `LazyColumn`'s `contentPadding`.
- Fix `PlayerListItem` call: change `players = it` to `player = it`.

#### [MODIFY] [PlayerListItem.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/PlayerListItem.kt)
- Remove invalid import `ads_mobile_sdk.h6`.
- Update typography styles to Material 3 (`headlineSmall`, `bodyMedium`).
- Use `player.description` instead of the hardcoded string "Description".
- Add basic styling (padding, card-like structure, and image if possible).

## Verification Plan

### Automated Tests
- Build the project using `./gradlew assembleDebug` to ensure all compilation errors are resolved.

### Manual Verification
- Deploy the app to a device/emulator to verify the UI looks correct and list is scrollable.
