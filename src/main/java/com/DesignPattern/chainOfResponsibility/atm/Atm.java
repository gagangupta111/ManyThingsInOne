package com.DesignPattern.chainOfResponsibility.atm;

import java.util.ArrayList;
import java.util.List;

public class Atm {

    private List<NotePile> notePiles = new ArrayList<>();

    public List<NotePile> getNotePiles() {
        return notePiles;
    }

    public void addNotePile(NotePile notePile) {
        this.notePiles.add(notePile);
    }

    public Response fetchResponse(Request request) throws MoneyNotFoundException {

        int requested_value = request.getRequest_value();
        Response response = new Response();

        for (NotePile notePile : notePiles){

            response = notePile.handle(request, response);
            if (request.getRequest_value() == 0){
                break;
            }

        }

        if (response.getTotal_value() != requested_value){
            throw new MoneyNotFoundException("Requested Money can not be fetched! Please enter correct value!");
        }

        return response;

    }

}
