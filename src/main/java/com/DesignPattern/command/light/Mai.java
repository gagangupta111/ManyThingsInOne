package com.DesignPattern.command.light;

public class Mai {

    public static void main(String[] args){

        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl(light);

        remoteControl.offCommand();
        remoteControl.onCommand();
        remoteControl.offCommand();

        Command command = new DimCommand();
        remoteControl.addCommand("DIMM", command);
        remoteControl.executeCommand("DIMM", command);

    }

}
