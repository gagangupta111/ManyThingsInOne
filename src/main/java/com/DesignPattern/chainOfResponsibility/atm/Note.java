package com.DesignPattern.chainOfResponsibility.atm;

public class Note {

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
