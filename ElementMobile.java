import greenfoot.*;
/**
 * Write a description of class ElementMobile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElementMobile extends Actor
{
    private int vitesse;
    private int direction = 1;
    private int tick;
    private boolean estMechant = true;

    /**
     * Constructor for objects of class ElementMobile
     */
    public ElementMobile()
    {
    }
    
    public ElementMobile(String sens)
    {
        if (sens.equals("droite")) {
            this.getImage().mirrorHorizontally();
            this.direction = -1;
        }
    }
    
    public void setTick(int t) {
        tick = t;
    }
    
    public int getTick() {
        return tick;
    }
    
    public void setVitesse(int v) {
        vitesse = v;
        this.setTick(v);
    }
    
    public int getVitesse() {
        return vitesse;
    }
    
    public final Monde getMonde() 
    {
        return (Monde)getWorld();
    }
    
    public void destroy(){
        getMonde().removeObject(this);
    }
    
    public void act(){
        if( (getOneIntersectingObject(Personnage.class) != null) && estMechant ) {
            Greenfoot.stop();
        }
        if (this.getTick() == 0) {
            if ((this.getX() == 9 && this.direction == 1) || (this.getX() == 0 && this.direction == -1)) {
                this.destroy();
            }
            this.move(this.direction);
            this.setTick(this.getVitesse());
        }
        else {
            this.setTick(this.getTick()-1);
        }
    }
}
