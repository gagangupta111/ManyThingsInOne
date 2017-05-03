package com.Externalization;


import java.io.*;

public class Car extends Automobile implements Externalizable {

    private String name;
    private int year;

    public Car() { super(); }

    Car(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String toString() {

        return("Name: " + name + "\n" + "Year: " + year + "regNo: " + getRegNo() + "\n" + "milege: " + getMileage());

    }

    public void writeExternal(ObjectOutput out) throws IOException {

        super.writeExternal(out);

        out.writeObject(this.name);
        out.writeInt(this.year);

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        super.readExternal(in);

        this.name = (String) in.readObject();
        this.year = in.readInt();

    }
}
