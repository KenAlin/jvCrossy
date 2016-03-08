import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Personnage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personnage extends Actor
{
    private int x;
    private int tickMove = 15;

    /**
     * Constructor for objects of class Personnage
     */
    public Personnage()
    {
        this.setRotation(270);
    }
    
    public final Monde getMonde() 
    {
        return (Monde)getWorld();
    }
    
    public boolean obstacleNear(char c) {
        Actor voisin = getOneObjectAtOffset(0, 0, Piece.class);
        if (voisin != null){
            getMonde().removeObject(voisin);
        }
        if (c == 'l') {
            voisin = getOneObjectAtOffset(-1, 0, Arbre.class);
            if (voisin != null) return voisin.getClass().getName().equals("Arbre");
            else return false;
        }
        else if (c == 'u') {
            voisin = getOneObjectAtOffset(0, -1, Arbre.class);
            if (voisin != null) return voisin.getClass().getName().equals("Arbre");
            else return false;
        }
        else if (c == 'd') {
            voisin = getOneObjectAtOffset(0, 1, Arbre.class);
            if (voisin != null) return voisin.getClass().getName().equals("Arbre");
            else return false;
        }
        else if (c == 'r') {
            voisin = getOneObjectAtOffset(1, 0, Arbre.class);
            if (voisin != null) return voisin.getClass().getName().equals("Arbre");
            else return false;
        }
        return false; // Grrr
    }
    
    public void act() {
        tickMove--;
        if (tickMove < 0) tickMove = 0;
        
        if (this.getY() == 0 && Greenfoot.isKeyDown("up") && tickMove < 10) Greenfoot.stop();
        else if( (getOneIntersectingObject(Eau.class) != null) && getOneIntersectingObject(Nenuphar.class) == null ) {
            Greenfoot.stop();
        }
        if (Greenfoot.isKeyDown("left") && tickMove < 10) {
            setRotation(180);
            if (!obstacleNear('l')) {
                this.move(1);
                tickMove = 25;
            }
        }
        else if (Greenfoot.isKeyDown("right") && tickMove < 10) {
            setRotation(0);
            if (!obstacleNear('r')) {
                this.move(1);
                tickMove = 25;
            }
        }
        else if (Greenfoot.isKeyDown("up") && tickMove < 10) {
            setRotation(270);
            if (!obstacleNear('u')) {
                this.move(1);
                tickMove = 25;
            }
        }
        else if (Greenfoot.isKeyDown("down") && tickMove < 10) {
            setRotation(90);
            if (!obstacleNear('d')) {
                this.move(1);
                tickMove = 25;
            }
        }
    }
}
