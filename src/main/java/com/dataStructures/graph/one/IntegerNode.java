package com.dataStructures.graph.one;

public class IntegerNode implements Node<Integer> {

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return getValue();
    }

    @Override
    public void set(Integer integer) {
        setValue(integer);
    }

}