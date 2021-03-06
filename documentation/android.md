## Install the Android SDK

```
$ cd ~
$ wget http://dl.google.com/android/android-sdk_r24.4.1-linux.tgz
$ tar -zxvf android-sdk_r24.4.1-linux.tgz
$ mv android-sdk-linux android-sdk-r24.4.1
$ ln -s android-sdk-r24.4.1 android-sdk
```

* [Android](https://www.android.com/)
* [Android SDK](https://developer.android.com/sdk/)
* [SDK Build Tools release notes](https://developer.android.com/studio/releases/build-tools)
* [SDK Platform release notes](https://developer.android.com/studio/releases/platforms)
* [SDK Platform Tools release notes](https://developer.android.com/studio/releases/platform-tools)

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
-> Show: [X] Obsolete
-> [X] Android SDK Tools (24.4.1)
-> [X] Android SDK Platform-tools (29.0.6)
-> [X] Android SDK Build-tools (25.0.3)
-> [X] Android 2.3.3 (API 10)
-> Install 9 packages...
-> (*) Accept License
-> Install

$ android list targets
Available Android targets:
----------
id: 1 or "android-10"
     Name: Android 2.3.3
     Type: Platform
     API level: 10
     Revision: 2
     Skins: HVGA, QVGA, WQVGA400, WQVGA432, WVGA800 (default), WVGA854
 Tag/ABIs : default/armeabi, default/armeabi-v7a, default/x86, google_apis/armeabi-v7a, google_apis/x86
...
```

