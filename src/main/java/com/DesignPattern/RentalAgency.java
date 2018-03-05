package com.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {

    public static void main(String[] args){

        Agency agencyOne = new Agency1(new ArrayList<>(), "One");
        Agency agencyTwo = new Agency1(new ArrayList<>(), "Two");
        Agency agencyThree = new Agency1(new ArrayList<>(), "Three");

        RentalDealer rentalDealer = new RentalDealer(agencyTwo);
        List<Flat> list = rentalDealer.getAllFlats(Flat.BHK.BHK2, 10000);

        System.out.println(" Agency name: " + agencyOne.getName());
        for (Flat flat : list){

            System.out.println(" Flat Type : " + flat.getBhk() + " rent " + flat.getRent());

        }

    }

}

class RentalDealer{

    private Agency agency;

    public RentalDealer(Agency agency) {
        this.agency = agency;
    }

    public List<Flat> getAllFlats(Flat.BHK bhk, int minimumRent){

        return agency.getAllFlats(bhk,  minimumRent);

    }

}

interface Agency{

    public String getName();
    public boolean addFlat(Flat flat);
    public boolean removeFlat(Flat flat);
    public boolean updateFlat(Flat flat);
    public List<Flat> getAllFlats(Flat.BHK bhk, int minimumRent);

}

class Agency1 implements Agency{

    private List<Flat> list;
    private String name;

    public Agency1(List<Flat> list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean addFlat(Flat flat) {
        return list.add(flat);
    }

    @Override
    public boolean removeFlat(Flat flat) {
        return list.remove(list);
    }

    @Override
    public boolean updateFlat(Flat flat) {

        return true;

    }

    @Override
    public List<Flat> getAllFlats(Flat.BHK bhk, int minimumRent) {

        return list;
    }
}

 class Flat{

    public enum BHK
    {
        BHK2, BHK3, BHK4;
    }

    private Enum bhk;
    private int rent;

    public Flat(Enum bhk, int rent) {
        this.bhk = bhk;
        this.rent = rent;
    }

    public Enum getBhk() {
        return bhk;
    }

    public void setBhk(Enum bhk) {
        this.bhk = bhk;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

}
