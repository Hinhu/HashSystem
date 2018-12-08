/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author zychp
 */
public class Sha256 {
    
    private int[] h = {
            0x6a09e667,
            0xbb67ae85,
            0x3c6ef372,
            0xa54ff53a,
            0x510e527f,
            0x9b05688c,
            0x1f83d9ab,
            0x5be0cd19
    };

    private int[] k = {
            0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 
            0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
            0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 
            0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
            0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 
            0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
            0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 
            0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
            0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 
            0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
            0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 
            0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
            0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 
            0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
            0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 
            0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
    };
    
    private final byte[] block = new byte[64];
    private Chunk512 chunk = new Chunk512();
       
    private final int[] words = new int[64];
    private final int[] words32 = new int[64];
    //private Word32[] words32 = new Word32[64];
        
    
    public String getHash(String input) throws NoSuchAlgorithmException {
        byte[] inputBytes = stringToBytes(input);  
        
        byte[] padded = doPadding(inputBytes);
      
        int[] hs = Arrays.copyOf(h, 8);
        
        for(int i=0;i<64;i++) {
            words32[i] = 0;
        }    
        HashRegister hs2x = new HashRegister(Arrays.copyOf(h, 8));
        
            

        for (int i = 0; i < padded.length / 64; ++i) {
            
            int[] registers = Arrays.copyOf(hs, 8);          
            HashRegister registers2x = new HashRegister(hs2x.getRegister());
            
            
            System.arraycopy(padded, 64 * i, block, 0, 64);   
            System.arraycopy(padded, 64 * i, chunk.getChunk(), 0, 64);   
            //chunk.setChunk(block);
            
            System.out.println(Arrays.toString(block));
            System.out.println(Arrays.toString(chunk.getChunk()));
            
            setupWords();
            setupWords2x();
            
            for(int j=0;i<64;i++) {
                System.out.println(words[j]);
                System.out.println(words32[j]);
            }    
            
            System.out.println("TEST");

            for (int j = 0; j < 64; ++j) {
                //iterate(registers, words, j);
                calculate(registers, words, registers2x, words32, j);
                
            }
            
            System.out.println(Arrays.toString(registers));
            for(int s=0;s<8;s++) {
                System.out.println(registers2x.getValue(s));
            }
            

            for (int j = 0; j < 8; ++j) {
                hs[j] += registers[j];
                hs2x.setValue(j,hs2x.getValue(j) + registers2x.getValue(j));
            }
        }

        byte[] hash = new byte[32];
        byte[] hash2 = new byte[32];

        for (int i = 0; i < 8; i++) {
            System.arraycopy(intToBytes(hs[i]), 0, hash, 4 * i, 4);
            System.arraycopy(intToBytes(hs2x.getValue(i)), 0, hash2, 4 * i, 4);
        }
        
        System.out.println(DatatypeConverter.printHexBinary(hash2));
        
        return DatatypeConverter.printHexBinary(hash);
    } 
    
    byte[] stringToBytes(String s) throws NoSuchAlgorithmException{
        byte[] bytes = "ashfbvyuagfawigfbafsauifgawbfbasufigebuigbsdihadf012345".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        return bytes;
    }
    
    byte[] intToBytes(String s){
        byte[] bytes = {1,2,3};
        return bytes;
    }
    
    byte[] doPadding(byte[] bytes){
        int length = bytes.length;
        int tail = length % 64;
        int padding;

        if ((64 - tail >= 9)) {
            padding = 64 - tail;
        } else {
            padding = 128 - tail;
        }

        byte[] pad = new byte[padding];
        pad[0] = (byte) 0x80;
        long bits = length * 8;
        for (int i = 0; i < 8; i++) {
            pad[pad.length - 1 - i] = (byte) ((bits >>> (8 * i)) & 0xFF);
        }

        byte[] output = new byte[length + padding];
        
        System.arraycopy(bytes, 0, output, 0, length);
        System.arraycopy(pad, 0, output, length, pad.length);

        return output;
    }
    
    Chunk512[] breakToChunks(byte[] bytes){
        Chunk512[] chunks = new Chunk512[1000];
        return chunks;
    }    
    
    Word32[] convertToWords32(Chunk512[] chunks){
        Word32[] words = new Word32[1000];
        return words;
    }
    
    Word64[] expandToWords64(Word32[] words){
        Word64[] word64 = new Word64[1000];
        return word64;
    }
    
