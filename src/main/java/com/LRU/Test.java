package com.LRU;

import java.util.HashMap;

public class Test {

    public static void main(String[] args){

        System.out.println(" Hello !");

        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        Node head = new Node(1, 12);
        map.put(1, head);
        Node node = head;

        for (int i = 3; i < 10; i++){

            Node next = new Node(i, i*10);
            node.setNext(next);
            node.getNext().setPrev(node);
            map.put(i, next);
            node = next;

           }

        Cache cache = new Cache(11);
        cache.setMap(map);

        cache.print();

        System.out.println(" cache.get(5) " + cache.get(5));
        System.out.println(" cache.get(23) " + cache.get(23));
        System.out.println();

        

        }

    }