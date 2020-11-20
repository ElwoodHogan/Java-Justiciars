import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class basicSoil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cruddySoilButton extends SoilButtons
{
    //Edit these fields
    private final String tileName = "Cruddy Soil";
    public double cost = 10;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
        //detects if it was clicked, and if so, spawns a blueprint for the barn building on the mouse's location
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                //                               Edit this with the tile class' name
                //                                    VVVVVVVVVVVV
                ((MainWorld)getWorld()).addObject(new cruddySoilTile(cost), mouse.getX(), mouse.getY());
            }
    }    
}
