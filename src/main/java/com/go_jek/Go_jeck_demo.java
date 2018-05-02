package com.go_jek;

public class Go_jeck_demo {

    public static void main(String[] args){



    }

}

class CarParkingLot{

}

class AvailableSlots{

    private static volatile AvailableSlots availableSlots = null;

    private AvailableSlots(){}

    public static AvailableSlots getAvailableSlots(){

        if (availableSlots == null){

            synchronized (AvailableSlots.class){

                if (availableSlots == null){
                    availableSlots = new AvailableSlots();
                }

            }

        }

        return availableSlots;

    }

    private Slot root;

    public void setRoot(Slot root) {
        this.root = root;
    }

    public Slot getSlot(){

        if (root == null){
            return null;
        }

        Slot slot = root;
        root = root.getNext();
        slot.setNext(null);

        return slot;

    }

    public void returnSlot(Slot slot){

        if (root == null){
            root = slot;
            return;
        }

        if (slot.getSlot_no() < root.getSlot_no() ){
            slot.setNext(root);
            root = slot;
            return;
        }

        Slot found = root;
        Slot prev = null;
        while (found != null && found.getSlot_no() < slot.getSlot_no()){
            prev = found;
            found = found.getNext();
        }

        if (found == null){
            prev.setNext(slot);
        }else {
            prev.setNext(slot);
            slot.setNext(found);
        }

    }

    public void initializeSlots(long n){

        Slot now = null;
        Slot next = null;
        int slot_no = 1;

        if (n-- >= 1){

            root = new Slot(slot_no++);
            now = root;

        }

        while (n-- >= 1){

            next = new Slot(slot_no++);
            now.setNext(next);
            now = next;
            next = null;

        }

    }

}

class Car{

    private String reg_no;
    private String color;
    private Slot slot;

    public Car(String reg_no, String color) {
        this.reg_no = reg_no;
        this.color = color;
    }

    public String getReg_no() {
        return reg_no;
    }

    public String getColor() {
        return color;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}

class Slot{

    private long slot_no;
    private Slot next;
    private boolean available = true;
    private Car car;

    public Slot(long slot_no) {
        this.slot_no = slot_no;
    }

    public long getSlot_no() {
        return slot_no;
    }

    public Slot getNext() {
        return next;
    }

    public void setNext(Slot next) {
        this.next = next;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}