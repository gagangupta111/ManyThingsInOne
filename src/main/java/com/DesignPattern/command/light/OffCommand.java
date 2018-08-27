package com.DesignPattern.command.light;

public class OffCommand implements Command{

    @Override
    public void execute(Light light) {
        light.lightOff();
    }
}
