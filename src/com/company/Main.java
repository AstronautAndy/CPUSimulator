package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Configuration newConfig = new Configuration(); //Create Configuration object
        try {
            newConfig.readFile("C:\\Users\\Andrew\\IdeaProjects\\CPU_Simulator\\Config.txt"); //Read values from the Configuration file into the Config object
        }catch (IOException ex){
            ex.printStackTrace();
        }
        CPU programCPU = new CPU(5); //Instantiate CPU object that the program will use
        Assembly_to_RTN ARTNCModule = new Assembly_to_RTN("C:\\Users\\Andrew\\IdeaProjects\\CPU_Simulator\\AssemblyToRTN.txt", programCPU.bus);
        Assembly_Commands commands = new Assembly_Commands(ARTNCModule);

        try {
            ARTNCModule.readFile();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        CS203_GUI newGUI = new CS203_GUI();
        commands.runProgram();
    }
}
