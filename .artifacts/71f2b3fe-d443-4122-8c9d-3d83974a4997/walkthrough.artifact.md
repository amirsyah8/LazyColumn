# Walkthrough - Migrasi ke GraphQL dengan Apollo Kotlin 4

Saya telah berjaya mengubah aplikasi Player Football untuk mengambil data daripada backend NestJS menggunakan GraphQL dan memaparkan imej menggunakan Coil.

## Perubahan Utama

### 1. Konfigurasi Gradle & Penyelesaian Konflik
- **Penyelesaian Konflik**: Mengatasi konflik antara `org.jetbrains.kotlin.android` dan sistem binaan baru AGP 9.3 dengan menambah `android.builtInKotlin=false` dalam `gradle.properties`.
- **Apollo 4**: Menambah plugin dan runtime Apollo Kotlin 4.
- **Coil**: Menambah perpustakaan Coil untuk pemuatan imej secara asinkronus daripada URL.
- **JVM Target**: Menyelaraskan target JVM ke versi 11 untuk mengelakkan ralat kompilasi.

### 2. Lapisan Data (GraphQL)
- **Skema & Query**: Fail `schema.graphqls` dan `GetDataPlayer.graphql` telah dicipta dalam `src/main/graphql` untuk membolehkan penjanaan kod type-safe oleh Apollo.
- **Apollo Client**: Mencipta `apolloClient` singleton yang menghala ke `http://10.0.2.2:3002/graphql` (alamat khas untuk emulator Android mengakses localhost).
- **Model Data**: Mengemaskini kelas `Player` untuk menyokong `playerImageId` sebagai `String`.

### 3. Kemas Kini UI
- **HomeContent.kt**: Kini menggunakan `LaunchedEffect` untuk memanggil query GraphQL secara asinkronus dan memaparkan `CircularProgressIndicator` semasa memuatkan data.
- **PlayerListItem.kt**: Menggunakan `AsyncImage` daripada Coil untuk memaparkan imej pemain secara terus daripada backend URL.

## Pengesahan
- Projek telah berjaya disegerakkan (sync) dan dibina (build) dengan perintah `./gradlew assembleDebug`.
- Struktur folder GraphQL telah disusun mengikut amalan terbaik Apollo 4.

> [!TIP]
> Pastikan backend NestJS anda sedang berjalan di `http://localhost:3002/graphql` sebelum menjalankan aplikasi pada emulator.
