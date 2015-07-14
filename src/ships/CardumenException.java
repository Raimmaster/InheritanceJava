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
public class CardumenException extends Exception {
    public CardumenException(int c){
        super(c + " is not a valid quantity.");
    }
            
}