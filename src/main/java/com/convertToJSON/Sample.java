package com.convertToJSON;

public class Sample {

    private int age;
    private String name;
    private String value;

    public Sample() {
    }

    public Sample(int age, String name, String value) {
        this.age = age;
        this.name = name;
        this.value = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
