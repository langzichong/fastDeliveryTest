package com.ringcentral.ta.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import static com.ringcentral.ta.util.LoggerHandler.logStep;

/**
 * Created by andy.lai on 2015/9/29.
 */
public class TestListener extends TestListenerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);
    public static final String CLASS_NAME = "TestListener";
    @Override
    public void onTestStart( ITestResult tr )
    {
        super.onTestStart(tr);
        logStep(LOG, CLASS_NAME, 1, "TestListener start");
        System.out.println("SequoiaLoginTest listener start");
        String callMethodName = tr.getName();
        String callClassName = tr.getTestClass().getName();
        String callDescription = tr.getMethod().getDescription();
        Reporter.log(callMethodName+"__"+callClassName+"__"+callDescription);
        Reporter.log("SequoiaLoginTest listener start");
    }
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        System.out.println("SequoiaLoginTest listener success");
        String callMethodName = tr.getName();
        String callClassName = tr.getTestClass().getName();
        String callDescription = tr.getMethod().getDescription();
        Reporter.log("success");
        Reporter.log(callMethodName+"__"+callClassName+"__"+callDescription);
        logStep(LOG, CLASS_NAME, "Test Passed");
        System.out.println(callClassName+":"+callMethodName+"  "+callDescription+" Passed.");
    }
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        String callMethodName = tr.getName();
        String callClassName = tr.getTestClass().getName();
        String callDescription = tr.getMethod().getDescription();
        Reporter.log("failed");
        Reporter.log(callMethodName + "__" + callClassName + "__" + callDescription);
        logStep(LOG,CLASS_NAME,"Test Failed");
        System.out.println(callClassName+":"+callMethodName+" failed.");
    }
    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        String callMethodName = tr.getName();
        String callClassName = tr.getTestClass().getName();
        String callDescription = tr.getMethod().getDescription();
        Reporter.log("Skipped");
        Reporter.log(callMethodName + "__" + callClassName + "__" + callDescription);
        System.out.println(callClassName+":"+callMethodName+"  "+callDescription+" Skipped.");

    }
    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
        String name = context.getName();
        String replaced = name.replaceAll(".","*");
        System.out.println("********************" + replaced + "**************************");
        System.out.println("**********    Test '" + context.getName() + "' is started    **********");
        System.out.println("********************" + replaced + "**************************");
        printTestCount(context);
    }
    @Override
    public void onFinish(ITestContext context) {
        super.onFinish(context);
        String name = context.getName();
        String replaced = name.replaceAll(".","*");
        System.out.println("********************" + replaced + "***************************");
        System.out.println("**********    Test '" + context.getName() + "' is finished    **********");
        System.out.println("********************" + replaced + "***************************");
    }

    private void printTestCount(ITestContext context) {
        String name = context.getName();
        int methodCount = 0;
        int testCount = 0;
        for(ITestNGMethod itm : context.getAllTestMethods()) {
            methodCount ++;

        }
        System.out.println("Test: '" + name + "'. Total enabled methods for test: " + methodCount);
    }

}
