package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class LoginPage {
    /**
     * ID
     */
    public static final String PHONE_ID = "phone";
    public static final String EXTENSION_ID = "extension";
    public static final String PASSWORD_ID = "password";

    public static final String LOGIN_BTN_ID = "btnSignIn";
    public static final String SSO = "txtSignup";

    private MobileDevice mobileDevice;
    public LoginPage(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }

    public WebElement getPhoneFieldWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), PHONE_ID, timeOutInSeconds);
    }

    public WebElement getExtensionField() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), EXTENSION_ID);
    }

    public WebElement getSingleSignOn(long timeOutInSeconds) {
        return FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), SSO, timeOutInSeconds);
    }

    public WebElement getExtensionFieldWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), EXTENSION_ID, timeOutInSeconds);
    }

    public WebElement getPasswordField() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), PASSWORD_ID);
    }

    public WebElement getLoginBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), LOGIN_BTN_ID);
    }
}
