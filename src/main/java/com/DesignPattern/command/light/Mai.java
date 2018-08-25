package com.DesignPattern.command.light;

public class Mai {

    public static void main(String[] args){

        Light light = new Light();
        Command commandOn = new OnCommand(light);
        Command commandOff = new OffCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(commandOff);
        remoteControl.pressButton();

        remoteControl.setCommand(commandOn);
        remoteControl.pressButton();

        remoteControl.setCommand(commandOff);
        remoteControl.pressButton();

    }

}
