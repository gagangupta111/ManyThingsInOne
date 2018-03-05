package com.cache;

import java.util.*;

public class LRUCache {

    public static void main(String[] args){

        System.out.println(" Hello ! ");
        LRU lru = new LRU(new ArrayList<>(10), new HashMap<Integer, Node>());

        for (int i = 0 ; i < 10; i++){

            lru.fetch(i);
            System.out.println();
            lru.print();

        }


    }

}

class Node{

    private int value;
    private Node next;
    private Node prev;

    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class LRU{

    public static int MAX = 10;
    private final List<Node> list;
    private final Map<Integer, Node> map;

    public LRU(List<Node> list, Map<Integer, Node> map) {
        this.list = list;
        this.map = map;
    }

    public List<Node> getList() {
        return list;
    }

    public Map<Integer, Node> getMap() {
        return map;
    }

    public void fetchFromDisk(){
        // nothing for now. Dummy function.
    }

    public int fetch(int value){

        int returnValue;

        if (map.get(value) != null){

            Node node = map.get(value);
            returnValue = node.getValue();

            Node first = list.get(0);
            if (first.getValue() == node.getValue()){
                // do nothing. just return the value.
                returnValue = first.getValue();
            }else {
                // replace the node itself.
                node.getPrev().setNext( node.getNext() );
                if (node.getNext() != null){
                    node.getNext().setPrev( node.getPrev() );
                }

                node.setPrev(null);
                node.setNext(first);
                first.setPrev(node);

            }

        }else {

            Node node  = new Node(value, null, null);
            returnValue = node.getValue();
            map.put(returnValue, node);

            if (list.size() == LRU.MAX){

                Node last = list.get(LRU.MAX-1);
                map.remove(last.getValue());
                last.setPrev(null);
                last.setNext(null);
                last.getPrev().setNext(null);
                last = null;

            }

            if (list.size() != 0){

                Node first = list.get(0);
                node.setPrev(null);
                node.setNext(first);
                first.setPrev(node);

            }else {
                list.add(node);
            }



        }

        return returnValue;

    }

    public void print(){

        for (Node node : list){
            System.out.println( node.getValue() );
        }

    }

}
