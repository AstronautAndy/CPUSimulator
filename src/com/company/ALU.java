package com.company;

/**
 * Created by Andrew on 10/31/2016.
 */
public class ALU {
    private String identification;
    private String bValue;
    private cRegister outpuReg;
    /**
     * IN the below methods, string a will always come from Register A, and String b will always come from bValue
     * Constructor for the ALU class
     */
    public ALU() {

    }

    /**
     * Remember that you won't be able to write output values from the ALU until you've set the output c register. This will normally be done in the Bus.
     * @param opCode
     * @param aValue
     */
    public void operation(String opCode, String aValue){
        switch(opCode){
            case("000"): writeOutputCValue( add(aValue,bValue) ); break;
            case("001"): writeOutputCValue( subtract(aValue,bValue) ); break;
            case("010"): writeOutputCValue( XOR(aValue,bValue) ); break;
            case("011"): writeOutputCValue( AND(aValue,bValue) ); break;
            case("100"): writeOutputCValue( OR(aValue,bValue) ); break;
            case("101"): writeOutputCValue( flipBits(aValue) ); break;
        }
    }

    public String AND(String a, String b){
        String result = "";
        for(int i=0; i<Configuration.wordSize; i++){
            if(a.charAt(i) == '1' && b.charAt(i) == '1' ){
                result += '1';
            }
            else{
                result += '0';
            }
        }
        return result;
    }

    public String OR(String a, String b){
        String result = "";
        for(int i=0; i<Configuration.wordSize; i++){
            if(a.charAt(i) == '1' || b.charAt(i) == '1' ){
                result += '1';
            }
            else{
                result += '0';
            }
        }
        return result;
    }

    public String XOR(String a, String b){
        String result = "";
        for(int i=0; i<Configuration.wordSize; i++){
            if(a.charAt(i) == '1' ^ b.charAt(i) == '1' ){
                result += '1';
            }
            else{
                result += '0';
            }
        }
        return result;
    }

    /**
     *
     * @param a Will be pulled from the value currently stored in the A register, not from the B port
     * @return
     */
    public String flipBits(String a){
        String result = "";
        for(int i=0; i<Configuration.wordSize; i++){
            if(a.charAt(i) == '1'){
                result += '0';
            }
            else{
                result += '1';
            }
        }
        return result;
    }

    /**
     * Converts a and b to integers, adds the two values, then converts the integer back into a string of bits and returns the bit string
     * @param a
     * @param b
     * @return
     */
    public String add(String a, String b){
        return IntToBin(BinToInt(a) + BinToInt(b));
    }

    /**
     * Converts a and b to integers, subtracts the two values, then converts the integer back into a string of bits and returns the bit string
     * @param a
     * @param b
     * @return
     */
    public String subtract(String a, String b){
        return IntToBin(BinToInt(a) - BinToInt(b));
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getbValue() {
        return bValue;
    }

    public void setbValue(String bValue) {
        this.bValue = bValue;
    }

    public void setOutpuReg(cRegister outpuReg) {
        this.outpuReg = outpuReg;
    }

    /**
     * Is used to write output values to the C register, which can be retrieved by the Bus
     * @param output
     */
    public void writeOutputCValue (String output){
        outpuReg.setValue(output);
    }

    public int BinToInt(String binaryString){
        int value = Integer.parseInt(binaryString,2);
        return value;
    }

    public String IntToBin(int i){
        return Integer.toBinaryString(i);
    }
}
