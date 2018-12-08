
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class MD5 {
    
    MessageDigest md;
    
    MD5() throws NoSuchAlgorithmException {
         this.md = MessageDigest.getInstance("MD5");
    }
    
    public String generateMD5(String plain) {
        md.update(plain.getBytes());
        byte[] digest = md.digest();
        String hashString = DatatypeConverter.printHexBinary(digest);
        
        return hashString;
    }
    
}
