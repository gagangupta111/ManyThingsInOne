package com.test;

import java.util.Collections;
import java.util.List;

final public class Immutable {

    private final int value;
    private final String string;
    private final List<Integer> list;

    public Immutable(int value, String string, List<Integer> list) {

        this.value = value;
        this.string = string;
        this.list = Collections.unmodifiableList(list);

    }

    public int getValue() {
        return value;
    }

    public String getString() {
        return string;
    }

    public List<Integer> getList() {
        return list;
    }

}
