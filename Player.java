import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    GreenfootImage img = getImage();
    Color currentColor = new Color (255, 0, 0);
    
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
    
    
    
    public String getTheWorld() {
            return getWorld() + "";
        }
    
    public Object whatIsNear() {
            return getOneObjectAtOffset(playerMovementSpeed, 0, null);
        }
}
