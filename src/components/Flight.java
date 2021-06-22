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
public class Flight {
    
    private final int SEATS = 200;
    private SeatStatus [] seats = new SeatStatus [SEATS];
    
    public Flight()
    {
        for (int i = 0; i < this.SEATS; i++)
            this.seats[i] = SeatStatus.AVAILABLE;
        //this.seats[0] = SeatStatus.RESERVED;
    }
    
    public int getSeats()
    {
        return this.SEATS;
    }
    
    public SeatStatus getSeatStatus(int index)
    {
        return this.seats[index];
    }
    
    public void lockSeat(int index)
    {
        this.seats[index] = SeatStatus.LOCKED;
    }
    
    public void unlockSeat(int index)
    {
        this.seats[index] = SeatStatus.AVAILABLE;
    }
    
    public void reserveSeat(int index)
    {
        this.seats[index] = SeatStatus.RESERVED;
    }

}
