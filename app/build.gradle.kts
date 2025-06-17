plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.countrylistapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.countrylistapp"
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
    kotlinOptions {
        jvmTarget = "11"
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0") // Or latest version
    implementation("androidx.appcompat:appcompat:1.6.1") // Or latest version
    implementation("com.google.android.material:material:1.11.0") // Or latest version
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // Or latest version

    // For RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2") // Or latest version

    // For network requests (Retrofit and Gson)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // For ViewModel and LiveData (to handle data and lifecycle)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0") // Or latest version
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0") // Or latest version
}