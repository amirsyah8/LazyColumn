# Implementation Plan - Fix Build Warnings and Deprecations

Clean up the project by updating dependency versions and migrating deprecated Gradle DSLs to resolve the warnings shown in the IDE.

## Proposed Changes

### [Component Name] Dependency Updates

#### [MODIFY] [libs.versions.toml](file:///home/amirshah/AndroidStudioProjects/playerfootbal/gradle/libs.versions.toml)
- Update `kotlin` to `2.1.10` (or `2.4.10` as suggested, but let's check stable). Actually, I will use the versions suggested in the image:
  - `kotlin = "2.4.10"`
  - `composeBom = "2026.06.01"`
  - `adsMobileSdk = "1.3.0"`
  - `apollo = "5.0.1"`
  - `coil = "2.7.0"`

### [Component Name] Gradle Configuration

#### [MODIFY] [build.gradle.kts](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/build.gradle.kts)
- Migrate `kotlinOptions { jvmTarget = "11" }` to:
  ```kotlin
  compilerOptions {
      jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
  }
  ```
- Address the `Project.android` deprecation if applicable (usually by ensuring proper imports or DSL usage).

### [Component Name] Code Cleanup

#### [MODIFY] [PlayerListItem.kt](file:///home/amirshah/AndroidStudioProjects/playerfootbal/app/src/main/java/com/example/playerfootbal/PlayerListItem.kt)
- Remove unused `import com.example.playerfootbal.BuildConfig` or other unused imports if they are flagged. (Actually, `BuildConfig` IS used, so I need to check which one is unused. The image shows line 21, let's verify).

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to ensure everything still builds with new versions.
- Verify that the warnings in the "Problems" tab are reduced/gone.
