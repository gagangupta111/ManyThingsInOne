package com.DesignPattern.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Facts implements Comparable<Facts>{

    public static class CodeComparator implements Comparator<Facts>{

        @Override
        public int compare(Facts o1, Facts o2) {

            if (o1.getCode() > o2.getCode()){
                return 1;
            }else if (o1.getCode() < o2.getCode()){
                return -1;
            }else {
                return 0;
            }

        }
    }

    public static void main(String[] args){

        List<Facts> list = new ArrayList<Facts>();
        list.add(new Builder(10).code(10).build());
        list.add(new Facts.Builder(14).code(15).build());
        list.add(new Facts.Builder(18).code(18).build());
        list.add(new Facts.Builder(1).code(12).build());
        list.add(new Facts.Builder(100).code(13).build());
        list.add(new Facts.Builder(50).code(16).build());
        list.add(new Facts.Builder(76).code(0).build());
        Collections.sort(list);

        for (Facts facts : list){
            System.out.println(facts);
        }

    }

    private final Integer id;
    private final int code;

    private Facts(Builder builder){
        this.id = builder.id;
        this.code = builder.code;
    }

    @Override
    public int compareTo(Facts o) {
        if (this.id > o.id){
            return 1;
        }else if (this.id < o.id){
            return -1;
        }else {
            return 0;
        }
    }

    public static class Builder{

            private final Integer id;
            private int code = 0;

            public Builder(Integer id){
                this.id = id;
            }

            public Builder code(int code){
                this.code  = code;
                return this;
            }

            public Facts build(){
                return new Facts(this);
            }

    }

    public Integer getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facts facts = (Facts) o;

        if (code != facts.code) return false;
        return id != null ? id.equals(facts.id) : facts.id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + code;
        return result;
    }

    @Override
    public String toString() {
        return "Facts{" +
                "id=" + id +
                ", code=" + code +
                '}';
    }



}
