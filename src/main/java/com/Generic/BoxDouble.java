package com.Generic;

public class BoxDouble extends Box<Double> {

    public BoxDouble(Double length, Double width, Double height) {

        super(length, width, height);

    }

    Double volume() {

        return length*width*height;

    }
}
