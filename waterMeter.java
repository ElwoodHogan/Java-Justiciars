import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class waterMeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class waterMeter extends HUD
{
    public int waterLevel = 100;
    private int tempWaterLevel = 100;
    GreenfootImage rectImage = getImage();
    GreenfootImage ogImage = new GreenfootImage(rectImage);
    Color blueColor = new Color (30, 144, 255);
    
    public waterMeter() {
           rectImage.setColor(blueColor);
           rectImage.fillRect(4, 19, 56, waterLevel);
           //setImage(rectImage);
        }
    
    public void act() {
        changeBar();
        getWorld().showText("" + waterLevel, getX(), getY());
        //getWorld().showText("" + tempWaterLevel, getX(), getY()-44);
    }
    
    public void refill() {
            waterLevel = 100;
        }
        
    public boolean drain(int amount) {
            if((waterLevel - amount) >= 0) {
                    waterLevel -= amount;
                    return true;
            } else {
                    return false;
                }
        }
        
    public void changeBar() {
        if (waterLevel != tempWaterLevel) {
           rectImage.clear();
           rectImage.drawImage(ogImage, 0, 0);
           rectImage.setColor(blueColor);
           rectImage.fillRect(4, 19+(100-waterLevel), 56, waterLevel);
           setImage(rectImage);
           tempWaterLevel = waterLevel;
        }
    }
    
    public void addedToWorld() {
           rectImage.setColor(blueColor);
           rectImage.fillRect(4, 19, 56, waterLevel);
           setImage(rectImage); 
        }
}


