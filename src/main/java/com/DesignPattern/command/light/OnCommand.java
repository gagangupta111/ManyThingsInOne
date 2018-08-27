package com.DesignPattern.command.light;

public class OnCommand implements Command {

    @Override
    public void execute(Light light) {
        light.lightOn();
    }
}
