package hash;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class SHA_512 {
    
    MessageDigest md;
    
    public SHA_512() throws NoSuchAlgorithmException {
         this.md = MessageDigest.getInstance("SHA-512");
    }
    
    public byte[] getDigest(String plain) {
        byte[] digest = md.digest(plain.getBytes());
        
        return digest;
    }
    
    public BigInteger getBigInteger(byte[] digest) {
        BigInteger bint = new BigInteger(1, digest);

        return bint;
    }
    
    public String generateSHA_512(String plain) {
        byte[] digest = getDigest(plain);
        BigInteger bInt = getBigInteger(digest);
        String hashString = bInt.toString(16);
        
        while(hashString.length() < 32){
            hashString = "0" + hashString;
        }
        
        return hashString.toUpperCase();
    }
    
}
