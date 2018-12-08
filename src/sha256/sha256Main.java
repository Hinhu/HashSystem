/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author zychp
 */
public class sha256Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Sha256 sha256 = new Sha256();
        System.out.println(sha256.getHash("BANAN"));
    }
    
}
