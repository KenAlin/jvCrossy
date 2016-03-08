import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ligne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ligne extends Actor
{
    private int posY;
    private Case[] cases = new Case[10];

    /**
     * Constructor for objects of class Ligne
     */
    public Ligne(int y)
    {
        setPosY(y*50);
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public Case[] getCases(){
        return this.cases;
    }
    public void setPosY(int y){
        this.posY = y;
    }
    
    public void setCase(int i, String s){
        this.cases[i] = new Case(s);
    }
}
