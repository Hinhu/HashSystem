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
                addOption("i", "input", true, "file or stdin to be hashed").
                addOption("o", "output", false, "output file, if not - stdout");
        
        this.parser = new DefaultParser();
    }
    
}