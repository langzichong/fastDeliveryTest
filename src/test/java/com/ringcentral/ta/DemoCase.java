//package com.ringcentral.ta;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class DemoCase {
//    AndroidDriver driver;
//    SubTitleHelper subtitleMaker;
//
//    @BeforeMethod
//    public void setUp() throws IOException, InterruptedException {
//        String packageName= "com.ringcentral.android";
//        // set up appium
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "RCMobile_7.4.0.1.65_XIA_UP_Automation.apk");
//
//
//        DesiredCapabilities capabilitiesDevice = new DesiredCapabilities();
//        capabilitiesDevice.setCapability("deviceName", "015d8bece817f415");
//        capabilitiesDevice.setCapability("platformVersion", "5.0.1");
//        capabilitiesDevice.setCapability("app", app.getAbsolutePath());
//        capabilitiesDevice.setCapability("appPackage", packageName);
//        RecordHelper.startRec("testMakeCall");
//        subtitleMaker= new SubTitleHelper("testMakeCall.srt");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesDevice);
//    }
//
//    @Test
//    public void testMakeCall() throws InterruptedException, IOException {
//        // first login
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        System.out.println("*** Timer *** + start: " + dateFormat.format(new Date()));
//
//        subtitleMaker.addStepMsgToSubtitle("STEP 1: click DialPad");
//        clickDialPad();
//        subtitleMaker.addStepMsgToSubtitle("STEP 2: call 108");
//        clickNumber1();
//        clickNumber0();
//        clickNumber8();
//        clickCallButton();
//        subtitleMaker.addStepMsgToSubtitle("STEP 3: click the source");
//        clickSourceButton();
//        subtitleMaker.addStepMsgToSubtitle("STEP 4: call lasts for 20s");
//        Thread.sleep(20000);
//        subtitleMaker.addStepMsgToSubtitle("STEP 5: end the call");
//        clickEndCallButton();
//        System.out.println("*** Timer *** + end: " + dateFormat.format(new Date()));
//    }
//    public void clickNumber1(){
//        driver.findElement(By.id("com.ringcentral.android:id/one")).click();
//    }
//    public void clickNumber0(){
//        driver.findElement(By.id("com.ringcentral.android:id/zero")).click();
//    }
//    public void clickNumber8(){
//        driver.findElement(By.id("com.ringcentral.android:id/eight")).click();
//    }
//    public void clickCallButton(){
//        driver.findElement(By.id("com.ringcentral.android:id/btnCall")).click();
//    }
//    public void clickSourceButton(){
//        driver.findElement(By.id("com.ringcentral.android:id/btn_4")).click();
//    }
//    public void clickEndCallButton(){
//        driver.findElement(By.id("com.ringcentral.android:id/btn_call_endcall")).click();
//    }
//    public void clickDialPad() throws InterruptedException {
//        WebDriverWait waitDriver = new WebDriverWait(driver, 20);
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.name("Dial Pad")));
//        driver.findElement(By.name("Dial Pad")).click();
//        Thread.sleep(2000);
//    }
//    @AfterMethod
//    public void tearDown() throws InterruptedException, IOException {
//        Thread.sleep(3000);
//        driver.quit();
//        Thread.sleep(3000);
//        subtitleMaker.finishSubtitle();
//        RecordHelper.stopRec();
//    }
//}
