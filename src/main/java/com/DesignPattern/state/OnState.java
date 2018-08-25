package com.DesignPattern.state;

public class OnState implements State{

    private OnState(){}

    public static OnState INSTANCE = new OnState();

    @Override
    public void pressButton(Light light) {
        light.setState(OffState.INSTANCE);
        System.out.println("Light is Off!");
    }

}
