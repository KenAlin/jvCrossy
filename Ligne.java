import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ligne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ligne extends Actor
{
    // instance variables - replace the example below with your own
    //protected String type;
    private int posY;
    private Case[] cases = new Case[10];

    /**
     * Constructor for objects of class Ligne
     */
    public Ligne(int y/*, String t*/)
    {
        setPosY(y*50);
        /*setType(t);
        System.out.println(type + posY);*/
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public Case[] getCases(){
        return this.cases;
    }
    
    /*public String getType(){
        return this.type;
    }*/
    
    public void setPosY(int y){
        this.posY = y;
    }
    
    public void setCase(int i, String s){
        this.cases[i] = new Case(s);
    }
    
    /*public void setType(String t){
        this.type = t;
    }*/
    public void act(){
        System.out.println("toytroey");
        // Add your action code here.
        getWorld().addObject(this, 0, 0);
    }
}
