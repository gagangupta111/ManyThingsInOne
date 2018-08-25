package com.DesignPattern.state;

public class Light {

    private State state;

    public Light() {
        this.state = OffState.INSTANCE;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton(){

        state.pressButton(this);

    }

}
