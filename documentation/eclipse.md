# Building with Eclipse

Before you can run the application with Eclipse, make sure that you can build it with Maven as described in [documentation/maven.md](maven.md). If you skip the steps from the Maven build setup, then the following description will not work for you.

## Requirements

### Java 1.8.0

```
$ export JAVA_HOME=/opt/jdk-1.8.0
$ export PATH=$JAVA_HOME/bin:$PATH

$ java -version
java version "1.8.0_131"
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

Download the [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon3) from http://www.eclipse.org/ and extract it into your home directory:

```
$ cd ~
$ wget http://download.eclipse.org/technology/epp/downloads/release/neon/3/eclipse-java-neon-3-linux-gtk-x86_64.tar.gz
$ tar -zxvf eclipse-java-neon-3-linux-gtk-x86_64.tar.gz
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
-> Close
-> (*) Use existing SDKs
-> Existing Location: /home/clemens/android-sdk
-> Next
-> Send usage statistics to Google?
-> (*) No
-> Finish
```

* [Android Development Tools for Eclipse](https://developer.android.com/tools/sdk/eclipse-adt.html)

### Install Android for Maven Eclipse

```
Help
-> Install New Software...
-> Add...
-> Location: http://rgladwell.github.io/m2e-android/updates/
-> OK
-> [X] Android for Maven Eclipse 1.4.0
-> Next
-> Next
-> (*) I accept the terms of the license agreement
-> Finish
-> Warning: You are installing software that contains unsigned content.
-> OK
-> You will need to restart Eclipse for the changes to take effect.
-> Yes
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
```

### Integration tests (Robotium)

```
Package Explorer
-> foul-test
-> Run As
-> Android JUnit Test
```

