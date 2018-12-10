/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

/**
 *
 * @author User
 */
public class CommandParser {

    Options options;
    CommandLineParser parser;
    CommandLine cmd;
    
    CommandParser() {
        this.options = new Options();
        this.options.addOption("a", "algorithm", true, "select hash algorithm").
                addOption("i", "input", true, "stdin to be hashed").
                addOption("if", "infile", true, "input file").
                addOption("of", "outfile", true, "output file, if not - stdout").
                addOption("p", "password", true, "password for encryption/decryption");
        
        this.parser = new DefaultParser();
    }

}
