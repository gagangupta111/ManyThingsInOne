package com.DesignPattern.chainOfResponsibility.atm;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private List<Note> notes = new ArrayList<>();
    private int total_value = 0;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public int getTotal_value() {
        return total_value;
    }

    public void setTotal_value(int total_value) {
        this.total_value = total_value;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void addAllNotes(List<Note> notes) {
        this.notes.addAll(notes);
    }

    @Override
    public String toString() {
        return "Response{" +
                "notes=" + notes +
                ", total_value=" + total_value +
                '}';
    }
}
