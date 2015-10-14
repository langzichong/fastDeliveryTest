package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class EmergencyCallingDisclaimerPage extends Page{
    /**
     * ID
     */
    public static final String ACCEPT_BTN_ID = "android:id/button1";
    public static final String DECLINE_BTN_ID = "button2";
    public static final String ALERT_TITLE_ID = "alertTitle";
    /**
     * NAME
     */
    public static final String ALERT_TITLE_NAME = "Emergency Calling Disclaimer";

    public EmergencyCallingDisclaimerPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getAcceptBtn() {
        return FindHelper.findNativeElemById(mobileDevice.getAppiumDriver(), ACCEPT_BTN_ID);
    }

}
