package com.company;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 11/2/2016.
 */
public class cRegisterTest {
    cRegister cTest = new cRegister("00110");
    String testStr1 = "000";
    String testStr2 = "100";
    String testStr3;
    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Now Beginning Setup");
        //cTest = new cRegister(); //Initialize cTest
        testStr1 = "000";
        testStr2 = "100";
    }

    @org.junit.After
    public void tearDown() throws Exception {
        cTest = null;
    }

    @org.junit.Test
    public void setValue() throws Exception {
        cTest.setValue(testStr1);
        assertEquals(cTest.getZeroFlag(),'1');
        cTest.setValue(testStr2);
        assertEquals(cTest.getNegativeFlag(),'1');
    }

    @org.junit.Test
    public void resetFlags() throws Exception {
        cTest.setValue(testStr1);
        cTest.setValue(testStr2);
        cTest.resetFlags(true,true,true);
        assertEquals(cTest.getNegativeFlag(),'0');
        assertEquals(cTest.getZeroFlag(),'0');
    }

}