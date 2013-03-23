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

* [Java](http://www.oracle.com/technetwork/java/)
* [Java Download](http://www.oracle.com/technetwork/java/javase/downloads/)

### Maven 3.0

```
$ export M2_HOME=/opt/maven-3.0
$ export PATH=$M2_HOME/bin:$PATH

$ mvn --version
Apache Maven 3.0.4 (r1232337; 2012-01-17 08:44:56+0000)
...
```

* [Maven](https://maven.apache.org/)
* [Maven Download](https://maven.apache.org/download.cgi)
* [Maven Installation Instructions](https://maven.apache.org/download.cgi#Installation_Instructions)

### Android SDK

The installation of the Android SDK is described in [documentation/android.md](android.md).

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

## Building

### Get the source code

```
$ cd ~
$ git clone git://github.com/vakuum/foul-android.git
$ cd foul-android/foul
```

### Create the application package

```
$ mvn clean package android:apk

$ ls target/foul.apk
target/foul.apk
```

### Start the emulator

```
$ mvn android:emulator-start
```

### Unlock the lock screen

```
$ adb shell input keyevent 82
```

### Deploy the application package

```
$ mvn android:deploy
$ mvn android:redeploy
$ mvn android:undeploy
```

### Stop the emulator

```
$ mvn android:emulator-stop
```

## Testing

### Get the source code

```
$ cd ~
$ git clone git://github.com/vakuum/foul-android.git
$ cd foul-android
```

### Create the application package

```
$ mvn clean install --projects foul

$ ls foul/target/foul.apk
foul/target/foul.apk
```

### Start the emulator

```
$ mvn android:emulator-start --projects foul
```

### Unlock the lock screen

```
$ adb shell input keyevent 82
```

### Test the application package

```
$ mvn clean integration-test --projects foul-test
```

### Stop the emulator

```
$ mvn android:emulator-stop --projects foul
```
