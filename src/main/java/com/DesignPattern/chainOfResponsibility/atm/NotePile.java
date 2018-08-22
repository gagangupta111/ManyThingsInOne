package com.DesignPattern.chainOfResponsibility.atm;

import java.util.Collections;
import java.util.List;

public class NotePile {

    private List<Note> notes;
    private String name;
    private int value;
    private int total_value;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTotal_value() {
        return total_value;
    }

    public void setTotal_value(int total_value) {
        this.total_value = total_value;
    }

    public Response handle(Request request, Response response){

        if (total_value == 0 || notes.isEmpty() || request.getRequest_value() == 0){
            return response;
        }

        if (request.getRequest_value() > total_value){
            response.addAllNotes(notes);
            this.notes = Collections.emptyList();
            response.setTotal_value(response.getTotal_value() + total_value);

            request.setRequest_value(request.getRequest_value() - total_value);
            total_value = 0;
            return response;
        }else{

            int no_of_notes_out = request.getRequest_value()/value;
            for (int i = 0; i < no_of_notes_out; i++){
                response.getNotes().add(notes.remove(i));
            }
            request.setRequest_value(request.getRequest_value() - (no_of_notes_out*value));
            response.setTotal_value(response.getTotal_value() + (no_of_notes_out*value));
            return response;
        }

    }

}
