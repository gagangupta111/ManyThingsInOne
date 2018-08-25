package com.DesignPattern.state;

public class OffState implements State {

    private OffState(){}

    public static OffState INSTANCE = new OffState();

    @Override
    public void pressButton(Light light) {
        light.setState(OnState.INSTANCE);
        System.out.println("Light is ON!");
    }
}
