import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class seedShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class seedShopButton extends MainButtons
{
    private boolean menuOpen = false;
    public int seedMax = 10;
    seedShopMenu seedMenu = new seedShopMenu();
    cornSeedButton cornSeed = new cornSeedButton();
    
    //public static List<Object> seedButtonList = new ArrayList<Object>();
    
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(this) && menuOpen == false) {
                menuOpen = true;
                this.getWorld().addObject(seedMenu, 1980-120, 540);
                this.getWorld().addObject(cornSeed, 1980-120, 140+23);
                
        } else if (Greenfoot.mouseClicked(this) && menuOpen == true) {
                menuOpen = false;
                this.getWorld().removeObject(seedMenu);
                this.getWorld().removeObject(cornSeed);
            }
    }    
}
