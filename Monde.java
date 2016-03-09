import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monde extends World
{
    //Les attributs
    private Ligne[] lignes = new Ligne[8];
    private String[] types = {"herbe", "eau", "route", "rails"};
    private Personnage personnage = new Personnage();
    private int[] cooldown = new int[8];
    
    //Pour plus tard
    private int niveau = 0;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Monde()
    {    
        // Create a new world with 10x8 cells with a cell size of 64x64 pixels.
        super(10, 8, 64);
        //La variable qui attribue un nombre a un type de terrain
        int idType;
        for (int i=0 ; i<8 ; i++){
            //La variable aleatoire pour créer les lignes de terrain
            int rngType = Greenfoot.getRandomNumber(10);
            /* Chance des types de route :
             *  20% eau (id 1)
             *  50% route (id 2)
             *  10% rails (id 3)
             *  20% herbe (id 0)
             */
            if (rngType < 2) idType = 1;
            else if (rngType < 7) idType = 2;
            else if (rngType < 8) idType = 3;
            else idType = 0;
            
            String type = types[idType];
            
            //La ligne du bas sera toujours de l'herbe
            if (i==7){
                type = "herbe";
            }
            //En fonction des types de lignes, on les génère differemment
            switch (type){
                case "herbe":
                    lignes[i] = new Herbe();
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
                    lignes[i] = new Eau();
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
                    lignes[i] = new Route();
                    addObject(lignes[i], 4, i);
                    for (int j=0 ; j<10 ; j++){
                        //On place les pieces
                        if (Greenfoot.getRandomNumber(20) == 1 && (i !=7 || j!=5)){
                            addObject(new Piece(), j, i);
                        }
                    }
                break;
                default:
                    lignes[i] = new Rails();
                    addObject(lignes[i], 4, i);
                    for (int j=0 ; j<10 ; j++){
                        //On place les pieces
                        if (Greenfoot.getRandomNumber(20) == 1 && (i !=7 || j!=5)){
                            addObject(new Piece(), j, i);
                        }
                    }
                break;
            }
        }
        //On ajoute le personnage au milieu de la ligne du bas
        addObject(personnage, 5,7);
    }
    
    public void act(){
        //Une chance sur 10 de faire apparaitre un vehicule
        int rng = Greenfoot.getRandomNumber(10);
        if (rng == 0) {
            //On choisit une ligne au hasard
            int rngChemin = Greenfoot.getRandomNumber(8);
            
            //On recupere le sens de circulation de cette ligne
            String sens = lignes[rngChemin].getSens();
            
            //On determine l'endroit d'apparition en fonction du sens de circulation
            int posX = 0;
            if (sens.equals("droite")) {
                posX = 9;
            }
            
            //Si on est sur une route on a 7 chances sur 10 de faire apparaitre une voiture et 3/10 un camion
            //On ne fait apparaitre un vehicule que si cooldown de chemin est a 0, pour ne pas faire apparaitre de vehicules trop souvent
            if (lignes[rngChemin].getClass().getName().equals("Route") && cooldown[rngChemin] == 0){
                if (Greenfoot.getRandomNumber(10) < 7) {
                    addObject(new Voiture(sens), posX, rngChemin);
                    cooldown[rngChemin] = 20;
                }
                else {
                    addObject(new Camion(sens), posX, rngChemin);
                    cooldown[rngChemin] = 55;
                }
            }
            //Si on est sur un chemin de fer on fait apparaitre un train
            //Le train a un grand delai de reapparition car il est tres rapide
            else if (lignes[rngChemin].getClass().getName().equals("Rails") && cooldown[rngChemin] == 0){
                addObject(new Train(sens), posX, rngChemin);
                    cooldown[rngChemin] = 200;
            }
        }
        //On diminue le cooldown
        for (int i = 0 ; i < 8 ; i++) {
            if (cooldown[i] > 0) {
                cooldown[i]--;
            }
            else cooldown[i] = 0;
        }
    }
}
