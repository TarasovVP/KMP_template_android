# KMP Template — Android App

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-Compose-3DDC84.svg?logo=android&logoColor=white)](https://developer.android.com/compose)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A native Android application that consumes a Kotlin Multiplatform library while keeping its UI and application build fully Android-native.

This repository is the Android example from [**KMP: Integrating into Native Projects**](https://medium.com/@vptarasov/kmp-integrating-into-native-projects-f0f35091706d). It is one of five standalone repositories used to show how shared Kotlin code can be integrated into separate native applications.

## What the app demonstrates

- A regular Android application module built with Gradle.
- A Jetpack Compose and Material 3 UI.
- Consumption of the shared KMP library as a Maven dependency.
- Calls to the common `SystemInfo` API from Android code.
- Platform-specific Android device and OS values implemented inside the shared module.

The screen displays:

- the shared KMP greeting;
- the current platform and date;
- the Android device model;
- the Android version and API level.

## Shared dependency

The application depends on:

```kotlin
implementation("com.tarasovvp.kmptemplate:shared-android:1.0")
```

The artifact is produced by [KMP_template_shared](https://github.com/TarasovVP/KMP_template_shared) and resolved from Maven Local. Publish it before building the Android application:

```shell
git clone https://github.com/TarasovVP/KMP_template_shared.git
cd KMP_template_shared
./gradlew :shared:publishToMavenLocal
```

## Companion repositories

These independent repositories form the complete example from the article:

| Repository | Role |
|---|---|
| [KMP_template_shared](https://github.com/TarasovVP/KMP_template_shared) | Shared KMP library and public contract |
| **KMP_template_android** | Android consumer with Jetpack Compose |
| [KMP_template_ios](https://github.com/TarasovVP/KMP_template_ios) | iOS consumer with SwiftUI |
| [KMP_template_desktop](https://github.com/TarasovVP/KMP_template_desktop) | JVM desktop consumer with JavaFX |
| [KMP_template_web](https://github.com/TarasovVP/KMP_template_web) | JavaScript consumer with Vite |

## Tech stack

- Kotlin 2.2.10
- Android Gradle Plugin 8.11.1
- Gradle 8.13
- Jetpack Compose
- Material 3
- AndroidX Activity and Lifecycle
- KMP library from Maven Local

## Requirements

- JDK 17+
- Android Studio or the Android command-line tools
- Android SDK 36
- Android 7.0 / API 24 or newer
- The `shared-android:1.0` artifact published to Maven Local

## Build and run

Clone this repository after publishing the shared artifact:

```shell
git clone https://github.com/TarasovVP/KMP_template_android.git
cd KMP_template_android
./gradlew :app:assembleDebug
```

Install the debug build on a connected device or emulator:

```shell
./gradlew :app:installDebug
```

Alternatively, open the project in Android Studio and run the `app` configuration.

Run the unit tests:

```shell
./gradlew :app:testDebugUnitTest
```

## Project structure

```text
app/src/
├── main/
│   ├── java/com/vnteam/kmp_template_android/
│   │   ├── MainActivity.kt       # Compose UI and shared API calls
│   │   └── ui/theme/             # Material theme
│   ├── AndroidManifest.xml
│   └── res/
├── test/                         # JVM tests
└── androidTest/                  # Instrumented tests
```

## Later automation

[KMP_template_agents](https://github.com/TarasovVP/KMP_template_agents) was created later as a separate orchestration harness built around this already-existing example set. It can coordinate changes to shared code and all four consumers, but it is not the source or parent project of this Android application.

See [AI Agents for a KMP Developer](https://levelup.gitconnected.com/ai-agents-for-a-kmp-developer-82af4e8851a9) for that later automation layer.

## License

Licensed under the [MIT License](LICENSE).
