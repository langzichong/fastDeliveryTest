package com.ringcentral.ta.pages.base;

import com.ringcentral.ta.util.MobileDevice;
import io.appium.java_client.AppiumDriver;

public class Page {
    protected static MobileDevice mobileDevice;
    public Page(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }
}
