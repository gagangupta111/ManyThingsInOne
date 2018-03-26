package com;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test
{

    public static void swap(FinalTesting one, FinalTesting two){

        System.out.println(one);
        System.out.println(two);
        System.out.println();

        FinalTesting temp = one;
        one = two;
        two = temp;

        System.out.println(one);
        System.out.println(two);
        System.out.println();

    }

    public static void main(String args[])
    {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);



        FinalTesting one = new FinalTesting(null, null);
        FinalTesting two = new FinalTesting(null, null);
        one.integer = 100;
        two.integer = 200;

        System.out.println(one);
        System.out.println(two);
        System.out.println();

        swap(one, two);

        System.out.println(one);
        System.out.println(two);
        System.out.println();

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(15);
        list.add(188);

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "bc");
        map.put("d", "gd");

        FinalTesting finalTesting = new FinalTesting(Collections.unmodifiableList(list), Collections.unmodifiableMap(map));

        list.add(200);
        map.put("e", "fgd");

        for (Integer i : finalTesting.list){
            System.out.println(" " + i);
        }

        System.out.println();

        Set<Map.Entry<String, String>> entries = finalTesting.map.entrySet();
        for (Map.Entry<String, String> entry : entries){

            System.out.println(entry.getKey() + " " + entry.getValue());

        }

        System.out.println();
        AtomicInteger atomicInteger = new AtomicInteger(100);
        System.out.println(atomicInteger.getAndIncrement());

        System.out.println(atomicInteger.getAndIncrement());

    }

}

final class FinalTesting{

    public int integer;
    public final List<Integer> list;
    public final Map<String, String> map;

    public FinalTesting(List<Integer> list, Map<String, String> map) {
        this.list = list;
        this.map = map;
        integer = 100;
    }

    public int getInteger() {
        return integer;
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "FinalTesting{" +
                "integer=" + integer +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}


