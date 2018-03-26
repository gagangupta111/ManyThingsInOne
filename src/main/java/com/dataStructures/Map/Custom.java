package com.dataStructures.Map;

import java.util.Map;
import java.util.Set;

public class Custom {


    public static void main(String[] args){

        Map<Key, String> map = new java.util.HashMap<>();
        map.put(new Key(100), "100");
        map.put(new Key(200), "200");
        map.put(new Key(100), "300");

        Set<Map.Entry<Key, String>> entries =  map.entrySet();

        for (Map.Entry<Key, String> keyStringEntry : entries){
            System.out.println(keyStringEntry.getKey() + "   " + keyStringEntry.getValue());
        }

    }

}


class HashMap{

}

class Key{

    int k;

    public Key(int k) {
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        return k == key.k;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Key{" +
                "k=" + k +
                '}';
    }
}
