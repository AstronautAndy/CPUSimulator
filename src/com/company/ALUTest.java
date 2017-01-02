package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 11/2/2016.
 */
public class ALUTest {
    ALU testALU;
    cRegister c;
    String testStr1 = "010";
    String testStr2 = "111";
    @Before
    public void setUp() throws Exception {
        testALU = new ALU();
        c = new cRegister("00110");
        testALU.setOutpuReg(c);
    }

    @Test
    public void testAddition(){
        assertEquals(testALU.add("0001","0011"), "100") ;
    }

    @Test
    public void testSubtraction(){
        assertEquals(testALU.subtract("0100","0001"), "11");
    }

    @Test
    public void AND() throws Exception {
        assertEquals(testALU.AND(testStr1,testStr2),"010");
    }

    @Test
    public void OR() throws Exception {
        assertEquals(testALU.OR(testStr1,testStr2),"111");
    }

    @Test
    public void XOR() throws Exception {
        assertEquals(testALU.XOR(testStr1,testStr2),"101");
    }

    @Test
    public void flipBits() throws Exception {
        assertEquals(testALU.flipBits(testStr1),"101");
    }

    @Test
    public void testOutputWrite(){
        testALU.setbValue("0100"); //Set B to binary 4
        testALU.operation("000","0001");
        assertEquals(c.getValueStored(),"101");
    }
}