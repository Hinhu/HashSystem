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
        System.out.println(sha256.getHash("This example illustrates how to write plain text in an HTML file. Blank lines (as next line) are ignored. Similarly, if you press the Enter key, you will not get a new paragraph. To illustrate this I am pressing Enter right here ... and as you can see, the line continue. If you want to break the line you This example illustrates how to write plain text in an HTML file. Blank lines (as next line) are ignored. Similarly, if you press the Enter key, you will not get a new paragraph. To illustrate this I am pressing Enter right here ... and as you can see, the line continue. If you want to break the line you "));
    }
    
}
