package com.borkhalenko.fd;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String sep= File.separator;
        String fileName="SomePicture.doc";
        String path="Detector"+sep+"DataFiles"+sep+fileName;
        DataInputStream iStream=null;
        try {
            iStream = new DataInputStream(new FileInputStream(path));
        }
        catch (IOException exception){
            System.out.println("Bad file path. Cannot read the file!");
            return;
        }
        String fileTypeName=SignatureDetector.detect(iStream);
        if (fileTypeName==null){
            System.out.println("I don't known, what is this");
        }
        else
            System.out.println("This is "+fileName);
    }
}
