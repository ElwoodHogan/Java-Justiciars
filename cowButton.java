import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cowButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cowButton extends AnimalButtons
{
    //Edit these fields
    private final String tileName = "Cow";
    public double cost = 15;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
        //detects if it was clicked, and if so, spawns a blueprint for the cow on the mouse's location
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new cowTile(cost), mouse.getX(), mouse.getY());
            }
    }    
}
