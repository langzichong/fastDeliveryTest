package com.ringcentral.ta.test.contacts;

import com.ringcentral.ta.base.SingleDeviceTest;
import com.ringcentral.ta.util.Mobile;
import com.ringcentral.ta.util.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Set;

public class ContactsTest extends SingleDeviceTest{
    @BeforeMethod
    public void beforeMethod() {
        DesiredCapabilities capabilities = setDesiredCapabilities();
        String PORT = "4723";
        try {
            mobile = new Mobile(new MobileDevice(new AndroidDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", PORT)), capabilities)));
        } catch (Exception e) {
            e.printStackTrace();
            safeQuit();
        }
    }

    @Test
    public void test_ANUX_26(Method method) throws InterruptedException {
//        mobile.getLoginPage().getSingleSignOn(30).click();
//        Set<String> contextNames = mobile.getMobileDevice().getAppiumDriver().getContextHandles();
//        for (String contextName : contextNames) {
//            System.out.println(contextName);
//            if (contextName.contains("WEBVIEW")){
//                mobile.getMobileDevice().getAppiumDriver().context(contextName);
//            }
//        }
        mobile.getNavBar().getContactsTabWithWait(30).click();
        mobile.getContactsPage().switchToPersonal();
        // Step 1:
        mobile.getTitleBar().getTopRightBtn().click();
        mobile.getMobileDevice().getAppiumDriver().getContextHandles();
        // Step 2:
        mobile.getNativeNewContactPage().getNameField().sendKeys(method.getName());
        mobile.getNativeNewContactPage().getPhoneField().sendKeys("16501234567");
        mobile.getNativeNewContactPage().getSaveBtn().click();
        mobile.back();
        // Step 3:
        Assert.assertEquals(mobile.getContactsPage().scrollToItemByName(method.getName()).isDisplayed(), true, "Check if new created contact in list");
    }

    @Test
    public void test_ANUX_1597() throws Exception {
        // Step 1:
        mobile.getNavBar().getDialPadTabWithWait(30).click();
        mobile.getDialPadPage().dial("102");
        mobile.getVoipCallingPage().getVoipCallDurationWithWait(10);
        mobile.getVoipCallingPage().getEndCallBtn().click();
        // Step 2:
        mobile.getNavBar().getContactsTabWithWait(10).click();
        mobile.getContactsPage().switchToCompany();
        Assert.assertEquals(mobile.getContactsPage().scrollToItemByName("Additional User 1").isDisplayed(), true, "Check 'Additional User 1'");
        Assert.assertEquals(mobile.getContactsPage().scrollToItemByName("AO Extension").isDisplayed(), true, "Check 'AO Extension'");
        Assert.assertEquals(mobile.getContactsPage().scrollToItemByName("Department Extension").isDisplayed(), true, "Check 'Department Extension'");
        Assert.assertEquals(mobile.getContactsPage().scrollToItemByName("Something1 New1").isDisplayed(), true, "Check 'Something1 New1'");
        Assert.assertEquals(mobile.getContactsPage().scrollToItemByName("TMO Extension").isDisplayed(), true, "Check 'TMO Extension'");
        // Step 3:
        mobile.getNavBar().getDialPadTab().click();
        mobile.getDialPadPage().getCallBtn().click();
        mobile.getDialPadPage().getCallBtn().click();
        mobile.getVoipCallingPage().getVoipCallDurationWithWait(10);
        mobile.getVoipCallingPage().getEndCallBtn().click();
    }

    @AfterMethod
    public void afterMethod() throws IOException, InterruptedException {
        safeQuit();
    }
}
