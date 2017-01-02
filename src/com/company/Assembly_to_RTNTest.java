package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 11/3/2016.
 */
public class Assembly_to_RTNTest {
    Assembly_to_RTN test;

    CPU cpuTest = new CPU(6);
    Bus busTest = new Bus(cpuTest);
    String fName = "test.txt" ;
    @Before
    public void setUp() throws Exception {
        test = new Assembly_to_RTN(fName, busTest);
    }

    @Test
    public void testFileReading(){
        try {
            test.readFile();
            assertTrue(test.totalCommandSet.size() == 4);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testCommandParsing() {
        try {
            test.readFile();
            test.parseCommands();
            assertEquals(test.rrmovqCommands.size(), 2);
            assertEquals(test.irmovqCommands.size(), 2);
            assertEquals(test.rmmovqCommands.size(), 3);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}