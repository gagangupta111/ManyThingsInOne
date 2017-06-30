package com.LRU;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Cache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMap(HashMap<Integer, Node> map) {
        this.map = map;
    }

    public Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.getValue();
        }

        return -1;
    }

    public void remove(Node n){
        if(n.getPrev() != null){
            n.getPrev().setNext(n.getNext());
        }else{
            head = n.getNext();
        }

        if(n.getNext()!=null){
            n.getNext().setPrev(n.getPrev());
        }else{
            end = n.getPrev();
        }

    }

    public void setHead(Node n){
        n.setNext(head);
        n.setPrev(null);

        if(head!=null)
            head.setPrev(n);

        head = n;

        if(end ==null)
            end = head;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.setValue(value);
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.getKey());
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }

    public void print(){

        Iterator entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry thisEntry = (Map.Entry) entries.next();
            Object key = thisEntry.getKey();
            Node value = (Node) thisEntry.getValue();
            System.out.println(" thisEntry.getKey(); " + key + " thisEntry.getData(); " + value.getValue());

        }

    }

}