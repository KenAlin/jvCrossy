import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rails here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rails extends Ligne
{
   public Rails(int i){
       super(i);
       for (int j=0 ; j<10;j++){
           setCase(j,"rails");
       }
    }
}
