import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seeds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seeds extends Tiles
{
    public int stage = 0;
    public boolean grown = false;
    public int minSellAmount = 4;
    public int maxSellAmount = 10;
    Soils soil = null;
    /**
     * Act - do whatever the Seeds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void sell() {
            MainWorld.money += (minSellAmount + Greenfoot.getRandomNumber(maxSellAmount-minSellAmount+1));
            
            ((MainWorld)getWorld()).removeObject(this);
        }
}
