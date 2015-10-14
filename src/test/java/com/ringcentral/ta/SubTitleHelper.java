package com.ringcentral.ta;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.FileWriter;
import java.io.IOException;

public class SubTitleHelper {
    private int stepIndex = 1;
    private String filePath = "";
    private Long movieStartTime = 0L;
    private String durationText = "Preparation...";
    private String durationStartTimeStr = "00:00:00,000";
    private FileWriter fileWriter;

    public SubTitleHelper(String filePath) throws IOException {
        this.filePath = filePath;
        this.movieStartTime = new DateTime().getMillis();
        this.fileWriter = new FileWriter(filePath + ".srt");
    }
    public static SubTitleHelper initSubtitle(String subtitle) throws IOException {
        return new SubTitleHelper(subtitle);
    }

    public void finishSubtitle() throws IOException {
        // finish the last section
        fileWriter.write(stepIndex + "\n");
        fileWriter.write(durationStartTimeStr);
        fileWriter.write(" --> ");
        fileWriter.write("00:59:59,999\n");
        fileWriter.write(durationText + "\n\n");
        fileWriter.close();
    }

    public void addStepMsgToSubtitle(String stepMsg) throws IOException {
        // write previous step subtitle
        // write index
        fileWriter.write(stepIndex + "\n");
        // write subtitle section start and end time
        fileWriter.write(durationStartTimeStr);
        fileWriter.write(" --> ");
        long durationEndTimeStr = new DateTime().getMillis() - movieStartTime;
        durationStartTimeStr = new DateTime(durationEndTimeStr).withZone(DateTimeZone.UTC).toString("HH:mm:ss,SSS");
        fileWriter.write(durationStartTimeStr + "\n");
        fileWriter.write(durationText + "\n\n");
        this.durationText = stepMsg;
        stepIndex++;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SubTitleHelper subtitleMaker = SubTitleHelper.initSubtitle("subtitle.srt");
        Thread.sleep(3000);
        subtitleMaker.addStepMsgToSubtitle("STEP1");
        Thread.sleep(4000);
        subtitleMaker.addStepMsgToSubtitle("STEP2");
        Thread.sleep(4000);
        subtitleMaker.addStepMsgToSubtitle("STEP3");
        Thread.sleep(4000);
        subtitleMaker.finishSubtitle();
    }
}