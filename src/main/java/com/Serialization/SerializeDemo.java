package com.Serialization;

import java.io.*;
public class SerializeDemo {

    public static void main(String [] args) {

        serializeDemo();
        deserializeDemo();

    }

    public static void serializeDemo(){


        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        try {

            FileOutputStream fileOut =
                    new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in employee.ser");

        }catch(IOException i) {
            i.printStackTrace();
        }

        // deserializeDemo();


    }

    public static void deserializeDemo(){

        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();

        }catch(IOException i) {
            i.printStackTrace();
            return;

        }catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println();
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);


    }
}
