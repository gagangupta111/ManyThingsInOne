package com.DesignPattern.command.light;

public class OnCommand implements Command {

    private Light light;

    public OnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void pressButton() {
        light.lightOn();
    }
}
