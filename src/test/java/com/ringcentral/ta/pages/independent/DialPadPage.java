package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class DialPadPage extends Page {
    /**
     * ID
     */
    public static final String KEY_1_ID = "one";
    public static final String KEY_2_ID = "two";
    public static final String KEY_0_ID = "zero";
    public static final String CALL_BTN_ID = "btnCall";
    public static final String DIGITS_FIELD_ID = "digits";
    public static final String BACKSPACE_BTN_ID = "backspace";

    public DialPadPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getKey1() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), KEY_1_ID);
    }

    public WebElement getKey2() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), KEY_2_ID);
    }

    public WebElement getKey0() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), KEY_0_ID);
    }

    public WebElement getCallBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), CALL_BTN_ID);
    }

    public WebElement getBackSpaceBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), BACKSPACE_BTN_ID);
    }

    public WebElement getDigitsField() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), DIGITS_FIELD_ID);
    }

    public void clearDigitsField() {
        if (!getDigitsField().getText().isEmpty())
            ((MobileElement)getBackSpaceBtn()).tap(1, 2000);
    }

    public void dial(String phoneNumber) throws Exception {
        clearDigitsField();
        for (char number : phoneNumber.toCharArray()) {
            switch (number) {
                case '1':
                    getKey1().click();
                    break;
                case '2':
                    getKey2().click();
                    break;
                case '3':
                    getKey0().click();
                case '0':
                    getKey0().click();
                    break;
                default:
                    throw new Exception(String.format("Error: '%c' isn't a valid number!", number));
            }
        }
        getCallBtn().click();
    }
}
