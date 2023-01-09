package com.appupgrade.app_upgrade_android_java_demo_app;

import android.net.Uri;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;

public class AppUpgrade {

    public void checkForUpdate(Activity parentActivity) {
        AppUpgradeService appUpgradeService = RetrofitClient.getRetrofitInstance().create(AppUpgradeService.class);

        // Set the API key and other headers
        String apiKey = "ZWY0ZDhjYjgtYThmMC00NTg5LWI0NmUtMjM5OWZkNjkzMzQ5";

        // Set the request parameters
        String appName = "Wallpaper app";
        String appVersion = "1.0.0";
        String platform = "android";
        String environment = "production";

        Call <AppUpgradeResponse> call = appUpgradeService.versionCheck(
                apiKey, appName, appVersion, platform, environment
        );

        call.enqueue(new Callback<AppUpgradeResponse>() {
            @Override
            public void onResponse(Call<AppUpgradeResponse> call, Response<AppUpgradeResponse> response) {
                if (response.code() == 200) {
                    Log.i("App Upgrade: ", "Response Success");

                    AppUpgradeResponse appUpgradeResponse = response.body();

                    if (appUpgradeResponse.getFound()) {
                        Log.i("App Upgrade: ", "Version found, Update required.");
                        if (appUpgradeResponse.getForceUpgrade()) {
                            Log.i("App Upgrade: ", "Force Update required.");
                            showForceUpgradePopup(parentActivity, appUpgradeResponse.getMessage());
                        } else {
                            Log.i(
                                    "App Upgrade: ",
                                    "Force Update is not required but update is recommended."
                            );
                            showUpgradePopup(parentActivity, appUpgradeResponse.getMessage());
                        }
                    } else {
                        Log.i("App Upgrade: ", "Version not found, Update not required.");
                    }
                }
            }

            @Override
            public void onFailure(Call<AppUpgradeResponse> call, Throwable t) {
                Log.i("App Upgrade: ", "Error");
            }
        });
    }

    public void showForceUpgradePopup(Activity parentActivity, String updateMessage) {
        Log.i("App Upgrade: ", "Show force upgrade popup.");

        new AlertDialog.Builder(parentActivity)
                .setTitle("Please Update")
                .setMessage(updateMessage)
                .setPositiveButton("Update Now", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onUserUpdate(parentActivity);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showUpgradePopup(Activity parentActivity, String updateMessage) {
        Log.i("App Upgrade: ", "Show upgrade popup.");

        new AlertDialog.Builder(parentActivity)
                .setTitle("Please Update")
                .setMessage(updateMessage)
                .setPositiveButton("Update Now", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onUserUpdate(parentActivity);
                    }
                })
                .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onUserLater();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void onUserLater() {
        Log.i("App Upgrade: ", "Later.");
    }

    public void onUserUpdate(Activity parentActivity) {
        Log.i("App Upgrade: ", "Update Now.");
        String appId = BuildConfig.APPLICATION_ID;
        try {
            parentActivity.startActivity(
                    new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=$appId")
                    )
            );
        } catch (ActivityNotFoundException anfe) {
            parentActivity.startActivity(
                    new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=$appId")
                    )
            );
        }
    }
}
