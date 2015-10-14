package com.ringcentral.ta.util;

import io.appium.java_client.AppiumDriver;

public class MobileDevice {
    private AppiumDriver appiumDriver;

    public MobileDevice(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }
}
