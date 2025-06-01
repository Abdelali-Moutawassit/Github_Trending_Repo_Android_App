plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.githubtrendingrepo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.githubtrendingrepo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit + Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Glide pour le chargement d’images (avatars GitHub)
    implementation("com.github.bumptech.glide:glide:4.15.1")
//    kapt("com.github.bumptech.glide:compiler:4.15.1")

// RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2")

}