package com.DesignPattern.decorator;

public class DecoratorDemo {

    public static void main(String[] args){

        System.out.printf(" Hello ! ");

    }

}


interface A{

    public void a();

}

abstract class AwithX implements A{

    @Override
    public void a() {
        System.out.printf("AwithX");
    }



}


