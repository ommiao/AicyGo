import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

val properties = gradleLocalProperties(rootDir, providers)

fun getLocalProperty(key: String): String {
    return (properties[key] as String)
}

android {
    namespace = "cn.ommiao.aicygo"
    compileSdk = 36

    defaultConfig {
        applicationId = "cn.ommiao.aicygo"
        minSdk = 36
        targetSdk = 36
        versionCode = 1
        versionName = "flyme-12.6.0.0A"
        base.archivesName = "Aicy_Go_${versionCode}_$versionName"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    signingConfigs {
        getByName("debug") {
            keyAlias = getLocalProperty("keyStoreAlias")
            keyPassword = getLocalProperty("keyStorePassword")
            storeFile = file(getLocalProperty("keyStoreFileName"))
            storePassword = getLocalProperty("keyStorePassword")
            enableV1Signing = true
            enableV2Signing = true
        }
    }
}

dependencies {
    implementation(project(":theme"))
    implementation(libs.compose.activity)
}
