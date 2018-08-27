package com.DesignPattern.state;

public class DimState implements State {

    private DimState(){}

    public static State INSTANCE = new DimState();

    @Override
    public void change(Light light) {
        light.setState(OffState.INSTANCE);
        System.out.println("Light is OFF!");
    }
}
