import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eau extends Ligne
{
   public Eau(){
       for (int j=0 ; j<10;j++){
           this.getCases()[j] = new Case("eau");
       }
    }
}
