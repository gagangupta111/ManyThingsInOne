package com.DesignPattern.command.light;

public class Light {

    private boolean on = false;
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void lightOn(){
        on = true;
        System.out.println(name + " is on!");
    }

    public void lightOff(){
        on = false;
        System.out.println(name + " is off!");
    }

    public void lightDimm(){
        on = false;
        System.out.println(name + " is Dimm!");
    }

}
