/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author bauti
 */
public class Ticket {
    
    private int flightNum;
    private int seat;
    private float price;
    
    public Ticket(int flightNum, int seat, float price)
    {
        this.flightNum = flightNum;
        this.seat = seat;
        this.price = price;
    }
    
    public float getPrice()
    {
        return this.price;
    }
    
    public int getFlightNumber()
    {
        return this.flightNum;
    }
    
    public int getSeatNumber()
    {
        return this.seat;
    }
}
