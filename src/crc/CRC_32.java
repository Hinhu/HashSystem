/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bartek
 */
public class CRC_32 {

    private byte[] value;
    private int len;

    public CRC_32(byte[] buf) {
        this.value = buf;
        this.len = buf.length;
    }

    public CRC_32() {
        this.value = null;
        this.len = 0;
    }

    public long getFileCRC(File file) throws IOException {
        reset();
        char[] cbuffer = new char[2048];
        int n=0;
        if(file.isFile()){
            FileReader fReader = new FileReader(file);
            n = fReader.read(cbuffer, 0, cbuffer.length);
        }
        String buffer = "";
        for(int i=0; i<n; i++){
            buffer += cbuffer[i];
        }
        update(buffer.getBytes());
        return CRChashCode();
    }

    public void update(byte[] buf) throws IOException {
        if (this.value == null) {
            if (buf == null) {
                System.err.print("Empty buffer");
                System.exit(-1);
            }
            this.value = buf;
            this.len = buf.length;
        } else if (buf != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(this.value);
            outputStream.write(buf);
            this.value = outputStream.toByteArray();
            this.len += buf.length;
        }
    }
    
    private void update(byte[] buf, int len) throws IOException {
        if (this.value == null) {
            if (buf == null) {
                System.err.print("Empty buffer");
                System.exit(-1);
            }
            this.value = buf;
            this.len = len;
        } else if (buf != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(this.value);
            outputStream.write(buf);
            this.value = outputStream.toByteArray();
            this.len += len;
        }
    }

    public long CRChashCode() {
        int crc = 0xFFFFFFFF;
        int poly = 0xEDB88320;

        for (byte b : value) {
            int temp = (crc ^ b) & 0xff;

            for (int i = 0; i < 8; i++) {
                if ((temp & 1) == 1) {
                    temp = (temp >>> 1) ^ poly;
                } else {
                    temp = (temp >>> 1);
                }
            }
            crc = (crc >>> 8) ^ temp;
        } 
        
        crc = crc ^ 0xffffffff;
        
        return (long)crc;
    }

    public void reset() {
        this.value = null;
        this.len = 0;
    }

    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder("");
        for (byte b : this.value) {
            bob.append((char) b);
        }
        return bob.toString();
    }
}
