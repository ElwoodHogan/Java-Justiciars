import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buildings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buildings extends Tiles
{
    /**
     * Act - do whatever the Buildings wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void removeThis() {
        if(mouse != null) {
                if (mouse.getButton() == 3) {
                    ((MainWorld)getWorld()).removeObject(this);
                    return;
                }
            }
    }
}
