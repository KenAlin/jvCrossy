import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Herbe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Herbe extends Ligne
{
   public Herbe(int i){
       super(i);
       for (int j=0 ; j<10;j++){
           this.getCases()[j] = new Case("herbe");
       }
    }
}
