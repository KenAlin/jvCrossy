import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monde extends World
{
    private Ligne[] lignes = new Ligne[8];
    private String[] types = {"herbe", "eau", "route", "rails"};
    private Personnage personnage = new Personnage();
    private int[] cooldown = new int[8];

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Monde()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 8, 64);
        for (int i=0 ; i<8 ; i++){
            String type = types[Greenfoot.getRandomNumber(4)];
            if (i==7){
                type = "herbe";
            }
            switch (type){
                case "herbe":
                    lignes[i] = new Herbe(i);
                    addObject(lignes[i], 4, i);
                    for (int j=0 ; j<10 ; j++){
                        //On place les arbres
                        if (Greenfoot.getRandomNumber(3) == 1 && (i !=7 || j!=5)){
                           addObject(new Arbre(), j, i);
                        }
                        //On place les pieces
                        else if (Greenfoot.getRandomNumber(20) == 1 && (i !=7 || j!=5)){
                            addObject(new Piece(), j, i);
                        }
                    }
                break;
                case "eau":
                    lignes[i] = new Eau(i);
                    addObject(lignes[i], 4, i);
                    for (int j=0 ; j<10 ; j++){
                        //On place les nenuphars
                        if (Greenfoot.getRandomNumber(2) == 1 || (i ==7 && j==5)){
                            addObject(new Nenuphar(), j, i);
                            //On place les pieces
                            if (Greenfoot.getRandomNumber(20) == 1 && (i !=7 || j!=5)){
                                addObject(new Piece(), j, i);
                            }
                        }
                    }
                break;
                case "route":
                    lignes[i] = new Route(i);
                    addObject(lignes[i], 4, i);
                    for (int j=0 ; j<10 ; j++){
                        //On place les pieces
                        if (Greenfoot.getRandomNumber(20) == 1 && (i !=7 || j!=5)){
                            addObject(new Piece(), j, i);
                        }
                    }
                break;
                default:
                    lignes[i] = new Rails(i);
                    addObject(lignes[i], 4, i);
                    for (int j=0 ; j<10 ; j++){
                        //On place les pieces
                        if (Greenfoot.getRandomNumber(20) == 1 && (i !=7 || j!=5)){
                            addObject(new Piece(), j, i);
                        }
                    }
                break;
            }
            /*GreenfootImage cell = new GreenfootImage(50, 50);
            GreenfootImage img = new GreenfootImage(lignes[i].getType()+".jpg");
            //GreenfootImage cell = new GreenfootImage("herbe.jpg");
            cell.drawImage(img, 0, 0);
            //cell.scale(100, 50);
            //setImage( img );
            setBackground(cell);*/
        }
        addObject(personnage, 5,7);
    }
    
    public void act(){
        int rng = Greenfoot.getRandomNumber(10);
        if (rng == 0) {
            int rngChemin = Greenfoot.getRandomNumber(8);
            if (lignes[rngChemin].getClass().getName().equals("Route") && cooldown[rngChemin] == 0){
                if (Greenfoot.getRandomNumber(10) < 7) {
                    addObject(new Voiture(), 0, rngChemin);
                    cooldown[rngChemin] = 20;
                }
                else {
                    addObject(new Camion(), 0, rngChemin);
                    cooldown[rngChemin] = 55;
                }
            }
        }
        for (int i = 0 ; i < 8 ; i++) {
            if (cooldown[i] > 0) {
                cooldown[i]--;
            }
            else cooldown[i] = 0;
        }
    }
}
