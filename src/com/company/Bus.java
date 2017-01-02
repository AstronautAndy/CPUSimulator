package com.company;

import java.util.ArrayList;

/**
 * Created by Andrew on 10/31/2016.
 */
public class Bus {
    //Instantiate connections to each major component on the CPU
    ALU alu; cRegister cReg; ArrayList<Register> genericRegSet; Register MD; Register MA; Register IR; Register PC; Register A;
    ArrayList<Object>[] componentHashTable;
    /**
     * Constructor used to set all components found in the CPU to pointers in the Bus, effectively connecting the different
     * components.
     * @param overlord
     */
    public Bus(CPU overlord){
        genericRegSet = new ArrayList<Register>();
        componentHashTable = new ArrayList[100];
        int regIDValue = 6;
        for(int i=0; i<componentHashTable.length; i++){
            componentHashTable[i] = new ArrayList<Object>();
        }
        cReg = overlord.cReg; componentHashTable[BinToInt(cReg.getIdentification())].add(cReg);
        alu = overlord.alu; alu.setOutpuReg(cReg); //Set the output register of the ALU that the alu will write to
        for(int i =0; i< overlord.genericRegSet.size(); i++){   //Add each generic register to the hash table of components
            componentHashTable[BinToInt(overlord.genericRegSet.get(i).getIdentification())].add(overlord.genericRegSet.get(i));
        }

        //Set all components in the hash table of components
        MD = overlord.MD; componentHashTable[BinToInt(MD.getIdentification())].add(MD);
        MA = overlord.MA; componentHashTable[BinToInt(MA.getIdentification())].add(MA);
        IR = overlord.IR; componentHashTable[BinToInt(IR.getIdentification())].add(IR);
        PC = overlord.PC; componentHashTable[BinToInt(PC.getIdentification())].add(PC);
        A = overlord.A; componentHashTable[BinToInt(A.getIdentification())].add(A);
    }

    /**
     * Receive RTN commands from an outside object
     * @param opCode
     */
    public void decode(String opCode){
        String command = opCode.substring(0,5);
        String source = opCode.substring(5,10);
        String destination = opCode.substring(10,15);

        switch(command){
            case("00000"): incrementPCValue(command); break; //movValues();
            case("00001"): movValues(source,destination); break;
        }
    }

    /**
     * Method used to move the value from one Register to another
     * @param sourceID
     * @param destinationID
     */
    public void movValues(String sourceID, String destinationID){
        Register source = (Register) componentHashTable[BinToInt(sourceID)].get(0);
        Register destination = (Register) componentHashTable[BinToInt(destinationID)].get(0);
        destination.setValueStored(source.getValueStored());
    }

    /**
     * Method used to store a binary string representing an immediate value in a register of choice (denotes by its binary string, of course)
     * @param immediate
     * @param destinationID
     */
    public void storeImmediate(int immediate, String destinationID){
        Register dest = (Register) componentHashTable[BinToInt(destinationID)].get(0); //Obtain the register we want to store a value to from the hash table
        dest.setValueStored(IntToBin(immediate)); //Obtain a string representing the immediate value
    }

    /**
     * Method used to store a binary string value into the 'b' value of the ALU
     * @param sourceID
     */
    public void writeToALUBPort(String sourceID){
        Register source = (Register) componentHashTable[BinToInt(sourceID)].get(0);
        alu.setbValue(source.getValueStored());
    }

    /**
     * Pass in the opCode to designate the operation we want the ALU to run, as well as the value contained in the Register A
     * @param opCode
     */
    public void aluOperation(String opCode){
        alu.operation(opCode,A.getValueStored());
    }

    public String readValueFromC(){
        return cReg.getValueStored();
    }

    /**
     * Method used to convert binary strings to integer values
     * @param binaryString
     * @return
     */
    public int BinToInt(String binaryString){
        int value = Integer.parseInt(binaryString,2);
        return value;
    }

    /**
     * Method used to comvert an integer into a binary string
     * @param i
     * @return
     */
    public String IntToBin(int i){
        return Integer.toBinaryString(i);
    }

    /**
     * Return a register given that register's identification bit string.
     * @param locationCode
     * @return
     */
    public Register getRegister(String locationCode){
        Register foundRegister = null;
        foundRegister = (Register) componentHashTable[BinToInt(locationCode)].get(0);
        return foundRegister;
    }

    /**
     * I decided to encode the PC incrementing process in such a way because the first two lines of each assembly program will run in the same fashion -
     * where the PC is incremented and the next instruction it loaded into the IR. Pulling the instruction from Main Memory will be abstracted in the
     * simulation by moving the string representing the next instruction to MD, and then to IR.
     */
    public void incrementPCValue(String instruction){
        movValues("00000","00010"); //Move from PC to register A
        movValues("00000","00100"); //Move current PC address to register MA
        alu.setbValue(IntToBin(Configuration.pcIncrementValue) );
        alu.operation("000",A.getValueStored()); //Add the value stored in Register A to the value passed to the B port of the ALU and store the value in register C
        MD.setValueStored(instruction); //Move M[MA] (Abstracted by input 'intstruction') to to MD before updating
        movValues("00110","00000"); //Store the value from C into the PC, hereby "updating" the PC value
        movValues("00101","00001"); //Store the value located in MD to IR, the instruction register
    }



}
