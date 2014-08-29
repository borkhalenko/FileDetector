package com.borkhalenko.fd;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class SignatureDetector    {
    private static HashMap<Signature, Boolean> signatureHashMap;

    private static int hasAvailableElements(){
        int availableSignatureCount=0;
        if (signatureHashMap==null)
            return availableSignatureCount;

        Set<Signature> allSignatures=signatureHashMap.keySet();
        for (Signature s:allSignatures){
            if (signatureHashMap.get(s))
                availableSignatureCount++;
        }
        return availableSignatureCount;
    }

    private static Signature availableElement(){
        Set<Signature> allSignatures=signatureHashMap.keySet();
        for (Signature s:allSignatures){
            if (signatureHashMap.get(s))
                return s;
        }
        return null;
    }

    public static String detect(DataInputStream stream) throws IOException{
        Signature[] signatureList=Signature.values();
        signatureHashMap=new HashMap<Signature, Boolean>(signatureList.length);
        for (int i=0;i<signatureList.length;i++) {
            signatureHashMap.put(signatureList[i], true);
        }
        for (int currentByte=0; stream.available()>0; currentByte++){
            byte nextByte=stream.readByte();
            for (Signature s:signatureList){
                if (signatureHashMap.get(s)  && s.getSize()>currentByte && s.getByte(currentByte)!=nextByte) {
                    signatureHashMap.replace(s, true, false);
                }
            }
            if (hasAvailableElements()==1)
                return availableElement().name();
        }
        return null;
    }


}
