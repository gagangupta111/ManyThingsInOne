package com;

import java.util.*;

public class Test
{

    public static void main(String args[])
    {

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


    }

}

final class FinalTesting{

    public final int integer;
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

}


