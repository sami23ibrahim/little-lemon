// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    // Ensure that kapt is applied here globally
    id("kotlin-kapt") apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20" apply false
}