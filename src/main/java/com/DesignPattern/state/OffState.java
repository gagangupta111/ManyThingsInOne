package com.DesignPattern.state;

public class OffState implements State {

    private OffState(){}

    public static State INSTANCE = new OffState();

    @Override
    public void change(Light light) {
        light.lightOn();
        light.setState(OnState.INSTANCE);
    }
}
