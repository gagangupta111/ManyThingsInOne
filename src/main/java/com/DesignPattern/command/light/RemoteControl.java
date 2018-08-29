package com.DesignPattern.command.light;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {

    private Light light;
    private String name;
    private Map<String, Command> commands = new HashMap<>();

    public RemoteControl(Light light, String name) {
        this.light = light;
        this.name = name;
        commands.put("ON", new OnCommand());
        commands.put("OFF", new OffCommand());
    }

    public void addCommand(String key, Command command){
        commands.put(key, command);
    }

    public void executeCommand(String key, Command command){
        commands.get(key).execute(light);
    }

    public void onCommand(){
        commands.get("ON").execute(light);
    }

    public void offCommand(){
        commands.get("OFF").execute(light);
    }

}
