package com.ringcentral.ta.test;

import com.ringcentral.ta.base.SingleDeviceTest;
import com.ringcentral.ta.util.CmdLineExecutor;
import com.ringcentral.ta.util.CommonActions;
import com.ringcentral.ta.util.Mobile;
import com.ringcentral.ta.util.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Tested for 60 times, adb worked normally.
 */
public class KillAppAndStartWithLogoutVerification extends SingleDeviceTest {
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // first login
        DesiredCapabilities capabilities = setDesiredCapabilities();
        AndroidDriver driver = null;
        try {
            String PORT = "4723";
            driver = new AndroidDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", PORT)), capabilities);
            mobile = new Mobile(new MobileDevice(driver));

            CommonActions.doLoginKillTips(mobile);
        } catch (Exception e) {
            e.printStackTrace();
            if (driver != null)
                driver.quit();
        }
        mobile.endSession();
    }

    @BeforeMethod
    public void beforeMethod() {
        DesiredCapabilities capabilities = setDesiredCapabilities();
        AndroidDriver driver = null;
        for (int i = 0; i < 100; i++) {
            try {
                CmdLineExecutor.killCurrentAppByAdb();
                String PORT = "4723";
                driver = new AndroidDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", PORT)), capabilities);
                mobile = new Mobile(new MobileDevice(driver));
                mobile.getTitleBar().getTitleBarPhotoWithWait(15).click();
                mobile.getMyProfilePage().getLogout().click();
                CommonActions.doLogin(mobile);
                mobile.getTitleBar().getTitleBarPhotoWithWait(15);
            } catch (Exception e) {
                e.printStackTrace();
                if (driver != null)
                    driver.quit();
            }
            mobile.endSession();
        }
    }

    @Test
    public void test_ANUX_26() {

    }
}
