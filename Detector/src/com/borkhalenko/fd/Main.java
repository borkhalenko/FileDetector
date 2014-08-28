package com.borkhalenko.fd;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String sep= File.separator;
        String fileName="emptyFile";
        String path="Detector"+sep+"DataFiles"+sep+fileName;
        DataInputStream iStream=null;
        try {
            iStream = new DataInputStream(new FileInputStream(path));
        }
        catch (IOException exception){
            System.out.println("Bad file path. Cannot read the file!");
            return;
        }
        String fileTypeName=null;
        try {
            fileTypeName = SignatureDetector.detect(iStream);
        }
        catch (IOException exception){
            System.out.println("Cannot read from file stream.");
            exception.printStackTrace();
        }
        if (fileTypeName==null){
            System.out.println("I don't known, what is this. Maybe this is a simple text file (like .txt)?");
        }
        else
            System.out.println("This is a "+fileTypeName+". Am I right?");
    }
}
