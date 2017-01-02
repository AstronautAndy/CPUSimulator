package com.company;

/**
 * Created by Andrew on 10/31/2016.
 */
public class Register {
    private String valueStored;
    private String identification;

    public Register(String id){
        identification = id;
    }

    public Register() {

    }

    void setValueStored(String newValue){
        valueStored = newValue;
    }

    String getValueStored(){
        return valueStored;
    }

    public String getIdentification() {
        return identification;
    }
}
