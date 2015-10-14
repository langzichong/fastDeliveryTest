package com.ringcentral.ta;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Temp {
    public  static void main(String[] args){
        System.out.print(new DateTime(new DateTime().getMillis()).withZone(DateTimeZone.UTC).toString("HH:mm:ss,SSS"));


    }
}
