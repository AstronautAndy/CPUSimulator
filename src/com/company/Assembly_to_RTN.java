package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Andrew on 10/31/2016.
 * This class works by receiving a set of RTN commands (opcodes) for each assembly command listed below. The assembly program (encased in an object)
 * provides a list of assembly commands that will be run on the simulator. Will work by storing an array of strings in each method
 */
public class Assembly_to_RTN {
    String fileName;
    Bus busPointer;
    ArrayList<String> totalCommandSet; //Save all information from file in a single ArrayList
    ArrayList<String> rrmovqCommands; ArrayList<String> irmovqCommands; ArrayList<String> rmmovqCommands;
    ArrayList<String> jeCommands; ArrayList<String> jgCommands; ArrayList<String> jlCommands; ArrayList<String> jgeCommands;
    ArrayList<String> jleCommands; ArrayList<String> jmpCommands; ArrayList<String> haltCommands; ArrayList<String> retCommands;
    ArrayList<String> callCommands; ArrayList<String> pushqCommands; ArrayList<String> popqCommands;

    public Assembly_to_RTN(String filePath, Bus bus){
        fileName = filePath;
        busPointer = bus;
        totalCommandSet = new ArrayList<String>(); rrmovqCommands = new ArrayList<String>(); irmovqCommands= new ArrayList<String>(); rmmovqCommands = new ArrayList<String>();
        jeCommands = new ArrayList<String>(); jgCommands = new ArrayList<String>(); jlCommands = new ArrayList<String>(); jgeCommands = new ArrayList<String>();
        jleCommands = new ArrayList<String>(); jmpCommands = new ArrayList<String>(); haltCommands = new ArrayList<String>(); retCommands = new ArrayList<String>();
        callCommands = new ArrayList<String>(); pushqCommands = new ArrayList<String>(); popqCommands = new ArrayList<String>();
    }

    /**
     * This method is used to store all lines of text found in the designated assembly - RTN conversion file in an arrayList
     * This arraylist will later be parsed and handled in another file.
     */
    public void readFile() throws IOException {
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(br);
            //File file = new File(fileName);
//            FileReader filereader = new FileReader(fileName);
//            BufferedReader bufferedreader = new BufferedReader(filereader);
            while(sc.hasNextLine() ) {
                line = sc.nextLine();
                totalCommandSet.add(line);
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }finally {
            try{
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
    }

    public void parseCommands(){
        Iterator<String> commandIt = totalCommandSet.iterator();
        while(commandIt.hasNext() ){
            String line = commandIt.next();
            switch(line){
                case "rrmovq": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {rrmovqCommands.add(line);} } break;
                case "irmovq": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {irmovqCommands.add(line);} } break;
                case "rmmovq": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {rmmovqCommands.add(line);} } break;
                case "je": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {jeCommands.add(line);} } break;
                case "jmp": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {jmpCommands.add(line);} } break;
                case "jle": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {jleCommands.add(line);} } break;
                case "jl": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {jlCommands.add(line);} } break;
                case "jge": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {jgeCommands.add(line);} } break;
                case "jg": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {jgCommands.add(line);} } break;
                case "halt": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {haltCommands.add(line);} } break;
                case "ret": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {retCommands.add(line);} } break;
                case "call": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {callCommands.add(line);} } break;
                case "pushq": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {pushqCommands.add(line);} } break;
                case "popq": while(commandIt.hasNext() ){ line = commandIt.next(); if(line.equals(";") ){break;} else {popqCommands.add(line);} } break;
            }
        }
    }

    /**
     * The rrmovq command should convert the src and dst fields into appropriate strings of bits to be concatenated with the opcodes before being passed into the Bus for
     * decoding.
     * @param src
     * @param dst
     */
    public void rrmovq(String src,String dst){
        for(int i = 0; i< rrmovqCommands.size(); i++){
            //Concatenate the src and dst bits with the opcode
            String fullCommand = null;
            busPointer.decode(fullCommand);
        }
    }

    public void irmovq(String val, String dst){

    }

    public void rmmovq(String scr, String dst){

    }

    public void je(){

    }
}
