package com.Exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

   private final int a;

    public Test() {
        a = 0;
    }

    public Test(int x) {
        this();
    }

    public static void main(String[] args) throws Exception{

        List<A> list = new ArrayList<A>();

        list.add(new A(13, "shubham", 13));
        list.add(new A(14, "neelam", 14));
        list.add(new A(11, "gagan", 11));
        list.add(new A(12, "jai", 12));

        for (A a : list){
            if (a.getName().contains("jai")){
                a.setName(a.getName() + "jai");
                list.add(new A(15, "new", 15));
            }
            System.out.println(a.getId() + " " + a.getName());
        }

        Collections.sort(list);
        System.out.println();

        for (A a : list){
            System.out.println(a.getId() + " " + a.getName());
        }

        Collections.sort(list, new SortByName());
        System.out.println();

        for (A a : list){
            System.out.println(a.getId() + " " + a.getName());
        }

    }

}

class SortByName implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {

        String obj1 = ((A)o1).getName();
        String obj2 = ((A)o2).getName();

        if (obj1 == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        if (obj1.equals( obj2 )) {
            return 0;
        }

        return obj1.compareTo(obj2);

    }

}

class A implements Comparable{

    private final int a;
    private String name;
    private int id;

    public A() {

        a = 0;
        System.out.println(" Default A Constructor called! ");
    }

    public A(int a) {
        this.a = a;
        System.out.println(" Argument A Constructor called! ");
    }

    public A(int a, String name, int id) {
        this.a = a;
        this.name = name;
        this.id = id;
    }

    public int getA() {
        return a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {

        A a  = (A)o;

        if (this.id > a.id){
            return 1;
        }else if (this.id < a.id){
            return -1;
        }else return 0;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a1 = (A) o;

        if (a != a1.a) return false;
        if (id != a1.id) return false;
        return name != null ? name.equals(a1.name) : a1.name == null;

    }

    @Override
    public int hashCode() {

        int result = a;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + id;
        return result;

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(" finalize A called");
        super.finalize();
    }

    public void start() throws Exception{
        System.out.println(" A  start ! ");
    }

    public static void start(int b) throws Error{
        System.out.println(" A  int start ! ");
    }

    public void end() throws Exception{
        System.out.println(" A  end ! ");
    }

}


class B extends A{

    int b;

    public B() {

        System.out.println(" Default B Constructor called! ");

    }

    public B(int b) {

        this.b = b;
        System.out.println(" Argument B Constructor called! ");

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(" finalize B called");
        super.finalize();
    }

    public  void start() throws Error{
        System.out.println(" B  start ! ");
    }

    public static void start(int b) throws Error{
        System.out.println(" B  int start ! ");
    }

    public void end() throws OutOfMemoryError{
        System.out.println(" B  end ! ");
    }

}
