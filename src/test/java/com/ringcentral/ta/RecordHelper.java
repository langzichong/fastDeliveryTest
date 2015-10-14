//package com.ringcentral.ta;
//
//import java.io.*;
//
////todo: refactor to make it readable
//public class RecordHelper {
//    public static Thread videoRecordingThread;
//    public static Thread mediaPlayingThread;
//    public static Object wait_obj = new Object();
//    public static void startRec(String movieName) throws IOException, InterruptedException {
//        videoRecordingThread = new Thread() {
//            public void run() {
//                try {
//                    runShell(movieName);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        videoRecordingThread.start();
//    }
//
//    public static void stopRec() throws InterruptedException {
//        synchronized (wait_obj) {
//            wait_obj.notify();
//        }
//        videoRecordingThread.join();
//    }
//
//    public static void startPlayingMedia() throws IOException, InterruptedException {
//        mediaPlayingThread = new Thread() {
//            public void run() {
//                try {
//                    runShelForPlayingMedial();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        mediaPlayingThread.start();
//    }
//
//    public static void stopPlayingMedia() throws InterruptedException {
//        mediaPlayingThread.join();
//    }
//
//    private static void runShelForPlayingMedial() throws IOException, InterruptedException {
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File toolDir = new File(classpathRoot, "tools");
//        File dlcFile = new File(toolDir, "dlc.exe");
//        File mediaFile = new File(toolDir, "Sunrise.wav");
//
//        ProcessBuilder builder = new ProcessBuilder("cmd", "/c", dlcFile.getAbsolutePath(), "-p", mediaFile.getAbsolutePath());
//        builder.redirectErrorStream(true);
//        Process process = builder.start();
//        InputStreamReader ir = new InputStreamReader(process.getInputStream());
//        LineNumberReader reader = new LineNumberReader(ir);
//        String line = "";
//        while ((line = reader.readLine ()) != null) {
//            System.out.println ("Stdout: " + line);
//        }
//        process.waitFor();
//        reader.close();
//        ir.close();
//    }
//
//    private static void runShell(String movieName) throws IOException, InterruptedException {
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File toolDir = new File(classpathRoot, "tools");
//        File ffmpegFile = new File(toolDir, "ffmpeg.exe");
//
//        ProcessBuilder builder = new ProcessBuilder("cmd", "/c", ffmpegFile.getAbsolutePath(), "-f", "dshow", "-i", "video=Venus USB2.0 Camera:audio=Microphone (High Definition Aud", "-vcodec", "libx264", movieName + ".mkv");
//        builder.redirectErrorStream(true);
//        Process process = builder.start();
//        InputStreamReader ir = new InputStreamReader(process.getInputStream());
//        LineNumberReader reader = new LineNumberReader(ir);
//
//        Thread thread = new Thread(){
//            public void run(){
//                System.out.println("******************* Thread Running *******************");
//                try {
//                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
//                    System.out.println("******** before wait ********");
//                    synchronized (wait_obj) {
//                        wait_obj.wait();
//                        System.out.println("******** after wait ********");
//                        outputStreamWriter.write("q");
//                        outputStreamWriter.flush();
//                        outputStreamWriter.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();
//        String line = "";
//        while ((line = reader.readLine ()) != null) {
//            System.out.println ("Stdout: " + line);
//        }
//
//        thread.join();
//        process.waitFor();
//        reader.close();
//        ir.close();
//    }
//}
