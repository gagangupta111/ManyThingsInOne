package com.DesignPattern.command.light;

public class DimCommand implements Command{

    @Override
    public void execute(Light light) {
        light.lightDimm();
    }
}
