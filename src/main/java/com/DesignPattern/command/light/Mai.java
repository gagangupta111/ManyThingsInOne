package com.DesignPattern.command.light;

public class Mai {

    public static void main(String[] args){

        Light light = new Light("Light");
        RemoteControl remoteControl = new RemoteControl(light, "RemoteControl");

        remoteControl.offCommand();
        remoteControl.onCommand();
        remoteControl.offCommand();

        Command command = new DimCommand();
        remoteControl.addCommand("DIMM", command);
        remoteControl.executeCommand("DIMM", command);

        Light light1 = new Light("Light1");
        RemoteControl remoteControl1 = new RemoteControl(light1, "RemoteControl1");
        remoteControl1.offCommand();

    }

}
