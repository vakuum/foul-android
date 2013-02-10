# Building with Maven

## Requirements

### Java 1.6.0

```
$ export JAVA_HOME=/opt/jdk-1.6.0
$ export PATH=$JAVA_HOME/bin:$PATH

$ java -version
java version "1.6.0_39"
...
```

### Maven 3.0

```
$ export M2_HOME=/opt/maven-3.0
$ export PATH=$M2_HOME/bin:$PATH

$ mvn --version
Apache Maven 3.0.4 (r1232337; 2012-01-17 08:44:56+0000)
...
```

### Android SDK

The installation of the Android SDK is described in [documentation/android-sdk.md](documentation/android-sdk.md).

```
$ export ANDROID_HOME=~/android-sdk
$ export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH

$ which android
/home/clemens/android-sdk/tools/android

$ android --help
```

## Create a virtual device for the emulator

```
$ android list avd
Available Android Virtual Devices:

$ android create avd --name android-10 --target android-10 --abi armeabi

$ android list avd
Available Android Virtual Devices:
    Name: android-10
    Path: /home/clemens/.android/avd/android-10.avd
  Target: Android 2.3.3 (API level 10)
     ABI: armeabi
    Skin: WVGA800
```

## Get the source code

```
$ cd ~
$ git clone git://github.com/vakuum/foul-android.git
$ cd ~/foul-android
```

## Build the app

```
$ mvn clean package android:apk

$ ls target/foul.apk
target/foul.apk
```

## Start the emulator

```
$ mvn android:emulator-start -Dandroid.emulator.avd=android-10
```

## Deploy the app

```
$ mvn android:deploy
$ mvn android:redeploy
$ mvn android:undeploy
```

## Stop the emulator

```
$ mvn android:emulator-stop -Dandroid.emulator.avd=android-10
```

