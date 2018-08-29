package com.DesignPattern.state;

public class OnState implements State{

    private OnState(){}

    public static State INSTANCE = new OnState();

    @Override
    public void change(Light light) {
        light.lightDimm();
        light.setState(DimState.INSTANCE);
    }

}
