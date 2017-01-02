package com.company;

/**
 * Created by Andrew on 10/31/2016.
 * RTN_Instructions receive RTN instructions (encoded in OPcode) from the assembly to RTN converter
 */
public class RTN_commands {
    Bus bus; //Points to a Bus object that can be used to call commands specified by the RTN
    public RTN_commands(Bus _bus){
        bus = _bus;
    }

    /**
     * Method used to call the necessary functions given an n bit opcode
     * @param rtn_opcode
     */
    public void decode(String rtn_opcode){

    }

    /**
     * Method used to increment the PC by n, given the necessary constraints in the ALU config. The value of n is subject to change
     */
    public void increment_PC(){

    }


}
