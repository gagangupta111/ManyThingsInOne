package com.Generic;

public class BoxInt extends Box<Integer> {

    public BoxInt(Integer length, Integer width, Integer height) {

        super(length, width, height);

    }

    public Integer volume() {

        return length*width*height;

    }

}