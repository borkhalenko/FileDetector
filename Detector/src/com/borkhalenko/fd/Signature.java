package com.borkhalenko.fd;
import java.util.Arrays;

public enum Signature{
    JPEG_SIGNATURE(new byte[]{(byte)0xff, (byte) 0xd8, (byte) 0xff});
    private byte[] signature;
    Signature(byte[] signature){
        this.signature=signature;
    }
    public boolean compare(byte[] bytesSignature){
        return Arrays.equals(bytesSignature, signature);
    }
    public byte[] getBytes(){
        return Arrays.copyOf(signature,signature.length);
    }
}