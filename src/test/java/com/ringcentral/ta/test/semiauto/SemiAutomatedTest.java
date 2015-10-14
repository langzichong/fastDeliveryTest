//package com.ringcentral.ta.test.semiauto;
//
//import com.ringcentral.ta.RecordHelper;
//import com.ringcentral.ta.SubTitleHelper;
//import com.ringcentral.ta.base.SingleDeviceTest;
//import com.ringcentral.ta.util.CmdLineExecutor;
//import com.ringcentral.ta.util.CommonActions;
//import com.ringcentral.ta.util.Mobile;
//import com.ringcentral.ta.util.MobileDevice;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.net.URL;
//
//public class SemiAutomatedTest extends SingleDeviceTest{
//    private SubTitleHelper subtitleMaker;
//    private static final String chars1000 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcde";
//
//    @BeforeMethod
//    public void beforeMethod(Method method) throws IOException, InterruptedException {
//        DesiredCapabilities capabilities = setDesiredCapabilities();
//        // start rec and making subtitle
//        RecordHelper.startRec(method.getName());
//        Thread.sleep(1500);
//        subtitleMaker = new SubTitleHelper(method.getName());
//        String PORT = "4723";
//        try {
//            mobile = new Mobile(new MobileDevice(new AndroidDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", PORT)), capabilities)));
//            mobile.getTitleBar().getTitleBarPhotoWithWait(30).click();
//            mobile.getMyProfilePage().getLogout().click();
//        } catch (Exception e) {
//            e.printStackTrace();
//            safeQuit();
//        }
//    }
//
//    @Test
//    public void test_ANUX_2911() throws InterruptedException, IOException {
//        // Entry 1: Normal pager
//        // Preparation: making threads
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Pager Preparation");
//        CommonActions.doLogin(mobile);
//        mobile.getNavBar().getMessagesTabWithWait(30);
//        mobile.getTitleBar().getTopRightBtn().click();
//        mobile.getCommonFinder().findElemByText("New Text").click();
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting("102");
//        mobile.getNewMessagePage().getMessageEditText().sendKeys(chars1000);
//        mobile.getNewMessagePage().getSendBtn().click();
//        mobile.getMessageThreadPage().getMessageEditText().sendKeys("fgh");
//        mobile.getNewMessagePage().getSendBtn().click();
//        Thread.sleep(2000);
//        mobile.getTitleBar().getTopRightBtn().click();
//        mobile.getCommonFinder().findElemByText("Edit").click();
//        // Step 1: Select several items which the total length is larger than 1000 characters
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Step 1: Select several items which the total length is larger than 1000 characters");
//        mobile.getCommonFinder().findElemByText("fgh").click();
//        mobile.getMobileDevice().getAppiumDriver().scrollTo("abcde").click();
//        // Step 2: Tap "Forward" button. Toast notification "Sorry, you cannot forward more than 1000 characters in a text message." appears.
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 1: Step 2: Tap \"Forward\" button. Toast notification \"Sorry, you cannot forward more than 1000 characters in a text message.\" appears.");
//        mobile.getEditMessagePage().getForwardBtn().click();
//        // Step 3: Wait for about 3 seconds. The toast notification disappears
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 1: Step 3:  Wait for about 3 seconds. The toast notification disappears");
//        Thread.sleep(3000);
//        // Step 4: Tap "Forward" button several times
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 1: Step 4:  Tap \"Forward\" button several times. The toast notification will disappear in 3s");
//        for (int i = 0; i < 3; i++) {
//            mobile.getEditMessagePage().getForwardBtn().click();
//            Thread.sleep(3000);
//        }
//
//        mobile.getMobileDevice().getAppiumDriver().navigate().back();
//        mobile.getMobileDevice().getAppiumDriver().navigate().back();
//        // Entry 2: Group text
//        // Preparation: making threads
//        subtitleMaker.addStepMsgToSubtitle("Entry 2: Group text Preparation");
//        mobile.getTitleBar().getTopRightBtn().click();
//        mobile.getCommonFinder().findElemByText("New Text").click();
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting("102");
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting("103");
//        mobile.getNewMessagePage().getMessageEditText().sendKeys(chars1000);
//        mobile.getNewMessagePage().getSendBtn().click();
//        mobile.getMessageThreadPage().getMessageEditText().sendKeys("fgh");
//        mobile.getNewMessagePage().getSendBtn().click();
//        Thread.sleep(2000);
//        mobile.getTitleBar().getTopRightBtn().click();
//        // Step 1: Select several items which the total length is larger than 1000 characters
//        subtitleMaker.addStepMsgToSubtitle("Entry 2: Step 1: Select several items which the total length is larger than 1000 characters");
//        mobile.getCommonFinder().findElemByText("fgh").click();
//        mobile.getMobileDevice().getAppiumDriver().scrollTo("abcde").click();
//        // Step 2: Tap "Forward" button. Toast notification "Sorry, you cannot forward more than 1000 characters in a text message." appears.
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 2: Step 2: Tap \"Forward\" button. Toast notification \"Sorry, you cannot forward more than 1000 characters in a text message.\" appears.");
//        mobile.getEditMessagePage().getForwardBtn().click();
//        // Step 3: Wait for about 3 seconds. The toast notification disappears
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 2: Step 3:  Wait for about 3 seconds. The toast notification disappears");
//        Thread.sleep(3000);
//        // Step 4: Tap "Forward" button several times
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 2: Step 4:  Tap \"Forward\" button several times. The toast notification will disappear in 3s");
//        for (int i = 0; i < 3; i++) {
//            mobile.getEditMessagePage().getForwardBtn().click();
//            Thread.sleep(3000);
//        }
//    }
//
//    @Test
//    public void test_ANUX_2908() throws InterruptedException, IOException {
//        String MSG1 = "hij";
//        String MSG2 = "klm";
//        String MSG3 = "nop";
//        String recp1 = "108";
//        String recp2 = "109";
//        // Entry 1: Normal pager
//        // Preparation: making threads
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Pager Preparation");
//        CommonActions.doLogin(mobile);
//        mobile.getNavBar().getMessagesTabWithWait(30);
//        mobile.getTitleBar().getTopRightBtn().click();
//        mobile.getCommonFinder().findElemByText("New Text").click();
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting(recp1);
//        mobile.getNewMessagePage().getMessageEditText().sendKeys(MSG1);
//        mobile.getNewMessagePage().getSendBtn().click();
//        mobile.getMessageThreadPage().getMessageEditText().sendKeys(MSG2);
//        mobile.getMessageThreadPage().getSendBtn().click();
//        mobile.getMessageThreadPage().getMessageEditText().sendKeys(MSG3);
//        mobile.getMessageThreadPage().getSendBtn().click();
//        Thread.sleep(2000);
//        mobile.getTitleBar().getTopRightBtn().click();
//        mobile.getCommonFinder().findElemByText("Edit").click();
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Step 1: Select several items which the total length is less than 1000 characters");
//        mobile.getCommonFinder().findElemByText(MSG1).click();
//        mobile.getCommonFinder().findElemByText(MSG2).click();
//        mobile.getCommonFinder().findElemByText(MSG3).click();
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 1: Step 2: Tap \"Forward\" button. Virtual Keyboard is opened for 'To' field");
//        mobile.getEditMessagePage().getForwardBtn().click();
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Step 3: Define valid recipient into \"To\" field");
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting(recp1);
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Step 4: Define valid recipient into \"To\" field");
//        mobile.getNewMessagePage().getSendBtn().click();
//        subtitleMaker.addStepMsgToSubtitle("Entry 1: Step 4: Expectation:\n1.User gets to non-edit mode of text thread screen\n" +
//                "2.Forwarded text messages are added to the thread\n" +
//                "3.Sending status bar is shown until success is confirmed\n");
//        Thread.sleep(5000);
//        mobile.back();
//
//        // Entry 2: Group text
//        // Preparation: making threads
//        subtitleMaker.addStepMsgToSubtitle("Entry 2: Group text Preparation");
//        mobile.getTitleBar().getTopRightBtn().click();
//        mobile.getCommonFinder().findElemByText("New Text").click();
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting(recp1);
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting(recp2);
//        mobile.getNewMessagePage().getMessageEditText().sendKeys(MSG1);
//        mobile.getNewMessagePage().getSendBtn().click();
//        mobile.getMessageThreadPage().getMessageEditText().sendKeys(MSG2);
//        mobile.getMessageThreadPage().getSendBtn().click();
//        mobile.getMessageThreadPage().getMessageEditText().sendKeys(MSG3);
//        mobile.getMessageThreadPage().getSendBtn().click();
//        Thread.sleep(2000);
//        mobile.getTitleBar().getTopRightBtn().click();
//        subtitleMaker.addStepMsgToSubtitle("Entry 2: Step 1: Select several items which the total length is less than 1000 characters");
//        mobile.getCommonFinder().findElemByText(MSG1).click();
//        mobile.getCommonFinder().findElemByText(MSG2).click();
//        mobile.getCommonFinder().findElemByText(MSG3).click();
//        subtitleMaker.addStepMsgToSubtitle("(MANUAL)Entry 2: Step 2: Tap \"Forward\" button. Virtual Keyboard is opened for 'To' field");
//        mobile.getEditMessagePage().getForwardBtn().click();
//        subtitleMaker.addStepMsgToSubtitle("Entry 2: Step 3: Define valid recipient into \"To\" field");
//        mobile.getNewMessagePage().getEditContactArea().inputContactWithoutDeleting(recp1);
//        subtitleMaker.addStepMsgToSubtitle("Entry 2: Step 4: Expectation: User gets to non-edit mode of text thread screen\n" +
//                "Forwarded text messages are added to the thread\n" +
//                "Sending status bar is shown until success is confirmed\n");
//        mobile.getNewMessagePage().getSendBtn().click();
//        Thread.sleep(5000);
//    }
//
//    @AfterMethod
//    public void afterMethod() throws IOException, InterruptedException {
//        safeQuit();
//        subtitleMaker.finishSubtitle();
//        RecordHelper.stopRec();
//    }
//}
