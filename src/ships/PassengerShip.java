/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

import java.util.Scanner;
/**
 *
 * @author Raim
 */
public class PassengerShip extends Ship{
    private String [] names;
    private double pricePerTicket;
    private int passengerQuantity;
    private final static Scanner lea = new Scanner(System.in);
    
    /**
     * Constructor for PassengerShip
     * @param name - Ship name
     * @param size - Quantity of passengers it may hold
     * @param price - Ticket price
     */
    public PassengerShip(String name, int size, double price) {
        super(name);
        names = new String[size];
        passengerQuantity = 0;
        pricePerTicket = price;
    }
    
    /**
     * Searches for the first free index in the passengers' names array
     * @return 
     */
    public int searchFreePosition(){        
        for (int i = 0; i < names.length; i++){
            if (names[i] == null)
                return i;
        }
        
        return -1;
    }
    
    @Override
    public void addElement() {
        int pos = searchFreePosition();
        if (pos > -1){
            System.out.print("Type the passenger's name: ");
            names[pos] = lea.next();
            passengerQuantity++;
        }else
            System.out.println("There's no more space for passengers.");
    }

    @Override
    public double emptyCharge() {
        int totalPas = passengerQuantity;
        passengerQuantity = 0;
        
        return totalPas * pricePerTicket;
    }
    
    /**
     * Lists all the passengers that bought a ticket, using a for each
     */
    public void listPassengers(){
        System.out.println("**PASSENGERS THAT BOUGHT TICKETS**");
        for(String pas : names){
            if (pas != null)
                System.out.println("Name: " + pas);
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nQuantity of passengers that bought tickets: #" + passengerQuantity;
    }
    
}