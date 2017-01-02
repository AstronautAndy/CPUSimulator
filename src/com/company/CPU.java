package com.company;

import java.util.ArrayList;

/**
 * Created by Andrew on 10/31/2016.
 */
public class CPU {
    Bus bus; ALU alu; cRegister cReg; ArrayList<Register> genericRegSet; Register MD; Register MA; Register IR; Register PC; Register A;
    int startValue = 8;
    /**
     * Constructor for the CPU object
     * @param busSize
     */
    public CPU(int busSize){
        genericRegSet = new ArrayList<Register>();
        createGenericRegisters();
        alu = new ALU(); alu.setIdentification("00011");
        cReg = new cRegister("00110");
        MD = new Register("00101");
        MA = new Register("00100");
        IR = new Register("00001");
        PC = new Register("00000");
        A = new Register("00010");
        PC.setValueStored("00000"); //Initialize the value of PC to zero
        bus = new Bus(this); //Create a new Bus that passes a pointer itself
    }

    public void createGenericRegisters(){
        genericRegSet.add(new Register("00111"));
        for(int i= 0; i< Configuration.number_of_generic_registers; i++){
            genericRegSet.add(new Register(IntToBin(startValue) ) );
            startValue++;
        }
    }

    /**
     * Method used to comvert an integer into a binary string
     * @param i
     * @return
     */
    public String IntToBin(int i){
        return Integer.toBinaryString(i);
    }
}
