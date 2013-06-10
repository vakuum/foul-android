## Install the Android SDK

```
$ cd ~
$ wget http://dl.google.com/android/android-sdk_r22.0.1-linux.tgz
$ tar -zxvf android-sdk_r22.0.1-linux.tgz
$ mv android-sdk-linux android-sdk-r22.0.1
$ ln -s android-sdk-r22.0.1 android-sdk
```

* [Android](http://www.android.com/)
* [Android SDK](https://developer.android.com/sdk/)

## Set ANDROID_HOME and PATH

```
$ export ANDROID_HOME=~/android-sdk
$ export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH

$ which android
/home/clemens/android-sdk/tools/android

$ android --help
```

You can put these environment variables into the startup script of your shell.

## Install the Android target

```
$ android list targets
Available Android targets:

$ android

Android SDK Manager
-> [X] Android 2.3.3 (API 10)
-> Install 5 packages...
-> (*) Accept All
-> Install

$ android list targets
Available Android targets:
----------
id: 1 or "android-10"
     Name: Android 2.3.3
     Type: Platform
     API level: 10
     Revision: 2
     Skins: WVGA800 (default), QVGA, WQVGA400, WQVGA432, WVGA854, HVGA
     ABIs : armeabi
...
```
