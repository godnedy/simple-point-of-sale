package com.egodniak.devices;

/**
 * Created by Edyta on 17.06.2017.
 */

//Mock object of Printer
public class Printer implements Device, OutputDevice {

    public void connect() {
        System.out.println("Connecting Printer...");
    }

    public boolean isConnected() {
        return true;
    }

    public void print(Object output) {
        System.out.println("Prints:");
        System.out.println(output);
    }
}
