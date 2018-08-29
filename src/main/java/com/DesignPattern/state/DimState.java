package com.DesignPattern.state;

public class DimState implements State {

    private DimState(){}

    public static State INSTANCE = new DimState();

    @Override
    public void change(Light light) {
        light.lightOff();
        light.setState(OffState.INSTANCE);
    }
}
