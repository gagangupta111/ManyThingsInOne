package com.multithreading.ConcurrentHashMap;

public class MapDemo {

    public static void main(String args[]){

        System.out.println(" Hello! ");
        ConcurrentHashMap map = new ConcurrentHashMap();

        for (int i = 0; i < 100; i++){

            int rand = (int) ( Math.random() * 1000 );
            Key key = new Key(rand*17);
            Node node = new Node(key, rand*53, key.hashCode(), null);
            map.add(node);
            map.get(node);

        }

        System.out.println(" Hello! ");

    }

}

class Node{

    private Key key;
    private int value;
    private int hashcode;
    private Node next;

    public Node(Key key, int value, int hashcode, Node next) {
        this.key = key;
        this.value = value;
        this.hashcode = hashcode;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (value != node.value) return false;
        if (hashcode != node.hashcode) return false;
        return key != null ? key.equals(node.key) : node.key == null;
    }

    @Override
    public int hashCode() {

        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + value;
        result = 31 * result + hashcode;
        return result;

    }

}

class ConcurrentHashMap{

    private Node[] bucket = new Node[10];

    public Node get(Node node){

        int hashcode  = node.getHashcode();
        int index = hashcode%10;
        Node current = bucket[index];

        while (current != null){

            if ( node.getKey().getKey() == current.getKey().getKey()){
                return current;
            }

            current = current.getNext();

        }
        return current;
    }

    public void add(Node node){

        int hashcode  = node.getHashcode();
        int index = hashcode%10;
        Node current = bucket[index];
        Node prev = null;

        if (current == null){
            bucket[index] = node;
            return;
        }

        while (current != null){



            if ( node.getKey().getKey() == current.getKey().getKey()){

                current.setHashcode(node.getHashcode());
                current.setValue(node.getValue());
                return;

            }

            prev = current;
            current = current.getNext();

        }

            prev.setNext(node);

    }

}

class Key{

    private int key;

    public Key(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key1 = (Key) o;

        return key == key1.key;
    }

    @Override
    public int hashCode() {
        return key;
    }

}
