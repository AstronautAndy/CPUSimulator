package com.company;
import java.util.*;
/**
 * Created by Andrew on 11/1/2016.
 */
public class cRegister extends Register {
    private char zeroFlag = '0';
    private char negativeFlag = '0';
    private char overFlowFLag = '0';
    private String identification;
    private String valueStored;

    public cRegister(String id){
        super();
        identification = id;
    }

    void setValue(String inputVal){
        valueStored = inputVal;
        int total = 0;
        if(inputVal.charAt(0)== '1'){
            negativeFlag = '1';
        }
        //Loop used to check whether the input value is composed of
        for(int i=0; i< inputVal.length(); i++ ){
            total += Character.getNumericValue(inputVal.charAt(i) );
        }
        if(total == 0){
            zeroFlag = '1';
        }
    }

    /**
     *
     * @param z boolean that states zero flag will be reset
     * @param n boolean that states negative flag will be reset
     * @param o boolean that states overflow flag will be reset
     */
    void resetFlags(boolean z, boolean n, boolean o){
        if(z == true){
            zeroFlag = '0';
        }
        if(n == true){
            negativeFlag = '0';
        }
        if(o == true){
            overFlowFLag = 'o';
        }
    }

    public char getOverFlowFLag() {
        return overFlowFLag;
    }

    public char getNegativeFlag() {
        return negativeFlag;
    }

    public char getZeroFlag() { return zeroFlag; }

    @Override
    public String getIdentification() {
        return identification;
    }

    @Override
    public String getValueStored() {
        return valueStored;
    }
}
