package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 11/13/2016.
 */
public class ConfigurationTest {
    Configuration test;
    @Before
    public void setUp() throws Exception {
        test = new Configuration();
    }

    @Test
    public void readFile() throws Exception {
        test.readFile("C:\\Users\\Andrew\\IdeaProjects\\CPU_Simulator\\Config.txt");
        assertEquals(Configuration.number_of_generic_registers, 6);
        assertEquals(Configuration.pcIncrementValue,3);
        assertEquals(Configuration.wordSize, 4);
    }

}