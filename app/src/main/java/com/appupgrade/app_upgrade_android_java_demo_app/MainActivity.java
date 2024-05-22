package com.appupgrade.app_upgrade_android_java_demo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appupgrade.app_upgrade_android_sdk.AppUpgrade;
import com.appupgrade.app_upgrade_android_sdk.models.AlertDialogConfig;
import com.appupgrade.app_upgrade_android_sdk.models.AppInfo;
import com.appupgrade.app_upgrade_android_sdk.models.PreferredAndroidMarket;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String xApiKey = "YTA4MTQ3ZTMtNDFjMy00ZjQxLTg4MWYtYWY1OWNhYjQ5YzBh";

        String appId = "com.android.com";
        String appName = "Wallpaper app";
        String appVersion = "1.0.0";
        String platform = "android";
        String environment = "production";
        String appLanguage = "es"; //Your app language code. Nullable
        // String preferredAndroidMarket = PreferredAndroidMarket.OTHER;
        // String otherMarketPlaceUrl = "https://othermarketplaceurl.com";

         Map<String, Object> customAttributes = new HashMap<>();
         customAttributes.put("os", 12);
         customAttributes.put("country", "IN");
         customAttributes.put("build", 101);

        AppInfo appInfo = new AppInfo(appId, appName, appVersion, platform, environment, customAttributes);
        // AppInfo appInfo = new AppInfo(appId, appName, appVersion, platform, environment, appLanguage, preferredAndroidMarket, otherMarketPlaceUrl);

        String title = "Update Required.";
        String updateButtonTitle = "UPDATE";
        String laterButtonTitle = "Not Now";

        AlertDialogConfig alertDialogConfig = new AlertDialogConfig(title, updateButtonTitle, laterButtonTitle);
        AppUpgrade appUpgrade = new AppUpgrade();
        appUpgrade.checkForUpdates(this, xApiKey, appInfo, alertDialogConfig);
    }
}