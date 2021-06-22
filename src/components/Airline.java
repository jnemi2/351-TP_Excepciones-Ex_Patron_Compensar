/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;
import components.Flight;
import components.SeatStatus;
import exceptions.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bauti
 */
public class Airline {
    
    private ArrayList<Flight> flights;
    
    public Airline()
    {
        flights = new ArrayList<>();
        flights.add(new Flight());
    }
    
    public ArrayList<Integer> getAvailableSeats(int flightNumber)
    {
        ArrayList<Integer> results = new ArrayList<>();
        Flight flight = this.flights.get(flightNumber);
        for (int i = 0; i < flight.getSeats(); i++)
        {
            if (flight.getSeatStatus(i) == SeatStatus.AVAILABLE)
                results.add(i);
        }
        return results;
    }
    
    public Ticket reserveFlightTicket(int flightNum, int seatNum) throws UnavailableSeatException
    {
        Flight flight = this.flights.get(flightNum);
        if (flight.getSeatStatus(seatNum) == SeatStatus.AVAILABLE)
        {
            flight.lockSeat(seatNum);
            System.out.println("Your seat is now locked. Please, complete your payment to book your ticket.");
            return new Ticket(flightNum, seatNum, 1000);
        }else{
            throw new UnavailableSeatException();
        }
    }
    
    public void processPayment(Ticket ticket)
    {
        Flight flight = this.flights.get(ticket.getFlightNumber());
        try
        {
            PaymentSystem paymentSystem = new PaymentSystem();
            paymentSystem.processPayment(ticket.getPrice());
            flight.reserveSeat(ticket.getSeatNumber());
            System.out.println("You have booked your ticket.");
        }catch(FailedPaymentException e)
        {
            //Compensate
            flight.unlockSeat(ticket.getSeatNumber());
            System.out.println("There was a problem processing your payment.");
            System.out.println("Your reservation is now cancelled.");
        }
    }
}
