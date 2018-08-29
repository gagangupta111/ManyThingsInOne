package com.DesignPattern.state;

public class Light {

    private State state;
    private boolean on = false;
    private String name;

    public Light() {
        this.state = OffState.INSTANCE;
    }

    public Light(String name) {
        this.name = name;
        this.state = OffState.INSTANCE;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton(){

        state.change(this);

    }

}
