package com.appupgrade.app_upgrade_android_java_demo_app;

public class AppUpgradeResponse {
    public boolean found;
    public boolean forceUpgrade;
    public String message;

    public boolean getFound() {
        return this.found = found;
    }

    public boolean getForceUpgrade() {
        return this.forceUpgrade = forceUpgrade;
    }

    public String getMessage() {
        return this.message = message;
    }
}
