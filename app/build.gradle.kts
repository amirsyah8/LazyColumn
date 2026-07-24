import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.apollo)
}

kotlin {
    jvmToolchain(11)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}

android {
    namespace = "com.example.playerfootbal"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.playerfootbal"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        val baseUrl = localProperties.getProperty("BASE_URL") ?: "\"http://10.0.2.2:3002/graphql\""
        val apiUrl = localProperties.getProperty("API_URL") ?: "\"http://10.0.2.2:3002\""
        
        buildConfigField("String", "BASE_URL", baseUrl)
        buildConfigField("String", "API_URL", apiUrl)
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

apollo {
    service("player") {
        packageName.set("com.example.playerfootbal")
        generateKotlinModels.set(true)
    }
}


dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.ads.mobile.sdk)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.apollo.runtime)
    implementation(libs.coil.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}