/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.zip.CRC32;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartek
 */
public class CRC_32Test {
   
    String filename = "CRC_32Text.java";
    public CRC_32Test() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMethod() throws IOException {
        String testString = "Ala ma kota";
        
        //Tworzenie przykładowego hash CRC
        CRC32 tempHash = new CRC32();
        tempHash.update(testString.getBytes());
        long templateHashValue = tempHash.getValue();
        
        //Tworzenie testowego hash
        CRC_32 testHash = new CRC_32(testString.getBytes());
        long testHashValue = testHash.CRChashCode();
        
        //Porównywanie hash
        assertEquals(templateHashValue,testHashValue);
    }
    
    @Test
    public void testUpdatedHash() throws IOException {
        String testString = "Ala ma kota";
        String extensionText = ",a Marysia ma rysia.";
        
        //Tworzenie przykładowego hash CRC
        CRC32 tempHash = new CRC32();
        tempHash.update(testString.getBytes());
        tempHash.update(extensionText.getBytes());
        long templateHashValue = tempHash.getValue();
        
        //Tworzenie testowego hash
        CRC_32 testHash = new CRC_32(testString.getBytes());
        testHash.update(extensionText.getBytes());
        long testHashValue = testHash.CRChashCode();
        
        //Porównywanie hash
        assertEquals(templateHashValue,testHashValue);
    }
    
    @Test
    public void testFileHash() throws IOException {
        char[] cbuffer = new char[2048];
        int n = 0;
        File reader = new File(filename);
        if(reader.isFile()){
            FileReader fReader = new FileReader(reader);
            n = fReader.read(cbuffer, 0, cbuffer.length);
        }
        String buffer = "";
        for(int i=0; i<n; i++){
            buffer += cbuffer[i];
        }
        System.out.println(buffer);
        
        //Tworzenie przykładowego hash CRC
        CRC32 tempHash = new CRC32();
        tempHash.update(buffer.getBytes());
        long templateHashValue = tempHash.getValue();
        
        
        //Tworzenie testowego hash
        CRC_32 testHash = new CRC_32();
        long testHashValue = testHash.getFileCRC(reader);
        
        //Porównywanie hash
        assertEquals(templateHashValue,testHashValue);
    }
    
}
