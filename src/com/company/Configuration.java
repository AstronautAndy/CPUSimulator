package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Andrew on 11/2/2016.
 */
public class Configuration {
    /**
     * Eventually, this class needs to read from a file
     */
    //Set default values for each value for testing purposes, so I don't have to change a bunch of stuff
    static int wordSize = 3; //has been set to 3 for testing purposes
    static int pcIncrementValue = 2;
    static int number_of_generic_registers = 5;

    public void readFile(String fileName) throws IOException {
        String line = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(br);
            while(sc.hasNextLine() ){
                line = sc.next();
                switch (line){
                    case("wordSize:"): wordSize = Integer.parseInt( sc.next() ); break;
                    case("pcIncrementValue:"): pcIncrementValue = Integer.parseInt( sc.next() ); break;
                    case("number_of_generic_registers:"): number_of_generic_registers = Integer.parseInt( sc.next() ); break;
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
