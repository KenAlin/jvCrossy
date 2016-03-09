import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rails here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rails extends Ligne
{
   public Rails(){
       for (int j=0 ; j<10;j++){
           setCase(j,"rails");
       }
    }
}
