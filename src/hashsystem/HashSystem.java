/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

import hash.MD5;
import hash.SHA_512;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;


/**
 *
 * @author User
 */
public class HashSystem {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     * @throws org.apache.commons.cli.ParseException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, ParseException {
        
        CommandParser cmdParser = new CommandParser();
        MD5 md5 = new MD5();
        SHA_512 sha512 = new SHA_512();
        
        cmdParser.cmd = cmdParser.parser.parse(cmdParser.options, args);
        CommandLine cmd = cmdParser.cmd;
        
        String hashType = cmd.getOptionValue("a");
        String input = cmd.getOptionValue("i");
        
        
        if(cmd.hasOption("o")) {
            String outputFile = cmd.getOptionValue("o");
        }
        
    }
    
}
