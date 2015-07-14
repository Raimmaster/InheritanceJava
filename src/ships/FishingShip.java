/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

/**
 *
 * @author Raim
 */
public class FishingShip extends Ship{
    private int capturedFishes;
    public final double pricePerFish;
    
    public FishingShip(String name, double price) {
        super(name);
        pricePerFish = price;
        capturedFishes = 0;
    }    
    
    @Override
    public void addElement() {
        capturedFishes++;
    }

    @Override
    public double emptyCharge() {
        int totalPeces = capturedFishes;
        capturedFishes = 0;
        return totalPeces * pricePerFish;
    }
    
    /**
     * Adds a specified <code>quantity</code> of fishes
     * @param quantity the quantity of cardumen/fishes
     * @throws CardumenException If the quantity is negative
     */
    public void agregarCardumen(int quantity)throws CardumenException {
        if( quantity < 0 )
            throw new CardumenException(quantity);
        capturedFishes += quantity;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nCaptured Fishes: #" + capturedFishes;
    }
    
}