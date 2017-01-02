package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 11/8/2016.
 */
public class BusTest {
    CPU newCPU = new CPU(5);
    Bus test;
    @Before
    public void setUp() throws Exception {
        test = new Bus(newCPU);
    }

    @Test
    public void decode() throws Exception {
        test.decode("0000011111111110");
    }

    @Test
    public void testMoveValues(){
        test.movValues("00000","00010"); //Moves PC to A
        assertEquals(test.A.getValueStored(), "00000");
    }

    @Test
    public void testStoreImmediate(){
        test.storeImmediate(5,"00000");
        assertEquals(test.PC.getValueStored(),"101"); //Do I need to left pad the values stored?
    }

    @Test
    public void testIncrementPC(){
        test.incrementPCValue("00001");
    }

    @Test
    public void testGenericRegisterAddition(){
        for(int i = 7; i<13; i++){
            assertTrue(test.componentHashTable[i].size() != 0); //Each element representing where a generic register is stored should be filled
        }
    }

}