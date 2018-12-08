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

    private final int[] h = {
        0x6a09e667,
        0xbb67ae85,
        0x3c6ef372,
        0xa54ff53a,
        0x510e527f,
        0x9b05688c,
        0x1f83d9ab,
        0x5be0cd19
    };

    private final int[] k = {
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

    private Chunk512 chunk = new Chunk512();
    private final int [] words32 = new int[64];

    public String getHash(String input) throws NoSuchAlgorithmException {
        
        byte[] inputBytes = stringToBytes(input);

        byte[] padded = doPadding(inputBytes);

        for (int i = 0; i < 64; i++) {
            words32[i] = 0;
        }
        HashRegister tmpRegister = new HashRegister();
        tmpRegister.setValue(Arrays.copyOf(h, 8));
        
        for (int i = 0; i < padded.length / 64; i++) {

            HashRegister hashRegister = new HashRegister();
            hashRegister.setValue(tmpRegister.getRegisterCopy());

            System.arraycopy(padded, 64 * i, chunk.getChunk(), 0, 64);

            System.out.println("Chunk" + i);
            System.out.println(Arrays.toString(chunk.getChunk()));

            setupWords();

            for (int j = 0; j < 64; ++j) {
                calculate(hashRegister, words32, j);
            }

            for (int j = 0; j < 8; ++j) {
                tmpRegister.setValue(j, tmpRegister.getValue(j) + hashRegister.getValue(j));
            }
        }

        byte[] hash = new byte[32];

        for (int i = 0; i < 8; i++) {
            System.arraycopy(intToBytes(tmpRegister.getValue(i)), 0, hash, 4 * i, 4);
        }

        return DatatypeConverter.printHexBinary(hash);
    }

    byte[] stringToBytes(String s) throws NoSuchAlgorithmException {
        byte[] bytes = "ashfbvyuagfawiigebuigbsdihadfdfgashfbvyuagfawiigebuigbsdihadfdfiigebuigbsdihadashfbvyuagfawiigebuigbsdihadfdfgashfbvyuagfawiigebuigbsdihadfdfiigebuigbsdihadashfbvyuagfawiigebuigbsdihadfdfgashfbvyuagfawiigebuigbsdihadfdfiigebuigbsdihad".getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    byte[] doPadding(byte[] bytes) {
        
        System.out.println("\nPadding input:");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes)+"\n");

        int len = bytes.length;
        int tail = len % 64;
        int padding;

        if ((64 - tail >= 9)) {
            padding = 64 - tail;
        } else {
            padding = 128 - tail;
        }

        byte[] pad = new byte[padding];
        pad[0] = (byte) 0x80; // 1 and 7 zeros
        
        long bits = len * 8; // message lenght in bits
        byte[] byteBits = longToBytes(bits);
        
        System.arraycopy(byteBits, 0, pad, padding-8, byteBits.length);
        
        byte[] output = new byte[len + padding];

        System.arraycopy(bytes, 0, output, 0, len);
        System.arraycopy(pad, 0, output, len, pad.length);
        
        System.out.println("\nPadding output:");
        System.out.println(output.length);
        System.out.println(Arrays.toString(output)+"\n");

        return output;
    }
    
    public static byte[] longToBytes(long l) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte)(l & 0xFF);
            l >>= 8;
        }
    return result;
}

    Chunk512[] breakToChunks(byte[] bytes) {
        Chunk512[] chunks = new Chunk512[1000];
        return chunks;
    }

    public void calculate(HashRegister register, int[] words, int j) {

        int s0 = Integer.rotateRight(register.getValue(0), 2)
                ^ Integer.rotateRight(register.getValue(0), 13)
                ^ Integer.rotateRight(register.getValue(0), 22);

        int maj = (register.getValue(0) & register.getValue(1)) ^ (register.getValue(0) & register.getValue(2))
                ^ (register.getValue(1) & register.getValue(2));

        int temp2 = s0 + maj;

        int s1 = Integer.rotateRight(register.getValue(4), 6)
                ^ Integer.rotateRight(register.getValue(4), 11)
                ^ Integer.rotateRight(register.getValue(4), 25);

        int ch = (register.getValue(4) & register.getValue(5)) ^ (~register.getValue(4) & register.getValue(6));

        int temp1 = register.getValue(7) + s1 + ch + k[j] + words32[j];

        register.rollWIthValues(temp1, temp2);
    }

    private void setupWords() {
        for (int j = 0; j < 16; j++) {
            words32[j] = 0;
            for (int m = 0; m < 4; m++) {
                words32[j] |= ((chunk.getChunk()[j * 4 + m] & 0x000000FF) << (24 - m * 8)); // TO CHANGE
            }
        }

        for (int j = 16; j < 64; ++j) {
            int s0 = Integer.rotateRight(words32[j - 15], 7)
                    ^ Integer.rotateRight(words32[j - 15], 18)
                    ^ (words32[j - 15] >>> 3);

            int s1 = Integer.rotateRight(words32[j - 2], 17)
                    ^ Integer.rotateRight(words32[j - 2], 19)
                    ^ (words32[j - 2] >>> 10);

            words32[j] = words32[j - 16] + s0 + words32[j - 7] + s1;
        }
    }

    public byte[] intToBytes(int i) {
        byte[] b = new byte[4];
        for (int c = 0; c < 4; c++) {
            b[c] = (byte) ((i >>> (56 - 8 * c)) & 0xff);
        }
        return b;
    }
}
