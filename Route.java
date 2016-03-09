import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route extends Ligne
{
   public Route(){
       for (int j=0 ; j<10;j++){
           this.getCases()[j] = new Case("route");
       }
    }
}
