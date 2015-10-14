package com.ringcentral.ta.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class LoggerHandler {

    public static void logStep(Logger loggerHandler, String className, int stepNum, String message) {
        String workspace = System.getProperty("user.dir");
        String directory = workspace + "/screenshot/" + className;
        new File(directory).mkdirs();
        String screenShotName = "screenshot_" + System.currentTimeMillis()+".png";
        takeScreenShot(screenShotName,directory);
        loggerHandler.info(String.format("[STEP %s]%s image url is %s", stepNum, message, "../../screenshot/" + className+"/"+screenShotName));
    }
    public static void logStep(Logger loggerHandler,String className,String message){
        logStep(loggerHandler,className,0,message);
    }

    public static void takeScreenShot(String fileName,String directory) {
        String commandLine = "adb shell /system/bin/screencap -p /sdcard/" + fileName;
        executeShellCommand(commandLine);
        compressScreenShot(fileName,directory);

    }
    private static void compressScreenShot(String path,String directory) {
        String commandLine = "adb pull /sdcard/" + path+" "+directory;
        String deleteCommand = "adb shell rm /sdcard/"+ path;
        executeShellCommand(commandLine);
        executeShellCommand(deleteCommand);
    }
    private static void executeShellCommand(String commandLine) {
        try {
            String[] cmd = new String[]{"cmd", "/c", commandLine};
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println("[INFO] shell command result is " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void takeScreenShot(String fileName) {
//        String commandLine = "/usr/local/Cellar/libimobiledevice/1.2.0/bin/idevicescreenshot " + fileName;
//        executeShellCommand(commandLine);
//        compressScreenShot(fileName);
//
//    }
//
//    private static void compressScreenShot(String path) {
//        String commandLine = "/opt/ImageMagick/bin/mogrify -format png " + path;
//        executeShellCommand(commandLine);
//        File file = new File(path);
//        if (file.isFile() && file.exists()) {
//            file.delete();
//        }
//    }
//
//
//    private static void executeShellCommand(String commandLine) {
//        try {
//            String[] cmd = new String[]{"/bin/sh", "-c", commandLine};
//            Process ps = Runtime.getRuntime().exec(cmd);
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
//            StringBuffer sb = new StringBuffer();
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//            String result = sb.toString();
//            System.out.println("[INFO] shell command result is " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}

