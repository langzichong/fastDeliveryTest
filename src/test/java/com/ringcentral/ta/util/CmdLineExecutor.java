package com.ringcentral.ta.util;

import com.ringcentral.ta.config.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class CmdLineExecutor {

    //todo: add adb shell am start -n com.ringcentral.android/.LoginScreen

    private static void runAdbShellCmd(String adbCmd) throws IOException, InterruptedException {
        String completeCmd =  "cmd /c adb.exe shell " + adbCmd;
        System.out.println("Kill app with: " + completeCmd);
        Process process = Runtime.getRuntime().exec(completeCmd);
        InputStream stdin = process.getInputStream();

        InputStreamReader isr = new InputStreamReader(stdin);
        LineNumberReader input = new LineNumberReader(isr);
        String line;
        while ((line = input.readLine()) != null)
            System.out.println(line);
        int exitVal = process.waitFor();
        System.out.println("Adb process quit with exit code: " + exitVal);
        input.close();
        isr.close();
    }

    public static void killCurrentAppByAdb() throws IOException, InterruptedException {
        runAdbShellCmd("am force-stop " + Brand.getPackageNameByBrand() + "/.LoginScreen");
    }

    public static void restartAppByAdb() throws IOException, InterruptedException {
//        runAdbShellCmd("am force-stop " + Brand.getPackageNameByBrand() + "/.LoginScreen");
    }

    public static void adbInputText(String text) throws IOException, InterruptedException {
        runAdbShellCmd("input text " + text);
    }
}
