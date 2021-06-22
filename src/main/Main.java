/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import components.*;
import exceptions.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bauti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Airline airline = new Airline();
        
        ArrayList<Integer> seats = airline.getAvailableSeats(0);
        for (int i = 0; i < seats.size(); i++)
            System.out.print("" + seats.get(i) + ", ");
        System.out.print("\n");
        System.out.println("Which seat would you like to book? ");
        
        Scanner sc = new Scanner(System.in);
        int seatNumber = sc.nextInt();
        
        try
        {
            Ticket ticket = airline.reserveFlightTicket(0, 0);
            airline.processPayment(ticket);
        }catch(UnavailableSeatException e)
        {
            System.out.println("The seat is no longer available.");
        }
    }
    
}
