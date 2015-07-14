/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Raim
 */
public class Bay {
    static ArrayList<Ship> boats = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args){
        int op = 0;

        do{
            System.out.print("\t***MENU***\n1. Add boat.\n2. Add element.\n" +
                "3. Empty ship.\n4. List passengers.\n5. Add cardumen.\n6. Exit." +
                    "\nType your option: ");
            op = lea.nextInt();
            try{
                switch(op){
                    case 1:
                        System.out.print("1. FISHING.\n2. PASSENGER.\n" +
                                "Write the ship type you wish to add (as the types shown): ");
                        addShip(ShipType.valueOf(lea.next().toUpperCase()));
                        break;
                    case 2:
                        addElement(callSearch());
                        break;
                    case 3:
                        double tot = emptyShip(callSearch());
                        System.out.println("Generated total: " + tot);
                        break;
                    case 4:
                        listPassengers();
                        break;
                    case 5:
                        String boat = callSearch();
                        System.out.print("Type the quantity of fishes to be added: ");
                        int fishes = lea.nextInt();
                        addCardumen(boat, fishes);
                        break;
                    case 6:
                        System.out.println("Exiting.");
                        break;
                    default:
                        System.out.println("Invalid option. Select again.");
                }
            }
            catch(CardumenException e){
                System.out.println("Error: " + e.getMessage());
            }

        }while(op != 6);

    }

    /**
     * Static method for adding a ship to the ArrayList <code>boats</code>
     * @param tipo - The Ship's type, which may either be <code>PASSENGER</code> or <code>FISHING</code>
     */
    public static void addShip(ShipType tipo){
        Ship b = null;
        String n = "";
        do{
            System.out.print("Type the name of the ship you want to create: ");
            n = lea.next();
            b = searchShip(n);
        }while(b != null);

        if (tipo == ShipType.PASSENGER){
            System.out.print("Type the ticket's price: ");
            double price = lea.nextDouble();
            System.out.print("Type the quantity of passengers the ship may hold: ");
            int c = lea.nextInt();
            boats.add(new PassengerShip(n, c, price));
        }
        else{
            System.out.print("Type the price of a fish: ");
            double precio = lea.nextDouble();
            boats.add(new FishingShip(n, precio));
        }
    }

    /**
     * Adds the respective element for the ship; due to polymorphism, it calls
     * the necessary ship's method, regardless of it being a Fishing or Passenger one
     * @param name 
     */
    public static void addElement(String name){
        Ship barc = searchShip(name);
        if (barc != null)
            barc.addElement();
        else
            System.out.println("Ship not found.");
    }

    public static String callSearch(){
        System.out.print("Type the name of the ship to search: ");
            return lea.next();
    }

    /**
     * Searchs if the ship exists in the ArrayList
     * @param n - Name of the ship to search
     * @return - The instance of the ship if found; <code>null</code> otherwise.
     */
    public static Ship searchShip(String n){
        for(Ship b : boats){
            if(b.getName().equals(n))
                return b;
        }

        return null;
    }

    /**
     * Empties the ship with its respective method, showing the total generated and all
     * @param n - Name of the ship to be emptied.
     * @return - The total generated from the ship
     */
    public static double emptyShip(String n){
        Ship b = searchShip(n);
        if (b != null){
            System.out.println(b);
            return b.emptyCharge();
        }else
            System.out.println("Ship not found.");

        return 0;
   }

    /**
     * If it is a passenger ship, it lists its passengers.
     */
    public static void listPassengers() {
        for(Ship b : boats){
            if (b instanceof PassengerShip)
                ((PassengerShip)b).listPassengers();
        }
    }

    /**
     * If it is a Fishing ship, it adds a fish/cardumen
     * @param name - Name of the ship to search
     * @param quant - Quantity of fishes to be added
     * @throws CardumenException - If fish quantity is negative
     */
    public static void addCardumen(String name, int quant)throws CardumenException {
        Ship b = searchShip(name);

        if(b instanceof FishingShip){
            ((FishingShip)b).addCardumen(quant);
            System.out.println("CORRECTLY ADDED.");
        }else
            System.out.println("Fishing ship not found.");
    }
}
