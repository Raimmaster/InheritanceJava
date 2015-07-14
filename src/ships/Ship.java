/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

import java.util.Calendar;
import java.util.Formatter;

/**
 *
 * @author Raim
 */
public abstract class Ship {
    protected String name;
    protected Calendar circulationDate;
    
    public Ship(String nom){
        name = nom;
        circulationDate = Calendar.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCirculationDate() {
        return circulationDate;
    }

    public void setCirculationDate(Calendar circulationDate) {
        this.circulationDate = circulationDate;
    }
    
    public abstract void addElement();
    
    public abstract double emptyCharge();
    
    @Override
    public String toString(){
        Formatter formato = new Formatter();
        formato.format("%tF", circulationDate);
        return "Name: " + name + " - Circulation Date: " + formato.toString();
    }
}