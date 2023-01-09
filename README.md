# App Upgrade: Android Java Demo App

[App Upgrade: Android java Demo App](https://github.com/appupgrade-dev/app_upgrade_android_java_demo_app) is a sample android app written in Java integrated with App Upgrade API to demonstrate how Force upgrade works in android app with [App Upgrade](https://appupgrade.dev).

You can find the android java demo app integrated via Android SDK in [main](https://github.com/appupgrade-dev/app_upgrade_android_java_demo_app) branch.

## Installation

To get started, clone the repo:

`$ git clone https://github.com/appupgrade-dev/app_upgrade_android_java_demo_app`

## Setup

1. Open the directory in Andriod Studio.

2. Open the `app_upgrade_android_java_demo_app\app\src\main\java\com\appupgrade\app_upgrade_android_java_demo_app\AppUpgrade.java` file, and replace required values in line 21-27
   | Key                   | Value Description |
   | -----------------------|-------------|
   | `xApiKey`     | Your API Key. Required. |
   | `appName`  | Your app name. Required. |
   | `appVersion`  | Your app version. Required. |
   | `platform`  | Your app platform, ex: android or iOS. Required. |
   | `environment`  | Your app enviroment, ex: dev, stating, production. Required. |

2. Save `AppUpgrade.java` file.

3. Run the app.

## Usage:   

1. Head to [App Upgrade](https://appupgrade.dev) and signup if not already.
2. Create a new Project.
3. Grab the API Key. You will need to provide the same in the required fields mentioned in above section.
4. Create a new version with the required details and force upgrade field as selected. Make sure the details provided in version matches with the details provided in the App.js file.
5. Refresh the app and you will be able to see a popup for force upgrade.
6. Edit the version in dashboard with Force upgrade field unselected. Refresh the app and you will see a popup with soft upgrade with a button to upgrade later.
 > For full details on how to use App Upgrade dashboard read our [Documentation](https://appupgrade.dev/docs)

## Screenshots
 ![forceupgrade_android_java](https://raw.githubusercontent.com/appupgrade-dev/app-upgrade-assets/main/images/forceupgrade_android_java.png)

## Need help?

If you're looking for help, try our [Documentation](https://appupgrade.dev/docs/) or our [FAQ](https://appupgrade.dev/docs/app-upgrade-faq).
If you need support please write to us at appupgrade.dev@gmail.com