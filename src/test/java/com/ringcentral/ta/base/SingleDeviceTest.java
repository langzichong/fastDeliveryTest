package com.ringcentral.ta.base;

import com.ringcentral.ta.config.Brand;
import com.ringcentral.ta.util.Mobile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class SingleDeviceTest extends MobileTest {

    public Mobile mobile;
    @BeforeMethod
    public void init() {
        System.out.println("SingleDeviceTest init");
        // if need login then
    }

    @AfterMethod
    public void uninit() {
        System.out.println("SingleDeviceTest uninit");
    }

    public Mobile getMobile() {
        return null;
    }

    protected DesiredCapabilities setDesiredCapabilities() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "RCMobile_7.4.0.1.96_XIA_UP_Automation.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("deviceName", "Galaxy Note4 4.4.4");
//        capabilities.setCapability("udid", "3a8cce33");
        capabilities.setCapability("deviceName", "Nexus5_4.4");
        capabilities.setCapability("udid", "4d009d5645b45011");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", Brand.getPackageNameByBrand());
        capabilities.setCapability("appActivity", "com.ringcentral.android.LoginScreen");
//        capabilities.setCapability("unicodeKeyboard", "True");
//        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability("newCommandTimeout", "999999");

        return capabilities;
    }

    protected void safeQuit() {
        if (mobile != null && mobile.getMobileDevice().getAppiumDriver() != null) {
            mobile.getMobileDevice().getAppiumDriver().quit();
        }
    }
}
