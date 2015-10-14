package com.ringcentral.ta.base;

import com.ringcentral.ta.util.Mobile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TwoDeviceTest extends MobileTest {

    @BeforeMethod
    public void init() {
        System.out.println("SingleDeviceTest init");
        //
    }

    @AfterMethod
    public void uninit() {
        System.out.println("SingleDeviceTest uninit");
    }

    public Mobile getMobile() {
        return null;
    }
}
