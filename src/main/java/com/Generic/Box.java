package com.Generic;

public abstract class Box<T> {

    T length;
    T width;
    T height;

    public Box(T length, T width, T height){

        this.length = length;
        this.width = width;
        this.height = height;

    }


    abstract T volume();

}