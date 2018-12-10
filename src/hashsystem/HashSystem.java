/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

import cryptoWilku.CryptoWilku;
import hash.MD5;
import hash.SHA_512;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class HashSystem {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     * @throws org.apache.commons.cli.ParseException
     * @throws java.io.IOException
     */

    public static void main(String[] args) throws NoSuchAlgorithmException, 
            ParseException,
            IOException {
        
        CommandParser cmdParser = new CommandParser();
        MD5 md5 = new MD5();
        SHA_512 sha512 = new SHA_512();
        
        cmdParser.cmd = cmdParser.parser.parse(cmdParser.options, args);
        CommandLine cmd = cmdParser.cmd;
        
        String hashType = cmd.getOptionValue("a");
        
        String input = "";

        String pass = cmd.getOptionValue("p");
        
        if(cmd.hasOption("if")) {
            String inputFile = cmd.getOptionValue("if");
            try {
                FileReader inFile = new FileReader(inputFile);
                int i;
                while((i = inFile.read()) != -1) {
                    input += (char)i;
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HashSystem.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Input file not found");
            }

        } else {
            input = cmd.getOptionValue("i");
        }
        
        String result = null;
        
        switch(hashType) {
            case "md5":
                result = md5.generateMD5(input);
                break;
            case "sha512":
                result = sha512.generateSHA_512(input);
                break;
            case "crypto":
                result = CryptoWilku.applyCrypto(input, pass);
                break;
        }
        
        if(cmd.hasOption("of")) {
            String outputFile = cmd.getOptionValue("of");
            BufferedWriter outFile = new BufferedWriter(new FileWriter(outputFile));
            outFile.write(result);
            outFile.close();
            
        } else {
            System.out.println(result);
        }
        
    }
    
}
