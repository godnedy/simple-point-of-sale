package com.egodniak.devices; /**
 * Created by Edyta on 16.06.2017.
 */

import java.util.Scanner;

//Mock object of QRScanner
public class QRScanner implements Device {

    private String scannedCode;

    public QRScanner(){
        this.scannedCode = "";
    }

    public void connect(){
        System.out.println("Connecting QRScanner...");
    }

    public boolean isConnected(){
        return true;
    }

    private void aqquireCode(){
        System.out.println("This is only a mock scanner");
        System.out.println("Please provide a code");
        Scanner input = new Scanner(System.in);
        String code = input.nextLine();
        scannedCode = code;
    }

    public String scann(){
        aqquireCode();
        return scannedCode;
    }
}
