package com.DesignPattern.command.light;

public class RemoteControl {

    private Command command;

    public RemoteControl() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.pressButton();
    }

}
