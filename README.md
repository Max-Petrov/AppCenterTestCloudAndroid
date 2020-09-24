# AppCenterTestCloudAndroid

Application desciption:
It is the simple TODO application. The app has two screens - List of tasks and Task Details.
If the user clicks on some task item then the app will navigate to the Details page from where this task can be changed.
After some changes the user needs to click on the 'save' button to apply changes.

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
  * Copy command from the site and run it in the terminal:
    Command: "appcenter test run espresso --app "max.petrov.96-outlook.com/AppCenterTestCloudAndroid" --devices 3d223f9b --app-path app/build/outputs/apk/debug/app-debug.apk --test-series "master" --locale "en_US" --build-dir app/build/outputs/apk/androidTest/debug"
  * Waited until all tests were successfully passed (can be monitored from both the terminal and the site).
    * Waited until validation is successfully passed (Current test status: Validating)
    * Waited for the devices to free up (Current test status: Validation completed. Waiting for devices)
    * Analyzed the result of the test run

Screenshots:
1. Build on AppCenter
![Image of AppCenter Build](https://github.com/Max-Petrov/AppCenterTestCloudAndroid/blob/master/Screenshots/Successful%20builds.png)
2. Run commands in the terminal
![Image of terminal commands](https://github.com/Max-Petrov/AppCenterTestCloudAndroid/blob/master/Screenshots/Run%20commands.png)
3. Test run on AppCenter
![Image of terminal commands](https://github.com/Max-Petrov/AppCenterTestCloudAndroid/blob/master/Screenshots/Running%20tests.png)
4. Tests were successfully passed
![Image of terminal commands](https://github.com/Max-Petrov/AppCenterTestCloudAndroid/blob/master/Screenshots/Successful%20test%20run.png)
5. App screenshots
![Image of terminal commands](https://github.com/Max-Petrov/AppCenterTestCloudAndroid/blob/master/Screenshots/TaskListScreen.png)
![Image of terminal commands](https://github.com/Max-Petrov/AppCenterTestCloudAndroid/blob/master/Screenshots/TaskDetailsScreen.png)
