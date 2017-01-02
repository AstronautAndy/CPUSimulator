package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 11/11/2016.
 */
public class CPUTest {
    CPU test;

    @Before
    public void setUp() throws Exception {
        test = new CPU(5);
    }

    @Test
    public void testConstructorResults(){
        assertTrue(test.genericRegSet.size() == 6);
    }
}