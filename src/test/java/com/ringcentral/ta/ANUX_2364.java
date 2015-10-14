//package com.ringcentral.ta;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.hamcrest.MatcherAssert;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class ANUX_2364 {
//    private AndroidDriver driverCaller;
//    private AndroidDriver driverCallee;
//    private SubTitleHelper subtitleMaker;
//    private Thread calleeThread;
//
//    // ids
//    private static final String packageName = "com.ringcentral.android";
//    private static final String acceptBtnId = "android:id/button1";
//    private static final String clearBtnId = "android:id/button1";
//    private static final String alertTitle911Text = "E911 Terms of Service";
//    private static final String loginPhoneFieldId = "com.ringcentral.android:id/phone";
//    private static final String loginExtFieldId = "com.ringcentral.android:id/extension";
//    private static final String loginPasswordFieldId = "com.ringcentral.android:id/password";
//    private static final String signInBtnId = "com.ringcentral.android:id/btnSignIn";
//    private static final String skipBtnId = "com.ringcentral.android:id/whats_new_button_left";
//    private static final String inputPhoneNumberEditTextId = "com.ringcentral.android:id/username_edit";
//    private static final String saveBtnId = "com.ringcentral.android:id/saveBtn";
//    private static final String annimationCloseBtnId = "com.ringcentral.android:id/btnClose";
//    private static final String moreBtnId = "com.ringcentral.android:id/layout_plus";
//    private static final String digitsEditTextId = "com.ringcentral.android:id/digits";
//    private static final String tabId = "com.ringcentral.android:id/text_tab_name";
//    private static final String titleId = "com.ringcentral.android:id/title";
//    private static final String topLeftImageId =  "com.ringcentral.android:id/btnTopLeftImage";
//    private static final String topLeftBtnId =  "com.ringcentral.android:id/btnTopLeft";
//    private static final String topRightBtnId =  "com.ringcentral.android:id/btnTopRight";
//    private static final String newSmsBtnId = "com.ringcentral.android:id/btn_main_menu_action_sms";
//    private static final String editContactAreaId = "com.ringcentral.android:id/edit_contact_area";
//    private static final String messageEditTextId = "com.ringcentral.android:id/message_edittext";
//    private static final String messageListId = "com.ringcentral.android:id/text_messages_list";
//    private static final String okBtn = "com.ringcentral.android:id/btn_ok";
//    private static final String dialPadBtnName = "Dial Pad";
//    private static final String key1Id = "com.ringcentral.android:id/one";
//    private static final String key2Id = "com.ringcentral.android:id/two";
//    private static final String key0Id = "com.ringcentral.android:id/zero";
//    private static final String callBtnId = "com.ringcentral.android:id/btnCall";
//    private static final String endCallBtnId = "com.ringcentral.android:id/btn_call_endcall";
//    private static final String answerCallBtnId = "com.ringcentral.android:id/btn_call_answer";
//
//    // names
//    private static final String dialPadName = "Dial Pad";
//    private final static String COMPANY_NUMBER = "18559730001";
//    private final static String SYSTEM_EXT = "101";
//    private final static String SYSTEM_PASS = "Test!123";
//    private final static String ADMIN_EXT = "102";
//    private final static String ADMIN_PASS = "Test!102";
//    private final static int CALLER_PORT = 4730;
//    private final static int CALLEE_PORT = 4830;
//
//    @BeforeMethod
//    public void setUp() throws IOException, InterruptedException {
//        String packageName= "com.ringcentral.android";
//        // set up appium
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "RCMobile_7.4.0.1.76_XIA_UP_Automation.apk");
//        // caller
//        DesiredCapabilities capabilitiesCallerDevice = new DesiredCapabilities();
//        capabilitiesCallerDevice.setCapability("deviceName", "Nexus5_4.4");
//        capabilitiesCallerDevice.setCapability("udid", "4d009d5645b45011");
//        capabilitiesCallerDevice.setCapability("platformVersion", "4.4.2");
//        capabilitiesCallerDevice.setCapability("app", app.getAbsolutePath());
//        capabilitiesCallerDevice.setCapability("appPackage", packageName);
//        // callee
//        DesiredCapabilities capabilitiesCalleeDevice = new DesiredCapabilities();
//        capabilitiesCalleeDevice.setCapability("deviceName", "Nexus5_5.0");
//        capabilitiesCalleeDevice.setCapability("udid", "4d009d5645b45011");
//        capabilitiesCalleeDevice.setCapability("platformVersion", "5.0");
//        capabilitiesCalleeDevice.setCapability("app", app.getAbsolutePath());
//        capabilitiesCalleeDevice.setCapability("appPackage", packageName);
//        // start rec and making subtitle
//        RecordHelper.startRec("ANUX-2364");
//        subtitleMaker = new SubTitleHelper("ANUX-2364.srt");
//
//        // start callee thread
//        calleeThread = new Thread() {
//            @Override
//            public void run() {
//                // initial callee
//                try {
//                    driverCallee = new AndroidDriver(new URL(String.format("http://127.0.0.1:%d/wd/hub", CALLEE_PORT)), capabilitiesCalleeDevice);
//                    firstLogin(driverCallee, COMPANY_NUMBER, ADMIN_EXT, ADMIN_PASS);
//                    waitToPickupIncomingCall(driverCallee);
//                    Thread.sleep(2000);
//                    RecordHelper.startPlayingMedia();
//                    RecordHelper.stopPlayingMedia();
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        calleeThread.start();
//        driverCaller = new AndroidDriver(new URL(String.format("http://127.0.0.1:%d/wd/hub", CALLER_PORT)), capabilitiesCallerDevice);
//    }
//
//    @Test
//    public void test_ANUX_2364() throws InterruptedException, IOException {
//        firstLogin(driverCaller, COMPANY_NUMBER, SYSTEM_EXT, SYSTEM_PASS);
//        // print script
//        subtitleMaker.addStepMsgToSubtitle("STEP 1: Enter extension number using dialpad");
//        naviToDialPad(driverCaller);
//        clickNumber1(driverCaller);
//        clickNumber0(driverCaller);
//        clickNumber2(driverCaller);
//        // step 1 check
//        assertEquals(driverCaller.findElement(By.id("com.ringcentral.android:id/digits")).getText(), "1 (02 )", "CHeck extension number showed in phone number field");
//        subtitleMaker.addStepMsgToSubtitle("STEP 2: Tap call");
//        clickCallButton(driverCaller);
//        // step 2 check
//        assertTrue(driverCaller.findElement(By.id("com.ringcentral.android:id/btn_call_endcall")).isDisplayed(), "Voip call initiated. Active call screen goes to foreground ");
//        subtitleMaker.addStepMsgToSubtitle("STEP 3(Manual): Check if call is connected and media goes in both sides(Media playing now)");
//        // step 3 need manual check
//        Thread.sleep(15000);
//        subtitleMaker.addStepMsgToSubtitle("STEP 3(Manual): End call");
//        clickEndCallButton(driverCaller);
//    }
//
//
//    @AfterMethod
//    public void tearDown() throws InterruptedException, IOException {
//        Thread.sleep(5000);
//        driverCaller.quit();
//        driverCallee.quit();
//        subtitleMaker.finishSubtitle();
//        RecordHelper.stopRec();
//        calleeThread.join();
//    }
//
//    private void firstLogin(AndroidDriver drv, String phone, String ext, String password) {
//        WebDriverWait waitDriver = new WebDriverWait(drv, 20);
//        // login
//        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id(loginPhoneFieldId)));
//        // account type: RC_OFFICE.3324_9U_2DP1AO1TMO_9DID
//        drv.findElement(By.id(loginPhoneFieldId)).sendKeys(phone);
//        drv.findElement(By.id(loginExtFieldId)).sendKeys(ext);
//        drv.findElement(By.id(loginPasswordFieldId)).sendKeys(password);
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(signInBtnId)));
//        drv.findElement(By.id(signInBtnId)).click();
//        // click 'Summary of Legal Terms'
//        waitDriver.withTimeout(30, TimeUnit.SECONDS);
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(acceptBtnId)));
//        drv.findElement(By.id(acceptBtnId)).click();
//        // click 'E911 Terms of Service'
//        waitDriver.withTimeout(10, TimeUnit.SECONDS);
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(acceptBtnId)));
//        drv.findElement(By.id(acceptBtnId)).click();
//        // skip What's New
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(skipBtnId)));
//        drv.findElement(By.id(skipBtnId)).click();
//        // input mobile phone number and save
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(inputPhoneNumberEditTextId)));
//        drv.findElement(By.id(inputPhoneNumberEditTextId)).sendKeys("12345678901");
//        drv.findElement(By.id(saveBtnId)).click();
//        // clear annotation
//        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(annimationCloseBtnId)));
//        drv.findElement(By.id(annimationCloseBtnId)).click();
//        drv.findElement(By.id(moreBtnId)).click();
//        drv.findElement(By.id(moreBtnId)).click();
//        // check Message Screen shown
//        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id(titleId)));
//    }
//
//    private void waitToPickupIncomingCall(AndroidDriver drv) {
//        WebDriverWait waitDriver = new WebDriverWait(drv, 30);
//        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id(answerCallBtnId)));
//        drv.findElement(By.id(answerCallBtnId)).click();
//    }
//
//    private void naviToDialPad(AndroidDriver drv) {
//        WebDriverWait waitDriver = new WebDriverWait(drv, 10);
//        drv.findElement(By.name(dialPadName)).click();
//    }
//
//    private void clickNumber1(AndroidDriver drv){
//        drv.findElement(By.id(key1Id)).click();
//    }
//
//    private void clickNumber0(AndroidDriver drv){
//        drv.findElement(By.id(key0Id)).click();
//    }
//
//    private void clickNumber2(AndroidDriver drv){
//        drv.findElement(By.id(key2Id)).click();
//    }
//
//    public void clickCallButton(AndroidDriver drv){
//        drv.findElement(By.id(callBtnId)).click();
//    }
//
//    public void clickEndCallButton(AndroidDriver drv){
//        drv.findElement(By.id(endCallBtnId)).click();
//    }
//}
