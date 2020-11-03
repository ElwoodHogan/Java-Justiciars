import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Farms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soils extends Tiles
{
    public double soilQuality = 3;
    public boolean watered = false;
    public int timer = 60*45;
    public boolean planted = false;
    public void act() 
    {
        // Add your action code here.
    }
    
    public double getGrowthRate() {
              return this.soilQuality;  
            }
            
    public void water() {
            watered = true;
        }
}
