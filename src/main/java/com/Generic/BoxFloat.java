package com.Generic;

public class BoxFloat extends Box<Float> {

    public BoxFloat(Float length, Float width, Float height) {

        super(length, width, height);

    }

    Float volume() {

        return length*width*height;

    }
}