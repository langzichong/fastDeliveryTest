package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class WelcomePage {
    /**
     * ID
     */
    public static final String SKIP_BTN_ID = "whats_new_button_left";
    private MobileDevice mobileDevice;
    public WelcomePage(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }

    public WebElement getSkipBtnByIdWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), SKIP_BTN_ID, timeOutInSeconds);
    }
}
