
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JavaSeedTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JavaSeedTile extends Seeds
{
    
    public double growthRate = 0;
    public double quality = 9;
    private double timer = (60*30) * growthRate;
    GreenfootImage stage1 = new GreenfootImage("crops/javaSeedStage1.png");
    GreenfootImage stage2 = new GreenfootImage("crops/javaSeedStage2.png");
    
    Soils soil = null;
    
    public JavaSeedTile() {
            stage = 0;
            grown = false;
            minSellAmount = 100;
            maxSellAmount = 150;
            resetTimer();
        }
    
    public void act() 
    {
        getSoil();
        timer = Math.floor(timer);
        if (timer == 0 && stage == 0) {
               resetTimer();
               stage = 1;
            }
        if (timer == 0 && stage == 1) {
               resetTimer();
               setImage(stage1);
               stage = 2;
            } else {
                if (soil != null) {
                      if (soil.watered == true) {
                        timer--;
                      }  
                    }
                }
        if (timer == 0 && stage == 2) {
               
               setImage(stage2);
               stage = 3;
               grown = true;
            }
        //getWorld().showText("" + (timer / 60), getX(), getY()-32);
        //getWorld().showText("" + stage, getX(), getY()-64);
    }
    
    private void resetTimer() {
            timer = (60*40) / quality;
        }
    
    public void getSoil() {
            soil = (Soils)getOneIntersectingObject(Soils.class);
            if (soil != null) {
                    quality = soil.soilQuality;
                    //getWorld().showText("" + quality, getX(), getY()+64);
                }
            
        }
}

