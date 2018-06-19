package com.egodniak.devices;

/**
 * Created by Edyta on 18.06.2017.
 */

//Mock object of LCD
public class LCD implements Device, OutputDevice {

    public void connect() {
        System.out.println("Connecting LCD...");
    }

    public boolean isConnected() {
        return true;
    }

    public void print(Object output) {
        System.out.println("Displays on LCD screen:");
        System.out.println(output);

    }
}
