import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cornSeedTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cornSeedTile extends Seeds
{
    
    public double growthRate = 1;
    public int stage = 0;
    private double timer = (60*30) * growthRate;
    
    GreenfootImage stage1 = new GreenfootImage("crops/cornTeen.png");
    GreenfootImage stage2 = new GreenfootImage("crops/cornFull.png");
    
    public void act() 
    {
        if (timer == 0 && stage == 0) {
               timer = (60*30) * growthRate;
               setImage(stage1);
               stage = 1;
            } else {
                timer--;
                }
        
        if (timer == 0 && stage == 1) {
               timer = (60*30) * growthRate;
               setImage(stage2);
               stage = 2;
            } else {
                timer--;
                }
    }
    
    public void addedToWorld() {
            Soils soil = (Soils)getOneIntersectingObject(Soils.class);
            growthRate *= soil.getGrowthRate();
        }
}

