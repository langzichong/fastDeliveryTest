package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class SummaryOfLegalTermsPage extends Page{
    /**
     * ID
     */
    public static final String ACCEPT_BTN_ID = "android:id/button1";
    public static final String DECLINE_BTN_ID = "button2";
    public static final String ALERT_TITLE_ID = "alertTitle";
    /**
     * NAME
     */
    public static final String ALERT_TITLE_NAME = "Summary of Legal Terms";

    public SummaryOfLegalTermsPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getAcceptBtnWithWait(long timeOutInSeconds) {
        return FindHelper.findNativeElemByIdWithWait(mobileDevice.getAppiumDriver(), ACCEPT_BTN_ID, timeOutInSeconds);
    }

}
