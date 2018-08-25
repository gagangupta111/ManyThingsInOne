package com.DesignPattern.command.light;

public class OffCommand implements Command{

    private Light light;

    public OffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void pressButton() {
        light.lightOff();
    }
}
