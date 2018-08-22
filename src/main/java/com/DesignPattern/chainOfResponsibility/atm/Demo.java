package com.DesignPattern.chainOfResponsibility.atm;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws MoneyNotFoundException {

        Request request = new Request();
        request.setRequest_value(530);

        Atm atm = new Atm();
        atm.addNotePile(makeNotePile(500, 10));
        atm.addNotePile(makeNotePile(100, 20));
        atm.addNotePile(makeNotePile(50, 20));
        atm.addNotePile(makeNotePile(20, 20));
        atm.addNotePile(makeNotePile(10, 20));

        Response response = atm.fetchResponse(request);
        System.out.println(response);

    }

    public static NotePile makeNotePile(int value, int nos){

        NotePile notePile = new NotePile();
        notePile.setName( value + " rupees notes");
        notePile.setValue(value);
        notePile.setNotes(makeListOfNotes(value, nos));
        notePile.setTotal_value(value*10);
        return notePile;
    }

    public static List<Note> makeListOfNotes(int value, int nos){

        List<Note> notes = new ArrayList<>();

        for (int i = 0 ; i < nos; i++){

            Note note = new Note();
            note.setName( value + " rupees note");
            note.setValue(value);
            notes.add(note);

        }

        return notes;

    }

}
