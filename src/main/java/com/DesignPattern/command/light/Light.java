package com.DesignPattern.command.light;

public class Light {

    private boolean on = false;

    public void lightOn(){
        on = true;
        System.out.println("Light is on!");
    }

    public void lightOff(){
        on = false;
        System.out.println("Light is off!");
    }

    public void lightDimm(){
        on = false;
        System.out.println("Light is Dimm!");
    }

}
