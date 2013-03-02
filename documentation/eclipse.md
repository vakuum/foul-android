# Building with Eclipse

Before you can run this application with Eclipse, make sure that you can build it with Maven as described in [documentation/maven.md](documentation/maven.md). If you skip the steps from the Maven build setup, then the following description will not work for you.

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

### Android SDK

The installation of the Android SDK is described in [documentation/android-sdk.md](android-sdk.md).

```
$ export ANDROID_HOME=~/android-sdk
$ export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH

$ which android
/home/clemens/android-sdk/tools/android

$ android --help
```

## Install Eclipse

Download the [Eclipse IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/junosr1) from http://www.eclipse.org/ and extract it into your home directory:

```
$ cd ~
$ wget http://download.eclipse.org/technology/epp/downloads/release/juno/SR1/eclipse-java-juno-SR1-linux-gtk-x86_64.tar.gz
$ tar -zxvf eclipse-java-juno-SR1-linux-gtk-x86_64.tar.gz
$ ls -1 ~/eclipse/eclipse
/home/clemens/eclipse/eclipse
```

### Start Eclipse

```
$ ~/eclipse/eclipse
```

### Install the Android Development Tools for Eclipse

```
Help
-> Eclipse Marketplace...
-> Find: "Android Development Tools for Eclipse"
-> Go
-> Install
-> Next
-> (*) I accept the terms of the license agreements
-> Finish

Window
-> Preferences
-> Android
-> SDK Location: /home/clemens/android-sdk
-> OK
```

* [Android Development Tools for Eclipse](https://developer.android.com/tools/sdk/eclipse-adt.html)

### Install the Android Configurator for M2E

```
Help
-> Eclipse Marketplace...
-> Find: "Android Configurator for M2E"
-> Go
-> Install
-> Next
-> (*) I accept the terms of the license agreements
-> Finish
```

* [Android Configurator for M2E](https://github.com/rgladwell/m2e-android)

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
-> Next
-> Finish
```

### Start the project

```
Package Explorer
-> foul
-> Run As
-> Android Application
```

### Test the project

```
Package Explorer
-> foul-test
-> Run As
-> Android JUnit Application
```

