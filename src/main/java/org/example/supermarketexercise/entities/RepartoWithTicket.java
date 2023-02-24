package org.example.supermarketexercise.entities;

public class RepartoWithTicket extends Reparto implements TicketInterface {

    private int currentTicket = 0;

    @Override
    public int getTicket() {
        currentTicket++;
        return currentTicket;
    }
}