    public void calculate(int[] registers, int[] wordsx, HashRegister register, int[] words,int j) {
        int s0x = Integer.rotateRight(registers[0], 2) ^
               Integer.rotateRight(registers[0], 13) ^
                Integer.rotateRight(registers[0], 22);
        
        int s0 = Integer.rotateRight(register.getValue(0), 2) ^
               Integer.rotateRight(register.getValue(0), 13) ^
                Integer.rotateRight(register.getValue(0), 22);
        

        int majx = (registers[0] & registers[1]) ^ (registers[0] & registers[2]) ^ (registers[1] & registers[2]);
        
        int maj = (register.getValue(0) & register.getValue(1)) ^ (register.getValue(0) & register.getValue(2))
                ^ (register.getValue(1) & register.getValue(2));

        int temp2 = s0 + maj;
        int temp2x = s0x + majx;

  
        
         int s1x = Integer.rotateRight(registers[4], 6) ^
                Integer.rotateRight(registers[4], 11) ^
               Integer.rotateRight(registers[4], 25);
         
          int s1 = Integer.rotateRight(register.getValue(4), 6) ^
                Integer.rotateRight(register.getValue(4), 11) ^
               Integer.rotateRight(register.getValue(4), 25);
          
         
     

        int chx = (registers[4] & registers[5]) ^ (~registers[4] & registers[6]);
        int ch = (register.getValue(4) & register.getValue(5)) ^ (~register.getValue(4) & register.getValue(6));
              
        
        int temp1x = registers[7] + s1x + chx + k[j] + wordsx[j];
        int temp1 = register.getValue(7) + s1 + ch + k[j] + words32[j];
        
        registers[7] = registers[6];
        registers[6] = registers[5];
        registers[5] = registers[4];
        registers[4] = registers[3] + temp1x;
        registers[3] = registers[2];
        registers[2] = registers[1];
        registers[1] = registers[0];
        registers[0] = temp1x + temp2x;
        
        
        register.rollWIthValues(temp1,temp2);
    }
    
    
     private void setupWords2x() {
        for (int j = 0; j < 16; j++) {
            words32[j] = 0;
            for (int m = 0; m < 4; m++) {
                //words[j] |= ((block[j * 4 + m] & 0x000000FF) << (24 - m * 8));
                words32[j] |= (  words32[j] | ((block[j * 4 + m] & 0x000000FF) << (24 - m * 8))  ); // TO CHANGE
            }
        }

        for (int j = 16; j < 64; ++j) {           
           int s0 = Integer.rotateRight(words32[j - 15], 7) ^
                    Integer.rotateRight(words32[j - 15], 18) ^
                    (words[j - 15] >>> 3);

            int s1 = Integer.rotateRight(words32[j - 2], 17) ^
                    Integer.rotateRight(words32[j - 2], 19) ^
                    (words32[j - 2] >>> 10);

            words32[j] = words32[j - 16] + s0 + words32[j - 7] + s1;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private void setupWords() {
        for (int j = 0; j < 16; j++) {
            words[j] = 0;
            for (int m = 0; m < 4; m++) {
                words[j] |= ((block[j * 4 + m] & 0x000000FF) << (24 - m * 8));
            }
        }

        for (int j = 16; j < 64; ++j) {
            int s0 = Integer.rotateRight(words[j - 15], 7) ^
                    Integer.rotateRight(words[j - 15], 18) ^
                    (words[j - 15] >>> 3);

            int s1 = Integer.rotateRight(words[j - 2], 17) ^
                    Integer.rotateRight(words[j - 2], 19) ^
                    (words[j - 2] >>> 10);

            words[j] = words[j - 16] + s0 + words[j - 7] + s1;
        }
    }

    /**
     * The iteration is called 64 times for every block to be encrypted.
     * It updates the registers which later are used to generate the
     * message hash.
     *
     * @param registers The registers used represented by an int array of size 8.
     * @param words     The words used represented by an int array of size 64.
     * @param j         The current index.
     */
    private void iterate(int[] registers, int[] words, int j) {
        int S0 = Integer.rotateRight(registers[0], 2) ^
                Integer.rotateRight(registers[0], 13) ^
                Integer.rotateRight(registers[0], 22);

        int maj = (registers[0] & registers[1]) ^ (registers[0] & registers[2]) ^ (registers[1] & registers[2]);

        int temp2 = S0 + maj;

        int S1 = Integer.rotateRight(registers[4], 6) ^
                Integer.rotateRight(registers[4], 11) ^
                Integer.rotateRight(registers[4], 25);

        int ch = (registers[4] & registers[5]) ^ (~registers[4] & registers[6]);

        int temp1 = registers[7] + S1 + ch + k[j] + words[j];

        registers[7] = registers[6];
        registers[6] = registers[5];
        registers[5] = registers[4];
        registers[4] = registers[3] + temp1;
        registers[3] = registers[2];
        registers[2] = registers[1];
        registers[1] = registers[0];
        registers[0] = temp1 + temp2;
    }
    
        public byte[] intToBytes(int i) {
        byte[] b = new byte[4];
        for (int c = 0; c < 4; c++) {
            b[c] = (byte) ((i >>> (56 - 8 * c)) & 0xff);
        }
        return b;
    }
}
    
