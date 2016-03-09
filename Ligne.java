import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ligne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ligne extends Actor
{
    //Les attributs
    private Case[] cases = new Case[10];
    private boolean rtl; /* RTL -> right to left */

    /**
     * Constructor for objects of class Ligne
     */
    public Ligne() {
        //On definit un sens de circulation aleatoire
        int rng = Greenfoot.getRandomNumber(2);
        if (rng == 1){
            this.rtl = true;
        }else{
            this.rtl = false;
        }
    }
    
    public Case[] getCases(){
        return this.cases;
    }
    
    public String getSens(){
        if (this.rtl) return "droite";
        else return "gauche";
        //return rtl?"droite":"gauche";
    }
    
    public void setCase(int i, String s){
        this.cases[i] = new Case(s);
    }
}
