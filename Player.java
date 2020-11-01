import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Class;
/**
 * Write a description of class IdlePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int playerMovementSpeed = 3;
    public int money = 0;
    public static int selectedSeed = 1;
    
    GreenfootImage img = getImage();
    Color currentColor = new Color (255, 0, 0);
    String pressedKey = "1";
    
    /**
     * Act - do whatever the IdlePlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //GreenfootImage img = getImage();
        //Color currentColor = new Color (255, 255, 255);
        //img.setColor(currentColor);
        //setImage(img);
        movement();
        plantSeed();
        selectSeed();
    }
    
    public void movement(){
        if (getOneObjectAtOffset(0, playerMovementSpeed, null) == null) {
        if(Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + playerMovementSpeed);
            setImage("BCC Looking down.png");
        }
    }
        if (getOneObjectAtOffset(0, -playerMovementSpeed, null) == null) {
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - playerMovementSpeed);
            setImage("BCC Looking up.png");
        }
    }
        if (getOneObjectAtOffset(playerMovementSpeed, 0, null) == null) {
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + playerMovementSpeed, getY());
            setImage("BCC Looking right.png");
        }
    }
        if (getOneObjectAtOffset(-playerMovementSpeed, 0, null) == null) {
        if(Greenfoot.isKeyDown("a")) {
            setLocation(getX() - playerMovementSpeed, getY());
            setImage("BCC Looking left.png");
        }
    }
    }
    
    public void plantSeed() {
        if(Greenfoot.isKeyDown("e")) {
            for (int distance = 1; distance <= 32; distance++) {
                    List neighbours = this.getObjectsInRange(distance, null);
                    if (neighbours.size() != 0) {
                        for (Object neighbour : neighbours) {
                            if (neighbour instanceof Soils) {
                                Actor soil = (Actor)neighbour;
                                if (MainWorld.seedShop.getSeedAmount() > 0)  {
                                    MainWorld.seedShop.getSeedObject();
                                    this.getWorld().addObject((Actor)MainWorld.seedShop.getSeedObject(), soil.getX(), soil.getY());
                                    MainWorld.seedShop.suptractSeedAmount();
                                    return;  
                                }
                            }   
                        }
                    }
                }
            }
        }
    
    public void selectSeed() {
        try{
            switch(Greenfoot.getKey()) {
                    case "1":
                    selectedSeed = 1;
                    break;
                    case "2":
                    selectedSeed = 2;
                    break;
                    case "3":
                    selectedSeed = 3;
                    break;
                    case "4":
                    selectedSeed = 4;
                    break;
                    case "5":
                    selectedSeed = 5;
                    break;
                }
            } catch(Exception e)  {}
        }
        
    public int getSelectedSeed() {
            return selectedSeed;
        }
        
    public String getTheWorld() {
            return getWorld() + "";
        }
    
    public Object whatIsNear() {
            return getOneObjectAtOffset(playerMovementSpeed, 0, null);
        }
}
