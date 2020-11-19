import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class harvesterButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class harvesterButton extends EquipmentButtons
{
    //Edit these fields
    private final String tileName = "Harvester";
    public double cost = 20;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
       
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new harvesterTile(cost), mouse.getX(), mouse.getY());
            }
    }    
}
