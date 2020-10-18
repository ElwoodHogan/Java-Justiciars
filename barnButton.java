import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class barnButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class barnButton extends BuildingButtons
{
    //Edit these fields
    private final String tileName = "Barn";
    public double cost = 35;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
        //detects if it was clicked, and if so, spawns a blueprint for the barn building on the mouse's location
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new BarnTile(cost), mouse.getX(), mouse.getY());
            }
    }    
}
