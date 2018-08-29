package com.DesignPattern.state;

public class Main {

    public static void main(String[] args){

        Light light = new Light("Light");

        light.pressButton();    // 1
        light.pressButton();    // 2
        light.pressButton();    // 3
        light.pressButton();    // 4
        light.pressButton();
        
    }

}
