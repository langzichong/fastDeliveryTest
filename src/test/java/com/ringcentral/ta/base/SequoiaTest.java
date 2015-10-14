package com.ringcentral.ta.base;

import com.ringcentral.ta.config.Brand;
import com.ringcentral.ta.util.Mobile;
import com.ringcentral.ta.util.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;

/**
 * Created by andy.lai on 2015/9/28.
 */
@Listeners( {
        com.ringcentral.ta.util.TestListener.class,
        } )
public class SequoiaTest extends MobileTest{

    public Mobile mobile;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("SequoiaLoginTest init");
        DesiredCapabilities capabilities = setDesiredCapabilities();
        String PORT = "4723";
        try {
            mobile = new Mobile(new MobileDevice(new AndroidDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", PORT)), capabilities)));
        } catch (Exception e) {
            e.printStackTrace();
            safeQuit();
        }
    }


    @BeforeMethod
    public void init() {
        System.out.println("SingleDeviceTest init");
        // if need login then
    }

    @AfterSuite
    public void uninit() {
        System.out.println("SingleDeviceTest uninit");
        safeQuit();
    }

    public Mobile getMobile() {
        return null;
    }

    protected DesiredCapabilities setDesiredCapabilities() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "SequoiaExample-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("deviceName", "Galaxy Note4 4.4.4");
//        capabilities.setCapability("udid", "3a8cce33");
        capabilities.setCapability("deviceName", "sumsung");
        capabilities.setCapability("udid", "4d009d5645b45011");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.ringcentral.rccoreexample");
        capabilities.setCapability("appActivity", ".LoginActivity");
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
