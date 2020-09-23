# AppCenterTestCloudAndroid

Steps:

* Registered an account on AppCenter
* Registered an account on GitHub
* Created a repository on GitHub
* Implemented an Android application
* Implemented Espresso UI tests
* Pushed all the changes to the GitHub repo
* Created application on AppCenter (Android + Java/Kotlin)
* Made the first build on AppCenter from my GitHub repo
* Installed the AppCenter CLI
  * Installed Node v10.12.0.
  * Installed the appcenter tool using the following command "npm install -g appcenter-cli"  
* Created new Test Run on AppCenter
  * Configured the following device set: Motorolla One Zoom (Android 10) and Huawei P10 (Android 7)
  * Selected 'master' test series
  * Selected 'Espresso' as a testing framework
  * Copy command from the site and run it via the terminal:
    Command: "appcenter test run espresso --app "max.petrov.96-outlook.com/AppCenterTestCloudAndroid" --devices 3d223f9b --app-path app/build/outputs/apk/debug/app-debug.apk --test-series "master" --locale "en_US" --build-dir app/build/outputs/apk/androidTest/debug"
  * Waited until all tests were successfully passed (can be monitored from both the terminal and the site).
    * Waited untill validation steps were successfully passed
    * Waited until the devices are busy.
