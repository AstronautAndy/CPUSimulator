package com.company;

/**
 * Created by Andrew on 10/31/2016.
 */
public class Assembly_Commands {
    Assembly_to_RTN ARTNPointer;
    public Assembly_Commands(Assembly_to_RTN pointer){
        ARTNPointer = pointer;
    }

    public void runProgram(){
        ARTNPointer.rrmovq("00111","01000");
    }
}
