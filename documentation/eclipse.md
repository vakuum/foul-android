# Building with Eclipse

Before you can run the application with Eclipse, make sure that you can build it with Maven as described in [documentation/maven.md](maven.md). If you skip the steps from the Maven build setup, then the following description will not work for you.

## Requirements

### Java 1.8.0

```
$ export JAVA_HOME=/opt/jdk-1.8.0
$ export PATH=$JAVA_HOME/bin:$PATH

$ java -version
java version "1.8.0_281"
...
```

* [Java](https://www.oracle.com/java/technologies/)
* [Java Download](https://www.oracle.com/java/technologies/javase-downloads.html)

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

Download the [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/release/2020-06/r) from http://www.eclipse.org/ and extract it into your home directory:

```
$ cd ~
$ wget https://download.eclipse.org/technology/epp/downloads/release/2020-06/R/eclipse-java-2020-06-R-linux-gtk-x86_64.tar.gz
$ tar -zxvf eclipse-java-2020-06-R-linux-gtk-x86_64.tar.gz
$ ls -1 ~/eclipse/eclipse
/home/clemens/eclipse/eclipse
```

### Start Eclipse

```
$ ~/eclipse/eclipse
```

### Install Android Development Tools for Android

```
Help
-> Eclipse Marketplace...
-> Find: "Andmore: Development Tools for Android"
-> Go
-> Andmore: Development Tools for Android 0.5.1
-> Install
-> Confirm
-> (*) I accept the terms of the license agreements
-> Finish
-> Restart Eclipse IDE to apply the software update?
-> Restart Now
-> Location of the Android SDK has not been setup in the preferences.
-> Close
-> (*) Use existing SDKs
-> Existing Location: /home/clemens/android-sdk
-> Finish
-> Send usage statistics to Google?
-> (*) No
-> Finish
```

* [Andmore: Development Tools for Android](https://projects.eclipse.org/projects/tools.andmore)
* [Andmore: Development Tools for Android](https://marketplace.eclipse.org/content/andmore-development-tools-android)

### Install Android for Maven Eclipse

```
Help
-> Install New Software...
-> Add...
-> Location: https://rgladwell.github.io/m2e-android/updates/
-> Add
-> [X] Android for Maven Eclipse 1.4.0
-> Next
-> Next
-> (*) I accept the terms of the license agreements
-> Finish
-> Warning: Installing unsigned software for which the authenticity of validity cannot be established. Continue with the installation?
-> Install anyway
-> Restart Eclipse IDE to apply the software update?
-> Restart Now
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
-> Maven
-> Existing Maven Projects
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

