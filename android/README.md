# Dear Style Android

Native Android foundation for Dear Style.

## Local Setup

This project uses Kotlin and Jetpack Compose.
Use JDK 17 with the Android Gradle Plugin version defined in [../docs/architecture/technology_stack.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture/technology_stack.md).

### Install Requirements

On macOS:

```bash
brew install openjdk@17 gradle
```

If `brew` is not available, install Homebrew first or install a JDK 17 distribution such as Temurin or Zulu from its macOS installer.

Point your shell at JDK 17:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH="$JAVA_HOME/bin:$PATH"

java -version
gradle --version
```

If `java -version` still shows Java 11, check which JDKs macOS can see:

```bash
/usr/libexec/java_home -V
```

For Homebrew JDK installs, macOS may need a JavaVirtualMachines symlink:

```bash
sudo ln -sfn "$(brew --prefix openjdk@17)/libexec/openjdk.jdk" \
  /Library/Java/JavaVirtualMachines/openjdk-17.jdk

export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH="$JAVA_HOME/bin:$PATH"
java -version
```

If your shell still resets to Java 11, look for an older `JAVA_HOME` export in `~/.zshrc`, `~/.zprofile`, or Conda activation scripts and replace it with the JDK 17 value.

Install Android Studio, then open the `android/` directory and install:

- Android SDK Platform 36
- Android SDK Build-Tools
- Android SDK Platform-Tools

The Gradle plugins declared in `build.gradle.kts` are downloaded automatically during the first Gradle sync/build. They are not installed manually.

This project enables AndroidX in `gradle.properties`; Compose and Activity dependencies require it.

### Build

```bash
cd android
gradle :app:assembleDebug
```

From the repository root:

```bash
make android-build
```

### Optional Gradle Wrapper

For team and CI consistency, add a Gradle wrapper after Gradle is installed:

```bash
cd android
gradle wrapper --gradle-version 9.4.1
./gradlew :app:assembleDebug
```

Phase 01 currently includes:

- Welcome screen
- Consent screen
- Shared design token colors
- API DTO/client skeleton for auth and consents
