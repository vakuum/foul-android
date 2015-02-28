# Building with Eclipse

Before you can run the application with Eclipse, make sure that you can build it with Maven as described in [documentation/maven.md](documentation/maven.md). If you skip the steps from the Maven build setup, then the following description will not work for you.

## Requirements

### Java 1.6.0

```
$ export JAVA_HOME=/opt/jdk-1.6.0
$ export PATH=$JAVA_HOME/bin:$PATH

$ java -version
java version "1.6.0_45"
...
```

* [Java](http://www.oracle.com/technetwork/java/)
* [Java Download](http://www.oracle.com/technetwork/java/javase/downloads/)

### Android SDK

The installation of the Android SDK is described in [documentation/android.md](android.md).

```
$ export ANDROID_HOME=~/android-sdk
$ export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH

$ which android
/home/clemens/android-sdk/tools/android

$ android --help
```

## Install Eclipse

Download the [Eclipse IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/lunar) from http://www.eclipse.org/ and extract it into your home directory:

```
$ cd ~
$ wget http://download.eclipse.org/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
$ tar -zxvf eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
$ ls -1 ~/eclipse/eclipse
/home/clemens/eclipse/eclipse
```

### Start Eclipse

```
$ ~/eclipse/eclipse
```

### Install Android Development Tools for Eclipse

```
Help
-> Eclipse Marketplace...
-> Find: "Android Development Tools for Eclipse"
-> Go
-> Android Development Tools for Eclipse
-> Install
-> Confirm
-> (*) I accept the terms of the license agreements
-> Finish
-> Warning: You are installing software that contains unsigned content.
-> OK
-> You will need to restart Eclipse for the changes to take effect.
-> Yes
-> Location of the Android SDK has not been setup in the preferences.
-> Open Preferences
-> SDK Location: /home/clemens/android-sdk
-> Apply
-> OK
```

* [Android Development Tools for Eclipse](https://developer.android.com/tools/sdk/eclipse-adt.html)

### Install the Android for Maven Eclipse

```
Help
-> Eclipse Marketplace...
-> Find: "Android for Maven Eclipse"
-> Go
-> Android for Maven Eclipse 1.2.1
-> Install
-> Confirm
-> (*) I accept the terms of the license agreements
-> Finish
```

* [Android for Maven Eclipse](https://github.com/rgladwell/m2e-android)

## Run the project

### Get the source code

```
$ cd ~
$ git clone git://github.com/vakuum/foul-android.git
```

### Import the project

```
File
-> Import...
-> Existing Maven Project
-> Next
-> Root Directory: /home/clemens/foul-android
-> Finish
```

### Start the project

```
Package Explorer
-> foul
-> Run As
-> Android Application
```

## Testing

### Unit tests (Robolectric)

```
Package Explorer
-> foul
-> Run As
-> JUnit Test
-> [X] Use configuration specific setting
-> Eclipse JUnit Launcher
-> OK
-> The input type of the launch configuration does not exist
-> OK
-> Name: foul unit tests
-> (*) Run all tests in the selected project, package or source folder: foul
-> Test runner: JUnit 4
-> Run
```

### Integration tests (Robotium)

```
Package Explorer
-> foul-test
-> Run As
-> Android JUnit Test
```

