
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class moneySeedTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class moneySeedTile extends Seeds
{
    
    public double growthRate = 0;
    public double quality = 9;
    private double timer = (60*30) * growthRate;
    GreenfootImage stage1 = new GreenfootImage("crops/moneySeedStage1.png");
    GreenfootImage stage2 = new GreenfootImage("crops/moneySeedStage2.png");
    GreenfootImage stage3 = new GreenfootImage("crops/moneySeedStage3.png");
    GreenfootImage stage4 = new GreenfootImage("crops/moneySeedStage4.png");
    Soils soil = null;
    
    public moneySeedTile() {
            stage = 0;
            grown = false;
            minSellAmount = 10000;
            maxSellAmount = 12000;
            resetTimer();
        }
    
    public void act() 
    {
        getSoil();
        timer = Math.floor(timer);
        if (timer == 0 && stage == 0) {
               resetTimer();
               setImage(stage1);
               stage = 1;
            }
        if (timer == 0 && stage == 1) {
               resetTimer();
               setImage(stage2);
               stage = 2;
            }
        if (timer == 0 && stage == 2) {
               resetTimer();
               setImage(stage3);
               stage = 3;
            } 
        if (timer == 0 && stage == 3) {
               resetTimer();
               setImage(stage4);
               stage = 4;
               grown = true;
            } else {
                if (soil != null) {
                      if (soil.watered == true) {
                        timer--;
                      }  
                    }
                }
        //getWorld().showText("" + (timer / 60), getX(), getY()-32);
        //getWorld().showText("" + stage, getX(), getY()-64);
    }
    
    private void resetTimer() {
            timer = ((60*60)*3) / quality;
        }
    
    public void getSoil() {
            soil = (Soils)getOneIntersectingObject(Soils.class);
            if (soil != null) {
                    quality = soil.soilQuality;
                    //getWorld().showText("" + quality, getX(), getY()+64);
                }
            
        }
}

