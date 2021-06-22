/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;
import exceptions.*;
import java.util.Scanner;

/**
 *
 * @author bauti
 */
public class PaymentSystem {
    public PaymentSystem()
    {
        
    }
    
    public void processPayment(float price) throws FailedPaymentException
    {
        System.out.print("You owe $" + price + ": ");
        Scanner sc = new Scanner(System.in);
        if (sc.nextFloat() >= price)
        {
            System.out.println("Payment processed successfully.");
        }else{
            throw new FailedPaymentException();
        }
    }
}
