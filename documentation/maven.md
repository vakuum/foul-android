# Building with Maven

## Requirements

### Java 1.8.0

```
$ export JAVA_HOME=/opt/jdk-1.8.0
$ export PATH=$JAVA_HOME/bin:$PATH

$ java -version
java version "1.8.0_281"
Java(TM) SE Runtime Environment (build 1.8.0_281-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.281-b09, mixed mode)
...
```

* [Java](https://www.oracle.com/java/technologies/)
* [Java Download](https://www.oracle.com/java/technologies/javase-downloads.html)

### Maven 3.1

```
$ export M2_HOME=/opt/maven-3.1
$ export PATH=$M2_HOME/bin:$PATH

$ mvn --version
Apache Maven 3.1.1 (0728685237757ffbf44136acec0402957f723d9a; 2013-09-17 17:22:22+0200)
...
```

* [Maven](https://maven.apache.org/)
* [Maven Download](https://maven.apache.org/download.cgi)

### Android SDK

The installation of the Android SDK is described in [documentation/android.md](android.md).

```
$ export ANDROID_HOME=~/android-sdk
$ export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH

$ which android
/home/clemens/android-sdk/tools/android

$ android --help
```

### Maven Android SDK Deployer

From [Maven Android SDK Deployer](https://github.com/mosabua/maven-android-sdk-deployer):

> The Maven Android SDK Deployer is a helper maven project that can be used to install the libraries necessary to build Android applications with Maven and the Android Maven Plugin directly from your local Android SDK installation.

```
$ cd ~
$ git clone https://github.com/mosabua/maven-android-sdk-deployer
$ cd maven-android-sdk-deployer
$ git checkout 4c545b6c20a13d9885506fd4790cc7298096c502
$ mvn install -P 2.3.3
```

* [Maven Android SDK Deployer](https://github.com/mosabua/maven-android-sdk-deployer)

## Create a virtual device for the emulator

```
$ android list avd
Available Android Virtual Devices:

$ android create avd --name android-10 --target android-10 --abi armeabi
...
Do you wish to create a custom hardware profile [no] no
...

$ android list avd
Available Android Virtual Devices:
    Name: android-10
    Path: /home/clemens/.android/avd/android-10.avd
  Target: Android 2.3.3 (API level 10)
 Tag/ABI: default/armeabi
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
$ mvn clean package android:apk -DskipTests

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

### Unit tests with Robolectric

* [Robolectric](http://robolectric.org/)

```
$ mvn clean test --projects foul
...
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.341 sec
...
```

### Integration tests with Robotium

* [Robotium](https://github.com/robotiumtech/robotium)

#### Create the application package

```
$ mvn clean install --projects foul

$ ls foul/target/foul.apk
foul/target/foul.apk
```

#### Start the emulator

```
$ mvn android:emulator-start --projects foul
```

#### Unlock the lock screen

```
$ adb shell input keyevent 82
```

#### Run the integration tests

```
$ mvn android:deploy --projects foul

$ mvn clean integration-test --projects foul-test
...
[INFO]   Tests run: 5,  Failures: 0,  Errors: 0
...

$ mvn android:undeploy --projects foul
```

#### Stop the emulator

```
$ mvn android:emulator-stop --projects foul
```
