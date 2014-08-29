package com.borkhalenko.fd;
import java.util.Arrays;

public enum Signature{
    //(new byte[]{(byte)0x, ... }),
    DLL_WINDOWS_SYSTEM_LIBRARY_FILE (new byte[]{(byte)0x4D, (byte) 0x5A}),
    DOC_MICROSOFT_OFFICE_FILE (new byte[]{(byte)0xD0, (byte) 0xCF, (byte) 0x11, (byte)0xE0, (byte)0xA1, (byte)0xB1, (byte)0x1A, (byte)0xE1 }),
    DOCX_MICROSOFT_OFFICE_FILE (new byte[]{(byte)0x50, (byte)0x4B, (byte)0x03, (byte)0x04, (byte)0x14, (byte)0x00, (byte)0x06, (byte)0x00 }),
    GIF_IMAGE_FILE (new byte[]{(byte)0x47, (byte)0x49, (byte)0x46, (byte)0x38}),
    EXE_FILE (new byte[]{(byte)0x4D, (byte)0x5A }),
    FLAC_AUDIO_FILE (new byte[]{(byte)0x66, (byte)0x4C, (byte)0x61, (byte)0x43, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x22 }),
    FLV_FLASH_VIDEO_FILE (new byte[]{(byte)0x46, (byte)0x4C, (byte)0x56 }),
    GIF_FILE (new byte[]{(byte)0x47, (byte)0x49, (byte)0x46, (byte)0x38 }),
    ICO_IMAGE_FILE (new byte[]{(byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00 }),
    JPEG_PICTURE_FILE (new byte[]{(byte)0xff, (byte) 0xd8, (byte) 0xff }),
    MP3_MUSIC_FILE (new byte[]{(byte)0x49, (byte)0x44, (byte)0x33 }),
    MPG_MPEG_VIDEO_FILE (new byte[]{(byte)0x00, (byte)0x00, (byte)0x01,(byte)0xB3 }),
    MPG_DVD_VIDEO_FILE (new byte[]{(byte)0x00, (byte)0x00, (byte)0x01, (byte)0xBA }),
    PDF_DOCUMENT_FILE (new byte[]{(byte)0x25, (byte)0x50, (byte)0x44, (byte)0x46 }),
    PSD_PHOTOSHOP_FILE (new byte[]{(byte)0x38, (byte)0x42, (byte)0x50, (byte)0x53 }),
    RAR_WINRAR_ARCHIVE (new byte[]{(byte)0x52, (byte)0x61, (byte)0x72, (byte)0x21, (byte)0x1A, (byte)0x07, (byte)0x00 }),
    RTF_DOCUMENT_FILE (new byte[]{(byte)0x7B, (byte)0x5C, (byte)0x72, (byte)0x74, (byte)0x66, (byte)0x31 }),
    SWF_SHOCXWAVE_FLASH_PLAYER(new byte[]{(byte)0x46, (byte)0x57, (byte)0x53 }),
    SWF_SHOCXWAVE_FLASH_FILE(new byte[]{(byte)0x43, (byte)0x57, (byte)0x53 }),
    TIF_TIFF_IMAGE_FILE(new byte[]{(byte)0x49, (byte)0x20, (byte)0x49}),
    XLS_MICROSOFT_EXCEL_FILE (new byte[]{(byte)0xD0, (byte)0xCF, (byte)0x11, (byte)0xE0, (byte)0xA1, (byte)0xB1, (byte)0x1A, (byte)0xE1}),
    XLSX_MICROSOFT_EXCEL_FILE (new byte[]{(byte)0x50, (byte)0x4B, (byte)0x03, (byte)0x04, (byte)0x14, (byte)0x00, (byte)0x06, (byte)0x00}),
    ZIP_WINZIP_ARCHIVE_FILE(new byte[]{(byte)0x57, (byte)0x69, (byte)0x6E, (byte)0x5A, (byte)0x69, (byte)0x70}),
    ZIP_PK_ARCHIVE_1_FILE (new byte[]{(byte)0x50, (byte)0x4B, (byte)0x03, (byte)0x04}),
    ZIP_PK_ARCHIVE_2_FILE (new byte[]{(byte)0x50, (byte)0x4B, (byte)0x05, (byte)0x06});
    //Continue page 15 http://www.filesignatures.net/index.php?page=all&currentpage=15&order=EXT

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

    //TODO Need check, if pos<signature.length (maybe must throw an exception or something...)
    public byte getByte(int pos){
        return signature[pos];
    }

    public int getSize(){
        return signature.length;
    }

}